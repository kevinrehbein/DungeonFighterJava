# DungeonFighterJava 🛡️⚔️

**DungeonFighterJava** é um jogo de estratégia e RPG de tabuleiro desenvolvido como parte de estudos de Programação Orientada a Objetos. O jogador assume o papel de um herói que deve atravessar um tabuleiro perigoso, gerir os seus recursos (Vida, Força e Defesa) e derrotar o "Chefão" final.

---

## Mecânicas de Jogo

O jogo funciona através de uma interface de grelha onde cada célula esconde um destino:

- **Combate:** Encontros com Monstros Menores ou o Chefão. O dano é calculado com base na Força do atacante e Defesa do defensor.
- **Armadilhas:** Células que podem retirar vida fixa ou uma quantidade aleatória (sorte).
- **Consumíveis:** Encontre Elixires e Poções para restaurar atributos antes da próxima batalha.

---

## Classes de Heróis

Cada herói possui uma distribuição de atributos única:

| Classe | Estilo de Jogo |
|--------|----------------|
| ⚔️ **Guerreiro** | Equilíbrio ideal entre ataque e defesa. |
| 🪓 **Bárbaro** | Focado em força bruta, ideal para quem prefere finalizar combates rapidamente. |
| 🛡️ **Paladino** | O "tanque" do grupo, com a maior resistência e defesa do jogo. |

---

## Arquitetura e Design

O projeto foi construído utilizando conceitos avançados de **POO**:

- **Herança:** Classes base `Personagem` e `Armadilha` estendidas para tipos específicos.
- **Polimorfismo:** Tratamento genérico de eventos no tabuleiro, independentemente do tipo de inimigo ou armadilha.
- **Encapsulamento:** Gestão rigorosa dos atributos dos heróis para garantir a integridade da lógica de jogo.
- **GUI (Java Swing):** Interface totalmente visual com troca dinâmica de frames (`MainFrame`, `HeroesFrame`, `TabuleiroFrame`).

---

## 📁 Estrutura do Repositório

```
DungeonFighterJava/
├── src/
│   └── dungeonfighterjava/
│       ├── *.java               # Código-fonte Java
│       └── images/              # Assets visuais (heróis, monstros e itens)
├── UMLDiagrams/                 # Diagramas de classe do sistema
└── nbproject/                   # Configuração do NetBeans IDE
```

---

## Como Jogar

**Pré-requisitos:** Ter o JRE/JDK 8 ou superior instalado.

**1. Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/DungeonFighterJava.git
```

**2. Importe e execute:**
- Abra o projeto no NetBeans ou em outra IDE Java.
- Execute a classe principal `DungeonFighterJava.java`.

**3. Objetivo:**
Selecione o seu herói, clique nas células do tabuleiro para avançar e chegue ao fim da masmorra com vida suficiente para o duelo final contra o Chefão.

---

*Desenvolvido como projeto académico focando em estruturas de dados e interfaces gráficas em Java.*
