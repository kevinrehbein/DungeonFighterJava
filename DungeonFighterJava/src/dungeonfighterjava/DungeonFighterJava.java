package dungeonfighterjava;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DungeonFighterJava {
    private final int linhas = 5;
    private final int colunas = 10;
    private final int numeroMonstros = linhas - 1;
    private final int numeroPerdaFixa = 5;
    private final int numeroPerdaAleatoria = 5;
    private final int numeroDicas = 3;
    private final int numeroElixires = 4;
    
    private Tabuleiro t1;
    private TabuleiroFrame tabuleiroScreen = null;
       
    Random geradorAleatorio = new Random();
    
    public DungeonFighterJava(Barbaro heroi){
        
        t1 = new Tabuleiro(linhas, colunas, numeroDicas);
        t1.getCelula(0, geradorAleatorio.nextInt(9)).setPersonagem(heroi);
        iniciarJogo();
    }
    
    public DungeonFighterJava(Guerreiro heroi){
        
        t1 = new Tabuleiro(linhas, colunas, numeroDicas);
        t1.getCelula(0, geradorAleatorio.nextInt(9)).setPersonagem(heroi);
        iniciarJogo();
    }
    
    public DungeonFighterJava(Paladino heroi){
        
        t1 = new Tabuleiro(linhas, colunas, numeroDicas);
        t1.getCelula(0, geradorAleatorio.nextInt(9)).setPersonagem(heroi);
        iniciarJogo();
    }

    public void iniciarJogo(){
        
        t1.getCelula(linhas-1, geradorAleatorio.nextInt(9)).setPersonagem(new Chefao());
        
        // posiciona Monstros Menores
        for (int count = 0; count < numeroMonstros; count++) {
            int i = geradorAleatorio.nextInt(5);  
            int j = geradorAleatorio.nextInt(9);  
            if (t1.getCelula(i, j).isEmpty()) {
                t1.getCelula(i, j).setPersonagem(new MonstroMenor());
            } else {
                count--;
            }
        }
        
        // posiciona Armadilhas de Perda Fixa
        for (int count = 0; count < numeroPerdaFixa; count++) {
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);
            if (t1.getCelula(i, j).isEmpty()) {
                t1.getCelula(i, j).setArmadilha(new ArmadilhaPerdaFixa());
            } else{
                count--;
            }
        }
        
        // posiciona Armadilhas de Perda Aleatoria
        for (int count = 0; count < numeroPerdaAleatoria; count++) {
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);
            if (t1.getCelula(i, j).isEmpty()) {
                t1.getCelula(i, j).setArmadilha(new ArmadilhaPerdaAleatoria());
            } else {
                count--;
            }
        }
        
        // posiciona elixires
        for (int count = 0; count < numeroElixires; count ++){
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);
            if (t1.getCelula(i, j).isEmpty()) {
                t1.getCelula(i, j).setElixir();
            } else {
                count--;
            }
        }
        
        tabuleiroScreen = new TabuleiroFrame("Dungeon_Fighter", t1);

    }

    public TabuleiroFrame getTabuleiroScreen() {
        return tabuleiroScreen;
    }
    
}
