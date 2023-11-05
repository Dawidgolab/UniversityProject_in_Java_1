package com.company;

import com.company.Gra;

// Server
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

// Obsługa servera
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    static Gra gra;
    public static void main(String[] args) throws IOException {

        Server.gra = new Gra();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0); // localhost:8080
        server.createContext("/home",new MyHandler());
        server.start();


    }


    static class MyHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange)throws  IOException{
            String response = "<html>" +
                    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">" +
                    "<div class=\"w3-panel w3-red\"><h1>Gra</h1></div>" +
                    "<div class=\"w3-panel w3-green w3-padding-16\">" + Server.gra.toStringHtml() + "</div>" +
                    "<div class=\"w3-panel w3-blue w3-padding\" ><input type = \"number\" id = \"id01\" ></div>" +
                    "<div class=\"w3-panel w3-blue w3-padding\"><button class = \"w3-button w3-orange w3-round\" onclick= \"dalej()\" >Dalej</button></div>" +
                    "<script>" +
                    "function dalej(){ " +
                    "var nextUrl = \"/home?n=\" ; " +
                    "var number = document.getElementById(\"id01\").value; " +
                    "window.location.href = nextUrl + number;" +
                    "}" +
                    "</script>" +
                    "</html>";

            exchange.sendResponseHeaders(200,response.length()); // zadanie zostało przetworzone prawidłowo
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }










}
