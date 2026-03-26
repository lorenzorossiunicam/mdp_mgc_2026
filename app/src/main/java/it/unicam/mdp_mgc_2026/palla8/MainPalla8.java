package it.unicam.mdp_mgc_2026.palla8;

import java.util.Scanner;

public class MainPalla8 {

    public void main(String[] args){
        System.out.println("Benvenuto al gioco della Palla8");
        Scanner scanner = new Scanner(System.in);
        Palla8 p = new Palla8();

        while (true){
            System.out.println("Inserisci una domanda o scrivi ESCI per terminare...");
            String domanda = scanner.nextLine();
            if(domanda.equalsIgnoreCase("ESCI")){
                break;
            }
            System.out.println(p.getRisposta());
        }

        scanner.close();
    }
}
