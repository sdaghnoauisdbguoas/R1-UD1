
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public  class EJ2 {
    
    public static class Peleador{
        private String nombre;
        private String stance;
        private int edad;
        private int combates;
        private boolean invicto;

        public Peleador(int combates, int edad, boolean invicto, String nombre, String stance) {
            this.combates = combates;
            this.edad = edad;
            this.invicto = invicto;
            this.nombre = nombre;
            this.stance = stance;
        }
        

          @Override
        public String toString() {
            return "Peleador{" +
                    "nombre='" + nombre + '\'' +
                    ", stance='" + stance + '\'' +
                    ", edad=" + edad +
                    ", combates=" + combates +
                    ", invicto=" + invicto +
                    '}';
        }

        //para guardar datos del peleador voy a crear una funcion para guardar en csv

       public static void guardarPeleador(List<Peleador> listap, File f2) throws IOException {
    try (PrintWriter p1 = new PrintWriter(
            new OutputStreamWriter(new FileOutputStream(f2), StandardCharsets.UTF_8))) {

        p1.println("combates,edad,invicto,nombre,stance");

        for (Peleador p : listap) {
            p1.println(p.combates + "," + p.edad + "," + p.invicto + "," + p.nombre + "," + p.stance);
        }
    }
}




/*    public static List<Peleador> leerPeleadores(File f) throws IOException {
            List<Peleador> lista = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {

                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    String[] c = line.split(",");
                    if (c.length >= 5) {
                        int combates = Integer.parseInt(c[0]);
                        int edad = Integer.parseInt(c[1]);
                        boolean invicto = Boolean.parseBoolean(c[2]);
                        String nombre = c[3];
                        String stance = c[4];
                        lista.add(new Peleador(combates, edad, invicto, nombre, stance));
                    }
                }
            }
            return lista;
        }

    } */


    public static void main(String[] args) {
        
           List<Peleador> peleadores = List.of(
                new Peleador(10, 21, true, "wasiq", "diestro"),
                new Peleador(15, 28, false, "gervonta", "Diestro"),
                new Peleador(20, 22, true, "shakur", "Zurdo")
        );

   File archivo = new File("peleadores.csv");

        try {
                   Peleador.guardarPeleador(peleadores, archivo);
                    System.out.println("CSV generado en: " + archivo.getAbsolutePath());
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
                    List<Peleador> leidos = Peleador.leerPeleadores(archivo);
                    System.out.println("Peleadores leídos del CSV:");
                    leidos.forEach(System.out::println);

        } catch (Exception e) {
        e.printStackTrace();
        }
    
    }

}
