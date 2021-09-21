package Datos;

public class idioma {

   private  String nombreIdioma;
    private String palabra;

    public idioma(String nombreIdioma, String palabra) {
        this.setNombreIdioma(nombreIdioma);
        this.setPalabra(palabra);
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
