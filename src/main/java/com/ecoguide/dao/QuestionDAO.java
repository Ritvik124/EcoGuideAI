package com.ecoguide.dao;

import com.ecoguide.model.Question;
import com.ecoguide.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** JDBC-only persistence layer. PreparedStatement prevents SQL injection. */
public class QuestionDAO {
    private static final String INSERT = "INSERT INTO questions (question, answer, category, eco_score) VALUES (?, ?, ?, ?)";

    public void save(Question question) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getAnswer());
            statement.setString(3, question.getCategory());
            statement.setInt(4, question.getEcoScore());
            statement.executeUpdate();
        }
    }
}
