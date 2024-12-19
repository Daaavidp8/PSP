package EjemploOpenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        URL url = null;

        try {
            url = new URL("https://www.marca.com");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("URL mal formada: " + ex.getMessage(), ex);
        }

        try {
            InputStream is = url.openStream();

            StringBuilder cadena = new StringBuilder();
            int inputChar;
            while ((inputChar = is.read()) != -1) {
                if ((char)inputChar != '\n') {
                    cadena.append((char) inputChar);
                }
            }



            String regex = "<h2\\b[^>]*>(.*?)</h2>";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cadena);

            while (matcher.find()) {
                System.out.println("Contenido: " + matcher.group(0));
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

