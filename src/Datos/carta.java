package Datos;

import java.util.ArrayList;

public class carta {

    private String nombreCarta;
    private String imagenCarta;
    private ArrayList<idioma> idiomaCarta;

    public carta(String nombreCarta, String imagenCarta, ArrayList<idioma> idiomaCarta) {
        this.setNombreCarta(nombreCarta);
        this.setImagenCarta(imagenCarta);
        this.setIdiomaCarta(idiomaCarta);
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    public String getImagenCarta() {
        return imagenCarta;
    }

    public void setImagenCarta(String imagenCarta) {
        this.imagenCarta = imagenCarta;
    }

    public ArrayList<idioma> getIdiomaCarta() {
        return idiomaCarta;
    }

    public void setIdiomaCarta(ArrayList<idioma> idiomaCarta) {
        this.idiomaCarta = idiomaCarta;
    }
}
