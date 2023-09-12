package org.example;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    public Loader() {
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String lastName ="Pavel";   //scanner.nextLine();
        String firstName ="Bogutski";  //scanner.nextLine();
        String var10000 = URLEncoder.encode(firstName, "UTF-8");
        String urlParameters = "?firstName=" + var10000 + "&lastName=" + URLEncoder.encode(lastName, "UTF-8");
        String url = "http://localhost:8080/Servlets/hello_with_name" + urlParameters;


        List<String> arrList = new ArrayList<String>();

        List <String> hashList = new LinkedList<>();

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");


        con.setDoInput(true);
        con.setDoOutput(true);
        con.setInstanceFollowRedirects(true);

        con.setRequestProperty("Location", "Minsk");
        con.addRequestProperty("User-agent", "Chrome/13.0.782.215 Safari/535.1");


        System.out.println(con.getRequestProperties().toString());

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        System.out.println(response.toString());

    }
}