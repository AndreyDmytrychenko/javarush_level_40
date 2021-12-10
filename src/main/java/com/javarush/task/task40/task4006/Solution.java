package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/*
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("https://www.codejava.net/java-se/networking/java-socket-client-examples-tcp-ip"));
    }

    public static void getSite(URL url) {
        System.out.println(url.getPath());

        try {
                //Instantiate a new socket
                Socket s = new Socket(url.getHost(), 80);

                //Instantiates a new PrintWriter passing in the sockets output stream
                PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

                //Prints the request string to the output stream
            writer.println("GET " + url.getPath()+ " HTTP/1.1");
            writer.println("Host: " + url.getHost());
            writer.println("User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:84.0) Gecko/20100101 Firefox/84.0");
            writer.println("Accept: text/html");
            writer.println("Connection: close");
            writer.println();


                //Creates a BufferedReader that contains the server response
                BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String outStr;

                //Prints each line of the response
                while((outStr = bufRead.readLine()) != null){
                    System.out.println(outStr);
                }

                bufRead.close();
                writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
