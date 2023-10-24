package com.company;

public class Gra {

    private int liczba_iter;


    @Override
    public String toString() {
        String s = "";
        s += "Gra \n";
        s += "Liczba iteracji: " + this.liczba_iter + "\n"; // this = wskazuje nam element klasy

        //-----------------------------
        return s;
    }

    // Metoda main gdzie testujemy różne funkcje z Klasy Gra
    public static void main(String[] args) {

        Gra testGra1 = new Gra();
        System.out.println(testGra1.toString());



    }
}
