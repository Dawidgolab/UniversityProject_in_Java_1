//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.Random;

public class Gra {
    private String nazwa;
    private int liczba_iter;
    private int ogr_do;
    private int ogr_go;
    private int szukana;
    private int stan = -1;

    public Gra() {
        this.nazwa = "Gra podstawowa.";
        this.liczba_iter = 10;
        this.ogr_do = 0;
        this.ogr_go = 100;
        this.szukana = this.losuj();
    }

    public Gra(int _liczba_iter, int _ogr_do, int _ogr_go) {
        this.nazwa = "Gra zaawansowana.";
        this.liczba_iter = _liczba_iter;
        this.ogr_do = _ogr_do;
        this.setOgr_go(_ogr_go);
        this.szukana = this.losuj();
    }

    private void init() {
        this.stan = -1;
        this.liczba_iter = 10;
        this.szukana = this.losuj();
    }

    public String nextStep(String param) {
        if (this.stan == 4 || this.stan == 3) {
            this.init();
        }

        --this.liczba_iter;
        if (this.liczba_iter <= 0) {
            this.stan = 4;
        } else if (param != "") {
            int n = Integer.parseInt(param);
            if (n < this.szukana) {
                this.stan = 1;
            }

            if (n > this.szukana) {
                this.stan = 2;
            }

            if (n == this.szukana) {
                this.stan = 3;
            }
        }

        return this.toStringHTML();
    }

    public void print() {
        System.out.println("======================================");
        System.out.print(this.toString());
        System.out.println("--------------------------------------\n");
    }

    public int getOgr_go() {
        return this.ogr_go;
    }

    public void setOgr_go(int _ogr_go) {
        if (_ogr_go <= this.ogr_do) {
            this.ogr_go = this.ogr_do + 100;
        } else {
            this.ogr_go = _ogr_go;
        }

    }

    private int losuj() {
        Random rnd = new Random();
        return rnd.nextInt(this.ogr_do, this.ogr_go);
    }

    public String toStringHTML() {
        String s = "<div>";
        s = s + "Nazwa: " + this.nazwa + "<br>";
        s = s + "Liczba iteracji: " + this.liczba_iter + "<br>";
        s = s + "Ograniczenie dolne: " + this.ogr_do + "<br>";
        s = s + "Ograniczenie gorne: " + this.ogr_go + "<br>";
        s = s + "Szukana wartosc: " + this.szukana + "<br></div>";
        s = s + "<div class=\"w3-panel w3-blue\">";
        if (this.stan == -1) {
            s = s + "Zaczynamy, podaj wartosc: ";
        }

        if (this.stan == 1) {
            s = s + "Szukana wartosc jest wieksza, podaj wartosc: ";
        }

        if (this.stan == 2) {
            s = s + "Szukana wartosc jest mniejsza, podaj watrosc: ";
        }

        if (this.stan == 3) {
            s = s + "Wygrana!";
        }

        if (this.stan == 4) {
            s = s + "Przegrana!";
        }

        s = s + "</div>";
        return s;
    }

    public String toString() {
        String s = "";
        s = s + "Nazwa: " + this.nazwa + "\n";
        s = s + "Liczba iteracji: " + this.liczba_iter + "\n";
        s = s + "Ograniczenie dolne: " + this.ogr_do + "\n";
        s = s + "Ograniczenie gorne: " + this.ogr_go + "\n";
        s = s + "Szukana wartosc: " + this.szukana + "\n";
        return s;
    }

    public static void main(String[] args) {
        Gra testGra1 = new Gra();
        testGra1.print();
        Gra testGra2 = new Gra(100, 0, 1000);
        testGra2.print();
        Gra testGra3 = new Gra(100, 10, 0);
        testGra3.print();
    }
}
