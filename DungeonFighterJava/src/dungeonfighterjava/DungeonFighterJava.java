package dungeonfighterjava;

import java.util.Random;
import javax.swing.*;

public class DungeonFighterJava {
    private static final int linhas = 5;
    private static final int colunas = 10;
    private static final int numeroMonstros = linhas - 1;
    private static final int numeroPerdaFixa = 5;
    private static final int numeroPerdaAleatoria = 5;
    private static final int numeroDicas = 3;
    private static final int numeroElixires = 4;

    public static void main(String[] args) {
        
        Random geradorAleatorio = new Random();
        Tabuleiro t1 = new Tabuleiro(linhas, colunas, numeroDicas);
        
        Barbaro p1 = new Barbaro();
        t1.getCelula(0, geradorAleatorio.nextInt(9)).setPersonagem(p1);
        
        Chefao c1 = new Chefao();
        t1.getCelula(linhas-1, geradorAleatorio.nextInt(9)).setPersonagem(c1);
        
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
                t1.getCelula(i, j).setElixir(true);
            } else {
                count--;
            }
        }
        
        // Abre tela do tabuleiro (false para modo jogador, true para DEBUG);
        TabuleiroFrame telaTabuleiro = new TabuleiroFrame("Dungeon_Fighter", t1, true);
        //t1.printTabuleiro();
    }

}
