/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class Celula {
    
    private final char tipo;  
    /*
    H: Heroi
    C: Chefão
    M: Monstros menores
    F: Armadilhas de perda fixa
    A: Armadilhas de perda aleatória
    *: Espaços livres
    */

    // Construtor
    public Celula(char tipo) {
        this.tipo = tipo;
        
        
        switch (tipo){
            case 'H':
                switch ()
            break;
            case 'C':
                
            break;
            case 'M':
                
            break;
            case 'F':
                
            break;
            case 'A':
                
            break;
            case '*':
                
            break;    
        }
    }

    public char getTipo() {
        return tipo;
    }
    
}
