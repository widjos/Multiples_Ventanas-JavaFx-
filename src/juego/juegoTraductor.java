package juego;

import Datos.tarjeta;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class juegoTraductor implements Initializable {


      @FXML private ScrollPane scrollPanelImagenes;
      @FXML private  TextField idiomaTxt;
      @FXML private  TextField nombreTxt;
      @FXML private TextField tiempoTxt;



    ArrayList<TextField> palabrasComparar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        palabrasComparar = new ArrayList<TextField>();
        idiomaTxt.setEditable(false);
        nombreTxt.setEditable(false);

    }

    public void cerrarVentanaJuego(MouseEvent evento){
        Platform.exit();
        System.exit(0);
    }


    public void cargarDatosJuegos2(String nombre,String idioma, String dificultad){
        nombreTxt.setText(nombre);
        idiomaTxt.setText(idioma);
        idiomaTxt.setText(dificultad);
    }

    public void cargarDatosJuego(String nombre, String Idioma, String dificultad, ArrayList<tarjeta> cartas){
        nombreTxt.setText(nombre);
        idiomaTxt.setText(Idioma);
        idiomaTxt.setText(dificultad);

        crearCartasYTextBox(cartas);


    }

    // Este metodo creara todas las imagenes en els scroll panel y alamacenara los textfield creados.
    public void crearCartasYTextBox(ArrayList<tarjeta> entra){
        GridPane contenedor2 = new GridPane();


        int i ;
        for( i = 0; i < entra.size() ; i++ ){
            AnchorPane panelImagenes = new AnchorPane();
            ImageView imagenCarta = new ImageView();
            TextField palabraEntrada = new TextField();

            imagenCarta.setImage(new Image(entra.get(i).getImagenDireccion().toString()));
            palabrasComparar.add(palabraEntrada);


            panelImagenes.getChildren().add(imagenCarta);
            panelImagenes.getChildren().add(palabraEntrada);

            contenedor2.getChildren().addAll(panelImagenes);
        }



       scrollPanelImagenes.setContent(contenedor2);
    }


}
