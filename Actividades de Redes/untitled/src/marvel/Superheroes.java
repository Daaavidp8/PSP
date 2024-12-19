package marvel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Superheroes {
    public void getImagesTags(){
        URL url = null;

        try {
            url = new URL("http://mural.uv.es/franpevi/index.html");
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


            File myObj = new File("src/marvel/heroes.txt");
            Scanner myReader = new Scanner(myObj);
            Map<String, String> map = new HashMap<String, String>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ArrayList<String> heroe = new ArrayList<>(List.of(data.split(";")));

                String regex = "<img\\b[^>]*class=\"[^\"]*" + heroe.get(0) + "[^\"]*\"[^>]*>";
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(cadena);

                while (matcher.find()) {
                    heroe.add(matcher.group());
                    StringBuilder html =
                            new StringBuilder("<tr><td>" + heroe.get(heroe.size() - 1) + "</td>");
                    for (int i = 0; i < heroe.size() - 1; i++) {
                        html.append("<td>").append(heroe.get(i)).append("</td>");
                    }
                    html.append("</tr>");

                    map.compute(heroe.get(0).startsWith("M") ? "Marvel" : "Dc", (key, value) -> value == null ? html.toString() : value + html);
                }

            }


                for (Map.Entry<String, String> entry : map.entrySet()) {
                    escribirFichero(entry.getKey() + ".html", entry.getValue());
                }

            myReader.close();

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void escribirFichero(String fichero,String cadena){
        try {
            String path = "src/marvel/" + fichero;
            System.out.println(fichero);
            File myObj = new File(path);

            FileWriter myWriter = new FileWriter(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            String html = "<html><head><title>" + fichero.split("\\.")[0] + "</title></head><body><table>"
                    + "<thead><tr>"
                    + "<th>Imagen</th><th>Id</th><th>Superheroe</th><th>Nombre</th><th>Descripción</th>"
                    + "</tr></thead>"
                    + "<tbody>" + cadena + "</tbody></table></body></html>";

            System.out.println(html);
            myWriter.write(html);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
