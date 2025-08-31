function descriptografar(palavraCripto, shift, progressao) {
  const alfabeto = [
    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
    "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
    "U", "V", "W", "X", "Y", "Z"
  ];

  const listaOriginal = [];
  for (let i = 0; i < alfabeto.length; i++) {
    const novoIndice = (i + shift) % alfabeto.length;
    listaOriginal.push(alfabeto[novoIndice]);
  }

  const listaProgressao = [];
  const listaRestante = [];
  for (let i = 0; i < listaOriginal.length; i++) {
    if ((i + 1) % progressao === 0) {
      listaProgressao.push(listaOriginal[i]);
    } else {
      listaRestante.push(listaOriginal[i]);
    }
  }

  const ListaCompleta = [...listaProgressao, ...listaRestante];

  let palavraReal = '';
  for (let letraCripto of palavraCripto.toUpperCase()) {
    if (letraCripto >= 'A' && letraCripto <= 'Z') {
      const indiceCripto = ListaCompleta.indexOf(letraCripto);
      if (indiceCripto !== -1) {
        palavraReal += alfabeto[indiceCripto];
      }
    } else {
      palavraReal += letraCripto;
    }
  }
  return palavraReal;
}

// Adiciona o evento ao formulário
document.querySelector('form').addEventListener('submit', function(e) {
  e.preventDefault();
  const palavraCripto = document.getElementById('palavra').value;
  const shift = parseInt(document.getElementById('shift').value, 10);
  const progressao = parseInt(document.getElementById('pa').value, 10);

  const resultado = descriptografar(palavraCripto, shift, progressao);
  document.getElementById('resultado').textContent = resultado || '---';
});