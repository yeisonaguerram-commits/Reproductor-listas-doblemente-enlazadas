package Importaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import Metodos.Metodos;
import Objetolista.Objetolista;

public class Importaciones {
    public String ImportarArchivo(Metodos m) {
        String rutaArchivo = "datos.txt";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            Objetolista obj = null;

            // Variables temporales para ir acumulando los datos de la cancion actual
            String titulo = "";
            String artista = "";
            int año = 0;
            String album = "";

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty() || linea.startsWith("-")) {
                    continue;
                }

                if (linea.startsWith("Nombre: ")) {
                    if (obj != null) {
                        m.agregarNodoDirecto(obj);
                        contador++;
                    }
                    titulo = linea.substring(8).trim();
                    obj = new Objetolista(titulo, "", 0, "");

                } else if (linea.startsWith("Artista: ")) {
                    if (obj != null) {
                        artista = linea.substring(9).trim();
                        obj.setArtista(artista);
                    }

                } else if (linea.startsWith("Año: ")) {
                    if (obj != null) {
                        año = Integer.parseInt(linea.substring(5).trim());
                        obj.setAnoLanzamiento(año);
                    }

                } else if (linea.startsWith("Album: ")) {
                    if (obj != null) {
                        album = linea.substring(7).trim();
                        obj.setAlbum(album);
                    }
                }
            }

            if (obj != null) {
                m.agregarNodoDirecto(obj);
                contador++;
            }

        } catch (Exception e) {
            return "Error al cargar el archivo de datos.";
        }

        return "Archivo importado correctamente. Canciones cargadas: " + contador;
    }
}
