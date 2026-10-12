package Objetolista;

public class Objetolista {
    private String nombreCancion;
    private String artista;
    private int anoLanzamiento;
    private String album;

    private Objetolista siguiente;
    private Objetolista anterior;

    public Objetolista(String nombreCancion, String artista, int anoLanzamiento, String album) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.anoLanzamiento = anoLanzamiento;
        this.album = album;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Objetolista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Objetolista siguiente) {
        this.siguiente = siguiente;
    }

    public Objetolista getAnterior() {
        return anterior;
    }

    public void setAnterior(Objetolista anterior) {
        this.anterior = anterior;
    }
}
