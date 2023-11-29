package com.company;
import com.company.Gra;

// Server
import com.sun.net.httpserver.HttpServer; // Reprezentuje server HTTP
import com.sun.net.httpserver.HttpHandler; // Interaface do obsługi żądań HTTP
import com.sun.net.httpserver.HttpExchange; // Obiekt reprezentujący pojedyńcze żądanie i odpowiedz HTTP

// Obsługa servera
import java.io.IOException; // to wyjątek związany z operacjami wejścia/wyjścia
import java.io.OutputStream; // jest standardowym mechanizmem w Java do zapisywania danych binarnych, a w przypadku obsługi serwera HTTP, jest to niezbędne do wysyłania odpowiedzi z serwera do klienta.
import java.net.InetSocketAddress; // reprezentuje adres IP i numer portu.

public class Server {
    static Gra gra;
    public static void main(String[] args) throws IOException { // throws - deklaruje wyjątek(I/O)

        Server.gra = new Gra();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0); // localhost:8080
        server.createContext("/home",new MyHandler());
        System.out.println(">> Server start");
        server.start(); // Uruchomienie serwera
    }


    static class MyHandler implements HttpHandler{ // implementujemy classe HttpHandler
        @Override
        public void handle(HttpExchange exchange)throws  IOException{

            String query = exchange.getRequestURI().getQuery();
            System.out.println(query);
            String param = "";
            if (query != null) {
                param = query.substring(2);
            }
            System.out.println("Param: " + param);

          //  System view = Server.gra.nextStep(param);



            String response = "<html>" +
                    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">" +
                    "<div class=\"w3-panel w3-red\"><h1>Gra</h1></div>" +
                    "<div class=\"w3-panel w3-green w3-padding-16\">" + Server.gra.toStringHtml()  + "</div>" +
                    "<div class=\"w3-panel w3-blue w3-padding\"><input type=\"number\" id=\"id01\"></div>" +
                    "<div class=\"w3-panel w3-blue w3-padding\"><button class=\"w3-button w3-orange w3-round\"  onclick=\"dalej()\">Dalej</button></div>" +
                    "<script>" +
                    "function dalej(){ " +
                    "var nextUrl = \"/home?n=\" ;" +
                    "var number = document.getElementById(\"id01\").value; " +
                    "window.location.href = nextUrl + number;" +
                    "}"+
                    "</script>" +
                    "</html>";

            exchange.sendResponseHeaders(200,response.length()); // Wysłanie nagłówka odpowiedzi HTTP z kodem 200 (OK) i długością treści odpowiedzi.
            OutputStream os = exchange.getResponseBody(); // Pobranie strumienia wyjściowego z obiektu HttpExchange, zapisanie w nim bajtów treści odpowiedzi, a następnie zamknięcie strumienia.
            os.write(response.getBytes());
            os.close();
        }
    }

}
