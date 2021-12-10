package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://ukr.net");
    }

    public static void decodeURLString(String s)  {
        try {
            URL url = new URL(s);
            System.out.println("User info: " + url.getUserInfo());
            System.out.println("External from: " + url.toExternalForm());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("File: " + url.getFile());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());
            System.out.println("Port: " + url.getPort());
            System.out.println("DefaultPort: " + url.getDefaultPort());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref: " + url.getRef());
        } catch (
    MalformedURLException e) {
            System.out.println("Parameter " + s + "is not valid url");
    }

    }
}
