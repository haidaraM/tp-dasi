package IfRoutard.metier.modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Saisie {

    public static String lireChaine(String invite) {
        String chaineLue = null;
        System.out.print(invite);
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            chaineLue = br.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return chaineLue;

    }

    public static Integer lireInteger(String invite) {
        Integer valeurLue = null;
        try {
            valeurLue = new Integer(lireChaine(invite));
        } catch (java.lang.NumberFormatException e) {
            System.out.println("erreur de saisie");
            valeurLue = lireInteger(invite);
        }      
        return valeurLue;
    }

     public static Integer lireInteger(String invite, List<Integer> valeursPossibles) {
        Integer valeurLue = null;
        try {
            valeurLue = new Integer(lireChaine(invite));
            if (!(valeursPossibles.contains(valeurLue))) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("erreur de saisie");
            valeurLue = lireInteger(invite, valeursPossibles);
        }
        return valeurLue;
    }
}


