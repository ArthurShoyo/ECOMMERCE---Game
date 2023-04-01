


const jwtToken = JSON.parse(localStorage.getItem("user"));
console.log(jwtToken['token'])
// Faz uma requisição GET para a rota '/produtos'
fetch('http://localhost:8080/produto', {
  headers: {
    'Authorization': `Bearer ${jwtToken['token']}`
  }
})
  .then(response => {
    // Verifica se a resposta foi bem-sucedida
    if (!response.ok) {
      throw new Error('Erro ao obter produtos.');
    }

    // Processa a resposta
    return response.json();
  })
  .then(data => {
    console.log(data)
    // Obtém a referência para a tabela HTML
    const table = document.getElementById('tabela-produtos');

    // Limpa o conteúdo da tabela
    table.innerHTML = '';

    // Cria o cabeçalho da tabela
    const headerRow = table.insertRow();
    const headerCategoria = headerRow.insertCell();
    headerCategoria.textContent = 'Categoria';
    const headerPreco = headerRow.insertCell();
    headerPreco.textContent = 'Preco';

    // Adiciona as linhas de dados na tabela
    data.forEach(produto => {
      const row = table.insertRow();
      const categoria = row.insertCell();
      categoria.textContent = produto.categoria;
      const preco = row.insertCell();
      preco.textContent = produto.preco;
    });
  })
  .catch(error => {
    // Lida com o erro
  });