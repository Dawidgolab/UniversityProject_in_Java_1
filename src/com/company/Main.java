package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int liczba_iter = 5;
        int ogr_do = 0;
        int ogr_go = 10;
        int szukana = rnd.nextInt(ogr_do,ogr_go);
        int s;


        boolean wygrana = false;


        System.out.println("Rozpoczecie gry!!!");


        for (int i = 0; i < liczba_iter; i++) {
            System.out.println("Podaj liczbe: ");
            s = sc.nextInt();
            if (szukana == s){
                System.out.println("Zgadleś!!!");
                wygrana = true;
                break;
            }else{
                if (s < szukana){
                    System.out.println("Szukana liczba jest wieksza");
                }else{
                    System.out.println("Szukana liczba jest mniejsza");
                }
            }
        }
        if (wygrana == false){
            System.out.println("Koniec dostępnych ruchow a Twoja liczba to : " + szukana);
        }
        System.out.println("Koniec Gry!!!");







    }
}