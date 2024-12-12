package InetUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws UnknownHostException {
        String[] urls = {"localhost","www.google.es","www.baidu.com", "www.marca.es"};

        for (String url : urls) {
            InetAddress inetAddress = InetAddress.getByName(url);
            System.out.print("SALIDA PARA ");
            String dns;
            if (url.startsWith("www.")){
                url.replace("www.","");
            }
            if (url.contains(".")){
                dns = url.split("\\.")[1].toUpperCase(Locale.ROOT);
            }else {
                dns = url.toUpperCase();
            }
            System.out.println(dns + ":");
            System.out.println("\tMetodo getByName(): " + inetAddress);
            System.out.println("\tMetodo getLocalHost(): " + InetAddress.getLocalHost());
            System.out.println("\tMetodo getHostName(): " + inetAddress.getHostName());
            System.out.println("\tMetodo getHostAddress(): " + inetAddress.getHostAddress());
            System.out.println("\tMetodo toString(): " + inetAddress);
            System.out.println("\tMetodo getCanonicalHostName(): " + inetAddress.getCanonicalHostName());
            if (!url.equals("localhost")) {
                System.out.println("\tDIRECCIONES IP PARA: " + url);
                for(InetAddress address : InetAddress.getAllByName(url)) {
                    System.out.println("\t\t" + address);
                }
            }

            System.out.println();
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println();

        }



    }
}