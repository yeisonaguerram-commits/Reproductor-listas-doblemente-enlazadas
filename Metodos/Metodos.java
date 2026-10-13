package Metodos;

import java.util.Scanner;
import Validaciones.Validaciones;
import Objetolista.Objetolista;

public class Metodos {
    private Objetolista cabeza = null;
    private Objetolista cola = null;
    private Objetolista actual = null;

    public String agregarNodoDirecto(Objetolista nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        return "OK";
    }

    public String llenarLista(Scanner sc, Validaciones V) {
        System.out.println("Ingresa el titulo de la cancion:");
        String titulo = V.ValidarTexto(sc);

        System.out.println("Ingresa el artista:");
        String artista = V.ValidarTexto(sc);

        System.out.println("Ingresa el ano de lanzamiento:");
        int ano = V.ValidarEntero(sc);

        System.out.println("Ingresa el album:");
        String album = V.ValidarTexto(sc);

        Objetolista nuevo = new Objetolista(titulo, artista, ano, album);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }

        return "Cancion agregada correctamente a la lista.";
    } // fin metodo llenar lista

    public String mostrarlista(Validaciones v, Scanner sc) {
        // letra en negrilla
        String NEGRITA = "\u001B[1m";
        String RESET = "\u001B[0m";
        // colores
        String ROJO = "\u001B[31m";
        String VERDE = "\u001B[32m";

        boolean continuar = true;
        Objetolista aux = cabeza;
        int Estado = 0;
        while (continuar) {

            aux = cabeza;
            if (cabeza == null) {
                return "La lista esta vacia, ingrese nuevas canciones";
            }
            System.out.println("");
            while (aux != null) {
                if (aux == actual && Estado == 0) {
                    System.out.println(ROJO + "===================REPRODUCIENDO======================" + RESET);
                    System.out.println(NEGRITA + ROJO + aux.getNombreCancion() + "||" + aux.getArtista() + RESET);
                    System.out.println(NEGRITA + ROJO + aux.getAlbum() + "||" + aux.getAnoLanzamiento() + RESET);
                    System.out.println(ROJO + "=======================[||]===========================" + RESET);
                    aux = aux.getSiguiente();
                } else if (aux == actual && Estado == 1) {
                    System.out.println(ROJO + "======================EN PAUSA=======================" + RESET);
                    System.out.println(NEGRITA + ROJO + aux.getNombreCancion() + "||" + aux.getArtista() + RESET);
                    System.out.println(NEGRITA + ROJO + aux.getAlbum() + "||" + aux.getAnoLanzamiento() + RESET);
                    System.out.println(ROJO + "=======================[>]===========================" + RESET);
                    aux = aux.getSiguiente();
                } else {
                    System.out.println(aux.getNombreCancion() + "||" + aux.getArtista());
                    System.out.println(aux.getAlbum() + "||" + aux.getAnoLanzamiento());
                    System.out.println("--------------------------------------------------------");
                    aux = aux.getSiguiente();
                }
            }
            int opt = 0;
            System.out.println("");
            System.out.println(VERDE
                    + "0) Pausar/Despausar cancion || 1) Siguiente cancion || 2) Cancion anterior || 3) Buscar cancion || 4) Eliminar de la lista || 5) Regresar a menu principal"
                    + RESET);

            opt = v.ValidarEntero(sc);

            switch (opt) {
                case 0:
                    if (Estado == 1) {
                        Estado = 0;
                    } else if (Estado == 0) {
                        Estado = 1;
                    }
                    break;
                case 1:
                    if (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                    } else {
                        System.out.println("Ya llegaste al final de la lista de reproduccion");
                    }
                    break;
                case 2:
                    if (actual.getAnterior() != null) {
                        actual = actual.getAnterior();
                    } else {
                        System.out.println("Ya llegaste al Inicio de la lista de reproduccion");
                    }
                    break;
                case 3:
                    buscarcancion(v, sc);
                    break;
                case 4:
                    eliminarcancion(sc, v);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        } // fin while 1
        return "regresando a menu principal";
    } // FIN MOSTRAR

    public String buscarcancion(Validaciones v, Scanner sc) {
        System.out.println("Nombre de la cancion a buscar");
        String buscar = v.ValidarTexto(sc);
        Objetolista aux2 = cabeza;

        while (aux2 != null) {
            if (buscar.equalsIgnoreCase(aux2.getNombreCancion())) {
                actual = aux2;
                return "Cancion encontrada y puesta en reproduccion.";
            }
            aux2 = aux2.getSiguiente();
        }
        return "Cancion no encontrada en la lista.";
    } // fin buscar

    public String eliminarcancion(Scanner sc, Validaciones V) {
        if (cabeza == null) {
            return "La lista de reproduccion esta vacia.";
        }

        System.out.println("Ingresa el nombre de la cancion que deseas eliminar:");
        String nombreBuscar = V.ValidarTexto(sc);

        Objetolista aux = cabeza;

        while (aux != null) {
            if (nombreBuscar.equalsIgnoreCase(aux.getNombreCancion())) {


                // mueve el reproductor actual
                if (aux == actual) {
                    if (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                    } else if (actual.getAnterior() != null) {
                        actual = actual.getAnterior();
                    } else {
                        actual = null; // Era la unica que quedaba
                    }
                }

                // 1. Es la unica cancion en toda la lista
                if (aux == cabeza && aux == cola) {
                    cabeza = null;
                    cola = null;
                }
                // 2. Es la primera de la lista
                else if (aux == cabeza) {
                    cabeza = cabeza.getSiguiente();
                    cabeza.setAnterior(null);
                }
                // 3.  Es la ultima de la lista (Cola)
                else if (aux == cola) {
                    cola = cola.getAnterior();
                    cola.setSiguiente(null);
                }
                // 4. Esta en medio de la lista
                else {
                    Objetolista antes = aux.getAnterior();
                    Objetolista despues = aux.getSiguiente();

                    antes.setSiguiente(despues);
                    despues.setAnterior(antes);
                }
                return "Se ha eliminado correctamente: " + aux.getNombreCancion();
            }
            aux = aux.getSiguiente();
        }

        return "No se encontro ninguna cancion con ese nombre.";
    }
}
