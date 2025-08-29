package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String palavraCripto = "SWZD"; //

        // Alfabeto original
        List<String> alfabeto = new ArrayList<>(Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
        ));

        int shift = 16; // quantidade de posições para deslocar
        System.out.println("Shift: " + shift);
        
     // Progressão
        int progressao = 3;
        System.out.println("PA:" + progressao);

        // Cria a lista com o shift
        List<String> listaOriginal = new ArrayList<>();
        for (int i = 0; i < alfabeto.size(); i++) {
            int novoIndice = (i + shift) % alfabeto.size();
            listaOriginal.add(alfabeto.get(novoIndice));
        }

        System.out.println("Lista com shift: " + alfabeto);

        

        List<String> listaProgressao = new ArrayList<>();
        List<String> listaRestante = new ArrayList<>();

        for (int i = 0; i < listaOriginal.size(); i++) {
            if ((i + 1) % progressao == 0) {
                listaProgressao.add(listaOriginal.get(i));
            } else {
                listaRestante.add(listaOriginal.get(i));
            }
        }

        List<String> ListaCompleta = new ArrayList<>();
        ListaCompleta.addAll(listaProgressao);
        ListaCompleta.addAll(listaRestante);

        System.out.println("Lista completa:  " + ListaCompleta);

        // Descriptografar a palavra
        StringBuilder palavraReal = new StringBuilder();
        for (char letraCripto : palavraCripto.toCharArray()) {
            if (letraCripto >= 'A' && letraCripto <= 'Z') {
                // Converter char para String
                int indiceCripto = ListaCompleta.indexOf(String.valueOf(letraCripto));

                if (indiceCripto != -1) {
                    // Pega a letra original pelo índice
                    palavraReal.append(alfabeto.get(indiceCripto));
                }
            } else {
                palavraReal.append(letraCripto);
            }
        }

        System.out.println("Palavra criptografada: " + palavraCripto);
        System.out.println("Palavra real: " + palavraReal);
	}
}
