//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int liczba_iter = 3;
        int ogr_do = 0;
        int ogr_go = 10;
        int szukana = rnd.nextInt(ogr_do, ogr_go);
        System.out.println(szukana);
        boolean wygrana = false;
        System.out.println("Rozpoczecie gry.");

        for(int i = 0; i < liczba_iter; ++i) {
            System.out.print("Podaj liczbe: ");
            int s = sc.nextInt();
            if (szukana == s) {
                System.out.println("Zgadles!");
                wygrana = true;
                break;
            }

            if (s < szukana) {
                System.out.println("Szukana wartosc jest wieksza.");
            } else {
                System.out.println("Szukana wartosc jest mniejsza.");
            }
        }

        if (!wygrana) {
            System.out.println("Koniec dostępnych ruchow.");
        } else {
            System.out.println("Koniec gry.");
        }

    }
}
