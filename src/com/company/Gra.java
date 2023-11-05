package com.company;

import java.util.Random;

public class Gra {

    private String nazwa;
    private int liczba_iter;
    private int ogr_do;
    private int ogr_go;
    private int szukana;

// Konstruktor :
// 1. Konstruktor jest obowiązkowy, a jak go nie ma tworzony jest domyślny
// 2. Musi być publiczną metodą ,
// 3. Nazwa jego musi być taka sama jak nazwa klasy
// 4. Może przyjmować parametry ale nie musi

    public Gra(){ // Gra_
        this.nazwa = "Gra Podstawowa";
        this.liczba_iter = 10;
        this.ogr_do = 0;
        this.ogr_go = 100;
        this.szukana = 45;

    }


    public void print(){
        System.out.println("==================================================");
        System.out.print(this.toString());
        System.out.println("----------------------------------------------------\n");
    }


// Metod o tej samej nazwie może być TYLKO jEDNA
// !!!!!!!
    public Gra(int _liczba_iter,int _ogr_do, int _ogr_go){  //Gra_int_int_int
        this.nazwa = "Gra Zaawansowana";
        this.liczba_iter = _liczba_iter;
        this.ogr_do = _ogr_do;
        this.setOgr_go(_ogr_go);// <---- this.ogr_go = _ogr_go;
        this.szukana = this.losuj();
    }


    private int losuj(){
        //Random rnd = new Random();
        //return rnd.nextInt(this.ogr_do,this.ogr_go);
        return new Random().nextInt(this.ogr_do,this.ogr_go);

    }

    public String toStringHtml() {
        String s = "<div>";
        s += "Nazwa: " + this.nazwa + "<br>";
        s += "Liczba iteracji: " + this.liczba_iter + "<br>"; // this = wskazuje nam element klasy
        s += "Ograniczenie dolne: " + this.ogr_do + "<br>";
        s += "Ograniczenie gorne: " + this.ogr_go + "<br>";
        s += "Szukana wartosc: " + this.szukana + "<br></div>";
        //-----------------------------
        return s;
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


// ** Hermetyzacja - określanie zakresu do którego pozwalamy się dostawać do naszej klasy/gettery i settery/

    public int getOgr_go() {
        return ogr_go;
    }

// setter słóży do rozwiązywania takich problemów jak w tym przypadku ograniczenie gorne
    public void setOgr_go(int _ogr_go) {
        if (_ogr_go <= this.ogr_do){
            this.ogr_go = ogr_do + 100;
        }else{
            this.ogr_go = _ogr_go;
        }
    }

    // Metoda main gdzie testujemy różne funkcje z Klasy Gra
    public static void main(String[] args) {

        Gra testGra1 = new Gra();
        testGra1.print();

        Gra testGra2 = new Gra(100,0,1000);
        testGra2.print();

        Gra testGra3 = new Gra(100,10,0);
        testGra3.print();
    }
}
