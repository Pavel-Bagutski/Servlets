package org.example;

import java.net.*;
import java.io.*;

public class Loader2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/Servlets/hello_with_name");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            String data = "param1=value1&param2=value2";
            OutputStream os = con.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}