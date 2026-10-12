package Menu;

import java.util.Scanner;
import Validaciones.Validaciones;
import Metodos.Metodos;
import Importaciones.Importaciones;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validaciones V = new Validaciones();
        Metodos m = new Metodos();
        Importaciones imp = new Importaciones();

        System.out.println("Cargando base de datos de canciones...");
        String resultadoCarga = imp.ImportarArchivo(m);
        System.out.println("[SISTEMA] " + resultadoCarga);
        System.out.println();

        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println();
            System.out.println("==============================");
            System.out.println("  REPRODUCTOR DE MUSICA  ");
            System.out.println("==============================");
            System.out.println("1. Ingresar cancion");
            System.out.println("2. Entrar a lista de reproduccion");
            System.out.println("3. Salir");
            System.out.println("==============================");
            System.out.println("Elige una opcion: ");

            int opcion = V.ValidarEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.println();
                    System.out.println(m.llenarLista(sc, V));
                    break;
                case 2:
                    m.mostrarlista(V, sc);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Saliendo del reproductor.");
                    ejecutar = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Opcion invalida. Por favor, marca 1, 2 o 3.");
                    break;
            }
        }
        sc.close();
    }
}
