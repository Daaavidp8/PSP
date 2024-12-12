package InstanciarUrls;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;

public class main {
    public static void main(String[] args) throws UnknownHostException {


        String[] urls = {"http://docs.oracle.com/","http://docs.oracle.com/javase/23","http://docs.oracle.com:123/javase/23"};
        URL urlLoop = null;

        for (String url : urls) {
            try {
                urlLoop = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            System.out.println("URL Completa: " + url);
            System.out.println("\tMetodo getProtocol(): " + urlLoop.getProtocol());
            System.out.println("\tMetodo getHost(): " + urlLoop.getHost());
            System.out.println("\tMetodo getPort(): " + urlLoop.getPort());
            System.out.println("\tMetodo getFile(): " + urlLoop.getFile());
            System.out.println("\tMetodo getUserInfo(): " + urlLoop.getUserInfo());
            System.out.println("\tMetodo getPath(): " + urlLoop.getPath());
            System.out.println("\tMetodo getAuthority(): " + urlLoop.getAuthority());
            System.out.println("\tMetodo getQuery(): " + urlLoop.getQuery());
            System.out.println("\tMetodo getDefaultPort(): " + urlLoop.getDefaultPort());

            System.out.println();
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println();

        }
    }
}
