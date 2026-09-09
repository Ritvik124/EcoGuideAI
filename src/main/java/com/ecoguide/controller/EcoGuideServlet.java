package com.ecoguide.controller;

import com.ecoguide.dao.QuestionDAO;
import com.ecoguide.model.Question;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Current prototype architecture: servlet -> keyword analysis -> generateAIResponse().
 * A future AI service can replace generateAIResponse() without changing the browser UI.
 */
@WebServlet("/api/ask")
public class EcoGuideServlet extends HttpServlet {
    private static final int MAX_QUESTION_LENGTH = 500;
    private static final Pattern QUESTION_FIELD = Pattern.compile("\\\"question\\\"\\s*:\\s*\\\"((?:\\\\.|[^\\\"])*)\\\"");
    private final QuestionDAO questionDAO = new QuestionDAO();

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
        addCorsHeaders(request, response);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addCorsHeaders(request, response);
        response.setContentType("application/json;charset=UTF-8");
        String body = request.getReader().lines().reduce("", (a, b) -> a + b);
        String userQuestion = extractQuestion(body).trim();

        if (userQuestion.isEmpty()) {
            writeJson(response, "{\"success\":false,\"message\":\"Please enter a question.\"}");
            return;
        }
        if (userQuestion.length() > MAX_QUESTION_LENGTH) {
            writeJson(response, "{\"success\":false,\"message\":\"Please keep your question within 500 characters.\"}");
            return;
        }

        Recommendation recommendation = generateAIResponse(userQuestion);
        boolean saved = true;
        try {
            questionDAO.save(new Question(userQuestion, recommendation.answer(), recommendation.category(), recommendation.ecoScore()));
        } catch (Exception exception) {
            saved = false; // The recommendation is still useful; no internal database details are exposed.
            getServletContext().log("EcoGuide AI could not save an anonymous question.", exception);
        }
        String json = "{\"success\":true,\"question\":\"" + escapeJson(userQuestion) + "\","
                + "\"answer\":\"" + escapeJson(recommendation.answer()) + "\","
                + "\"category\":\"" + recommendation.category() + "\","
                + "\"ecoScore\":" + recommendation.ecoScore() + ",\"sdg\":\"" + recommendation.sdg() + "\","
                + "\"databaseSaved\":" + saved + "}";
        writeJson(response, json);
    }

    /** Current prototype AI logic: understandable keyword matching, not a scientific environmental score. */
    private Recommendation generateAIResponse(String question) {
        String q = question.toLowerCase(Locale.ROOT);
        if (contains(q, "water", "tap", "shower", "leak", "rainwater")) return new Recommendation("Water", 85, "SDG 6", "Here are practical ways to save water:\n1. Fix leaking taps quickly.\n2. Take shorter showers.\n3. Turn off the tap while brushing.\n4. Reuse safe leftover water for plants.\n5. Collect rainwater where practical.");
        if (contains(q, "electric", "energy", "power", "light", "appliance", "battery")) return new Recommendation("Energy", 90, "SDG 7", "Here are practical ways to save electricity:\n1. Turn off unused lights and fans.\n2. Choose LED bulbs.\n3. Unplug idle chargers and devices.\n4. Use daylight when possible.\n5. Use energy-efficient appliance settings.");
        if (contains(q, "food", "leftover", "meal", "compost", "grocery")) return new Recommendation("Food", 82, "SDG 12", "Here are practical ways to reduce food waste:\n1. Plan meals before shopping.\n2. Store food correctly.\n3. Serve smaller portions first.\n4. Use safe leftovers creatively.\n5. Compost unavoidable food scraps.");
        if (contains(q, "plastic", "waste", "recycle", "trash", "garbage", "packaging")) return new Recommendation("Waste", 88, "SDG 12", "Here are practical ways to reduce waste:\n1. Carry a reusable bottle and bag.\n2. Avoid single-use plastic items.\n3. Separate recyclable and organic waste.\n4. Repair or donate usable products.\n5. Choose products with minimal packaging.");
        if (contains(q, "transport", "bus", "train", "cycle", "bike", "car", "travel", "walk")) return new Recommendation("Transportation", 86, "SDG 11", "Here are practical sustainable transportation choices:\n1. Walk or cycle for short trips.\n2. Use public transport when available.\n3. Share rides with others.\n4. Combine errands into one journey.\n5. Keep vehicle tyres properly inflated.");
        if (contains(q, "habit", "daily", "sustain", "eco", "environment", "green")) return new Recommendation("Daily Habits", 80, "SDG 13", "Here are simple daily sustainable habits:\n1. Carry reusable essentials.\n2. Buy only what you need.\n3. Switch off devices after use.\n4. Sort waste at home.\n5. Share sustainability ideas with others.");
        return new Recommendation("Daily Habits", 75, "SDG 12", "I can currently help with water, energy, waste, food, transportation, and daily sustainability habits. Try asking, for example: How can I save water?");
    }

    private boolean contains(String text, String... keywords) { for (String keyword : keywords) if (text.contains(keyword)) return true; return false; }
    private String extractQuestion(String body) { Matcher match = QUESTION_FIELD.matcher(body); return match.find() ? unescapeJson(match.group(1)) : ""; }
    private String unescapeJson(String value) { return value.replace("\\\\\"", "\"").replace("\\\\n", "\n").replace("\\\\\\\\", "\\"); }
    private String escapeJson(String value) { return value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", ""); }
    private void writeJson(HttpServletResponse response, String json) throws IOException { response.getWriter().write(json); }

    private void addCorsHeaders(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader("Origin");
        String allowed = System.getenv().getOrDefault("ALLOWED_ORIGIN", "http://localhost:8080");
        if (origin != null && (origin.equals(allowed) || origin.matches("http://localhost(:\\d+)?"))) {
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Vary", "Origin");
            response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        }
    }

    private record Recommendation(String category, int ecoScore, String sdg, String answer) { }
}
