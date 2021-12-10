package com.javarush.task.task40.task4001;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GooglePhotos {
    public static void main(String[] args) throws IOException {
        String link = "https://t2.uc.ltmcdn.com/images/1/2/7/img_como_descargar_fotos_de_google_40721_600.jpg";
        String dir = "/home/andrey/google_photos";

        try {
            loader(link, dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loader(String link, String dir) throws IOException {
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        Path directory = Path.of(dir);
        if (Files.notExists(directory)) {
            directory = Files.createDirectory(directory);
        }
        while (true) {
            Path file = Path.of(directory.toAbsolutePath() + "/" + photoName(link));
            if (Files.exists(file)) return;
            Files.copy(is, file);
            return;
        }
    }

    public static String photoName(String link) {
        String res = "some_photo.jpg";
        Pattern pattern = Pattern.compile("^.*fotos_(.*)$");
        Matcher matcher = pattern.matcher(link);
        if (matcher.find()) {
            res = matcher.group(1);
        }
        return res;
    }
}
