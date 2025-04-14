document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".login__form");

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const email = form.email.value.trim();
    const password = form.password.value;

    if (!email || !password) {
      alert("Por favor, preencha todos os campos.");
      return;
    }

    // Simulação de login
    console.log("Login realizado com:", { email, password });

    // Aqui você pode redirecionar, fazer chamada API, etc.
    alert("Login efetuado com sucesso!");
  });
});