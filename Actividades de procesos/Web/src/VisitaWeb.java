public class VisitaWeb {
    public static void main(String[] args) throws Exception {
        String[] paginas = SepararPaginas(args[0]);
        if (paginas.length > 3){
            throw new Exception("Demasiadas Webs!!");
        }else {
            if (paginas.length == 1){
                Process p = new ProcessBuilder("firefox",paginas[0]).start();
            }else if (paginas.length == 2){
                Process p = new ProcessBuilder("firefox",paginas[0],paginas[1]).start();
            }else {
                Process p = new ProcessBuilder("firefox",paginas[0],paginas[1],paginas[2]).start();
            }
        }

    }

    public static String[] SepararPaginas(String paginas) {
        return paginas.split("@");
    }
}
