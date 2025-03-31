# Torre de Hanói

![Linguagem](https://img.shields.io/badge/Linguagem-Java-blue)
![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-green)

## 📌 Sobre o Projeto
Este projeto implementa o clássico problema da **Torre de Hanói**, permitindo que o jogador resolva o desafio por meio de interações no console. Foi desenvolvido como trabalho de final de semestre para o 2º semestre do curso de **Análise e Desenvolvimento de Sistemas (ADS)** na **FATEC Bragança Paulista**.

## 🎯 Objetivo
O objetivo do jogo é mover todos os anéis da primeira torre para a terceira, seguindo as seguintes regras:
1. Apenas um disco pode ser movido por vez.
2. Um disco maior **nunca** pode ser colocado sobre um menor.
3. O jogador deve escolher os movimentos informando as torres de origem e destino.

## 🛠️ Tecnologias Utilizadas
- **Java** (versão 8+)
- **Paradigma**: Programação orientada a objetos (POO)
- **Scanner** para entrada de dados

## 📂 Estrutura do Projeto
```
TorreHanoi/
│── src/
│   │── App.java         # Classe principal do jogo
│   │── Utils.java       # Métodos auxiliares para entrada de dados
│── README.md           # Documentação do projeto
│── .gitignore          # Arquivos ignorados pelo Git
│── LICENSE             # Licença do projeto
```

## 🚀 Como Executar
### Requisitos:
- Java JDK 8 ou superior instalado

### Passos:
1. Clone o repositório:
   ```bash
   git clone https://github.com/NickYoshizawa/TorreHanoi.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd TorreHanoi/src
   ```
3. Compile os arquivos:
   ```bash
   javac App.java Utils.java
   ```
4. Execute o jogo:
   ```bash
   java App
   ```

## 📈 Complexidade do Algoritmo
A solução ideal para a Torre de Hanói segue a complexidade **O(2^n)**, onde `n` é o número de discos. O jogo também exibe a quantidade mínima de movimentos necessários para completar o desafio.

## 📌 Autor
Desenvolvido por [NickYoshizawa](https://github.com/NickYoshizawa).

## 📜 Licença
Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
