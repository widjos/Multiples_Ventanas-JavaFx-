package Datos;


public class tarjeta {

   private String imagenDireccion;
   private String palabra;

    public tarjeta(String imagenDireccion, String palabra) {
        this.setImagenDireccion(imagenDireccion);
        this.setPalabra(palabra);
    }

    public String getImagenDireccion() {
        return imagenDireccion;
    }

    public void setImagenDireccion(String imagenDireccion) {
        this.imagenDireccion = imagenDireccion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
