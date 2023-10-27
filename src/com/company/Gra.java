package com.company;

public class Gra {

    private String nazwa;
    private int liczba_iter;
    private int ogr_do;
    private int ogr_go;
    private int szukana;

// Konstruktor :
// 1. Konstruktor jest obowiązkowy, a jak go nie ma
// 2. Musi być publiczną metodą ,
// 3. Nazwa jego musi być taka sama jak nazwa klasy
// 4. Może przyjmować parametry ale nie musi

    public Gra(){
        this.nazwa = "Gra Podstawowa";
        this.liczba_iter = 10;
        this.ogr_do = 0;
        this.ogr_go = 100;
        this.szukana = 45;

    }


// Metod o tej samej nazwie może być TYLKO jEDNA !!!!!!!
    public Gra(int _liczba_iter,int _ogr_do, int _ogr_go){
        this.nazwa = "Gra Zaawansowana";
        this.liczba_iter = _liczba_iter;
        this.ogr_do = _ogr_do;
        this.ogr_go = _ogr_go;
        this.szukana = 3;
    }


    @Override
    public String toString() {
        String s = "";
        s += "Nazwa: " + this.nazwa + "\n";
        s += "Liczba iteracji: " + this.liczba_iter + "\n"; // this = wskazuje nam element klasy
        s += "Ograniczenie dolne: " + this.ogr_do + "\n";
        s += "Ograniczenie gorne: " + this.ogr_go + "\n";
        s += "Szukana wartosc: " + this.szukana + "\n";
        //-----------------------------
        return s;
    }


    // Metoda main gdzie testujemy różne funkcje z Klasy Gra
    public static void main(String[] args) {

        Gra testGra1 = new Gra();
        System.out.println(testGra1.toString());

        Gra testGra2 = new Gra(100,0,1000);
        System.out.println(testGra2.toString());
    }
}
