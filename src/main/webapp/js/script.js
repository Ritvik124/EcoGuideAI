const form = document.querySelector('#ask-form');
if (form) {
  const input = document.querySelector('#question');
  const messages = document.querySelector('#messages');
  const error = document.querySelector('#form-error');
  // Same-server Tomcat deployments include a context path such as /EcoGuideAI.
  // Vercel can override this with a full Java backend URL in config.js.
  const configuredApiBase = (window.ECOGUIDE_API_BASE_URL || '').replace(/\/$/, '');
  const localContextPath = window.location.pathname.includes('/EcoGuideAI') ? '/EcoGuideAI' : '';
  const apiBase = configuredApiBase || localContextPath;
  const queryQuestion = new URLSearchParams(window.location.search).get('q');
  if (queryQuestion) input.value = queryQuestion;

  form.addEventListener('submit', async (event) => {
    event.preventDefault(); error.textContent = '';
    const question = input.value.trim();
    if (!question) { error.textContent = 'Please enter a question.'; return; }
    addBubble(question, 'user'); input.value = ''; form.querySelector('button').disabled = true;
    try {
      const response = await fetch(`${apiBase}/api/ask`, {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({question})});
      const data = await response.json();
      if (!data.success) throw new Error(data.message || 'Unable to answer that question.');
      const bubble = document.createElement('div'); bubble.className = 'bubble bot result';
      bubble.innerHTML = `<p>${escapeHtml(data.answer).replace(/\n/g, '<br>')}</p><div class="meta"><span>Category: <b>${escapeHtml(data.category)}</b></span><span>Eco Score: <b>${data.ecoScore}/100</b></span><span>Related SDG: <b>${escapeHtml(data.sdg)}</b></span></div><small>Eco Score — Prototype Indicator</small>`;
      messages.appendChild(bubble); bubble.scrollIntoView({behavior: 'smooth', block: 'nearest'});
      if (!data.databaseSaved) error.textContent = 'Recommendation shown. Database saving is unavailable until local database configuration is completed.';
    } catch (err) { error.textContent = err.message || 'Something went wrong. Please try again.'; }
    finally { form.querySelector('button').disabled = false; input.focus(); }
  });
  function addBubble(text, type) { const bubble = document.createElement('div'); bubble.className = `bubble ${type}`; bubble.textContent = text; messages.appendChild(bubble); }
  function escapeHtml(text) { const div = document.createElement('div'); div.textContent = text; return div.innerHTML; }
}
