/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Tabuleiro {
        
    private final int linhas;
    private final int colunas;
    private final Celula[][] tabuleiro;
    private int i, j;
    private final int numDicas;

    // Construtor 
    public Tabuleiro(int linhas, int colunas, int numDicas) {
    this.linhas = linhas;
    this.colunas = colunas;
    this.tabuleiro = new Celula[linhas][colunas];
    this.numDicas = numDicas;
    criarTabuleiro();
    }

    private void criarTabuleiro() {
        for (i = 0; i < linhas; i++) {
            for (j = 0; j < colunas; j++) {
                tabuleiro[i][j] = new Celula( i, j);
            }
        }
    }

    public void moverHeroi (Paladino heroi, int origemX, int origemY, int destinoX, int destinoY){
        Celula celulaOrigem = getCelula(origemX, origemY);
        Celula celulaDestino = getCelula(destinoX, destinoY);

        if (celulaOrigem.getPersonagem() != null){
            this.getCelula(origemX, origemY).removerPersonagem();
            this.getCelula(destinoX, destinoY).setPersonagem(heroi);
        }
        celulaOrigem.setEmpty(true);
        celulaDestino.setEmpty(false);
    }
    
    public void moverHeroi (Guerreiro heroi, int origemX, int origemY, int destinoX, int destinoY){
        Celula celulaOrigem = getCelula(origemX, origemY);
        Celula celulaDestino = getCelula(destinoX, destinoY);

        if (celulaOrigem.getPersonagem() != null){
            this.getCelula(origemX, origemY).removerPersonagem();
            this.getCelula(destinoX, destinoY).setPersonagem(heroi);
        }
        celulaOrigem.setEmpty(true);
        celulaDestino.setEmpty(false);
    }
    
    public void moverHeroi (Barbaro heroi , int origemX, int origemY, int destinoX, int destinoY){
        Celula celulaOrigem = getCelula(origemX, origemY);
        Celula celulaDestino = getCelula(destinoX, destinoY);

        if (celulaOrigem.getPersonagem() != null){
            this.getCelula(origemX, origemY).removerPersonagem();
            this.getCelula(destinoX, destinoY).setPersonagem(heroi);
        }
        celulaOrigem.setEmpty(true);
        celulaDestino.setEmpty(false);
    }
    
    public Celula getCelula (int x, int y){
        return tabuleiro[x][y];
    }
    
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
    
    public int getNumDicas(){
        return numDicas;
    }
    
    public void printTabuleiro() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro[i][j].getPersonagem() != null){
                    System.out.printf("%s ", tabuleiro[i][j].getPersonagem().getNome());
                } else if (tabuleiro[i][j].getArmadilha() != null) {
                    System.out.printf("%s ", tabuleiro[i][j].getArmadilha().getNome());
                } else if (tabuleiro[i][j].isElixir()){
                    System.out.printf("Elixir ");
                } else System.out.printf("X "); // X representa célula vazia
            }
            System.out.println();     
        }
    }
    
}
