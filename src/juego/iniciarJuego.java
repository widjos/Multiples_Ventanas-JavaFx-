package juego;

import Datos.carta;
import Datos.idioma;
import Datos.tarjeta;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.plaf.PanelUI;
import java.net.URL;
import java.util.*;


public class iniciarJuego implements Initializable {

    private double xOffset;
    private double yOffset;
    private ArrayList<tarjeta> miTarjeta;
    private ObservableList<String> nombreList = FXCollections.observableArrayList();
    private ObservableList<String> nivelList = FXCollections.observableArrayList();
    private ObservableList<String> idiomaList = FXCollections.observableArrayList();

    private ArrayList<String> nombres;
    private ArrayList<String> niveles;
    private ArrayList<String> idiomas;

    // Datos para el juego

    private  ArrayList<idioma> palabrasIdioma;
    private ArrayList<idioma>  palabrasIdioma2;
    private ArrayList<carta> cartasParaJugar;

    private ArrayList<tarjeta> cartasParaCargar;

   public String idioma;
   public String nombreJugador;
   public String dificultad;



    @FXML private TextField nombreTxt;
    @FXML private  TextField idiomaTxt;
    @FXML private TextField dificultadTxt;

    @FXML private ComboBox comboNombre;
    @FXML private ComboBox comboIdioma;
    @FXML private ComboBox comboDificultad;


    public iniciarJuego(){


    }

    private void cargarDatosComboBox(){

        // Provando las listas para almacenar los datos

        palabrasIdioma.add(new idioma("ingles", "duck"));
        palabrasIdioma.add(new idioma("aleman", "ente"));
        palabrasIdioma.add(new idioma("espanol", "pato"));

        palabrasIdioma2.add(new idioma("ingles", "dog"));
        palabrasIdioma2.add(new idioma("aleman", "hund"));
        palabrasIdioma2.add(new idioma("espanol", "perro"));


        cartasParaJugar.add(new carta("pato", "C:\\Users\\Wid\\Desktop\\juegoImagenes\\pato.jpg", palabrasIdioma ));
        cartasParaJugar.add(new carta("perro","C:\\Users\\Wid\\Desktop\\juegoImagenes\\perro.jpg" ,palabrasIdioma2));





        nombres.add("jose");
        nombres.add("jose");
        nombres.add("mario");
        nombres.add("tuth");

        niveles.add("Facil");
        niveles.add("Medio");
        niveles.add("Dificl");

        idiomas.add("Español");
        idiomas.add("Ingles");
        idiomas.add("Aleman");
        idiomas.add("Frances");

        for (int i = 0; i< nombres.size(); i++){
            nombreList.add(nombres.get(i));

        }
        for(int n = 0; n<niveles.size(); n++){
            nivelList.add(niveles.get(n));
        }
        for(int v =0; v< idiomas.size(); v++){
            idiomaList.add(idiomas.get(v));
        }

        comboNombre.setItems(nombreList);
        comboDificultad.setItems(nivelList);
        comboIdioma.setItems(idiomaList);

    }

    private void mostrarDatoEnText(){
        comboNombre.getSelectionModel();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idiomaTxt.setEditable(false);
        dificultadTxt.setEditable(false);

        // Estos array almacenan los datos obtenidos del interprete
        palabrasIdioma = new ArrayList<idioma>();
        palabrasIdioma2 = new ArrayList<idioma>();
        cartasParaJugar = new ArrayList<carta>();

        cartasParaCargar = new ArrayList<tarjeta>();

        niveles = new ArrayList<String>();
        idiomas = new ArrayList<String>();
        nombres = new ArrayList<String>();
        cargarDatosComboBox();



    }

    public boolean cargarValoresSeleccionados(){
        // Si alguno de los tres no tienen datos para cargar mensaje de alerta
        if(nombreTxt.getText().isEmpty() || idiomaTxt.getText().isEmpty() || dificultadTxt.getText().isEmpty()){

            return false;
        }else{
            nombreJugador = nombreTxt.getText();
            idioma = idiomaTxt.getText();
            dificultad = dificultadTxt.getText();
            return true;
        }
    }

    /*Este metodo carga todos los valores de las rutas y palabras que se utilizaran en el juego */

    public void llenarDatos(ArrayList<carta> entra, String idiomaSeleccionado){
        int noCarta ,noIdioma;
        String seleccionado = idiomaSeleccionado.toLowerCase();

        for (noCarta =0 ; noCarta < entra.size(); noCarta++){
            for(noIdioma = 0; noIdioma < entra.get(noCarta).getIdiomaCarta().size(); noIdioma++ ){

                //Si el idioma coincide con el seleccionado pues se comienza a llenar una nueva lista con su imagen y palabra
                if(seleccionado.equals(entra.get(noCarta).getIdiomaCarta().get(noIdioma).getNombreIdioma())){
                    cartasParaCargar.add(new tarjeta(entra.get(noCarta).getImagenCarta(),entra.get(noCarta).getIdiomaCarta().get(noIdioma).getPalabra()));
                }
            }
        }



    }

    /*
    * Metodos para las acciones de seleccion;
    * */

    @FXML
    public void seleccionarNombre(ActionEvent event){
        nombreTxt.setText( comboNombre.getSelectionModel().getSelectedItem().toString());


    }
    @FXML
    public void seleccionarIdioma(ActionEvent event){
        idiomaTxt.setText( comboIdioma.getSelectionModel().getSelectedItem().toString());
    }
    @FXML
    public void seleccionarDificultad(ActionEvent event){
        dificultadTxt.setText( comboDificultad.getSelectionModel().getSelectedItem().toString());

    }


    @FXML
    public void abrir(javafx.event.ActionEvent event){

        if(cargarValoresSeleccionados()){
            llenarDatos(cartasParaJugar,idioma.toLowerCase());

          //  System.out.println(cartasParaCargar.get(1).getImagenDireccion());
            abrirjuego();
        }else{
            mostrarMensaje("Debe seleccionar o ingresar su nombre,\n seleccionar un idioma,\n Y seleccionar una dificultad");
        }

    }

    public void mostrarMensaje(String mensaje){
        Alert acerca = new Alert(Alert.AlertType.INFORMATION, mensaje);
        acerca.setTitle("Advertencia");
        acerca.showAndWait().ifPresent(response -> {
            if (response == ButtonType.CLOSE) {

                acerca.close();

            }
        });
    }

    @FXML
    public void jugarVentana(MouseEvent event){
       abrirjuego();
    }

    public void cerrarVentanaJuego(MouseEvent evento){
        // Para solo cerrar la ventana
        final Node source = (Node) evento.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        // Para cerrar toda la aplicacion

      // Platform.exit();
      //  System.exit(0);
    }


    /*
    *
    * Metodo Para inciar una nueva ventana del juego
    * */
    public void abrirjuego(){



        try{

            //Para llamar al .fxml para la el controlador y poder acceder a los metodos del controlador mediante una nueva instancia del FXMLLoader

            FXMLLoader miscene = new FXMLLoader(getClass().getResource("/juego/juegoTraductor.fxml"));
          // FXMLLoader miscene = FXMLLoader.load(getClass().getResource("/juego/juegoTraductor.fxml"));
           Parent root = (Parent) miscene.load(); //FXMLLoader.load(getClass().getResource("/juego/juegoTraductor.fxml"));




            Stage miventana = new Stage();

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    miventana.setX(event.getScreenX() - xOffset);
                    miventana.setY(event.getScreenY()- yOffset);
                }
            });


         // Aqui se llama el metodo del constructor para luego asignar los valores a los textfields en el juegoTraductor
            juegoTraductor controller = miscene.<juegoTraductor>getController();
            controller.cargarDatosJuegos2(nombreJugador,idioma,dificultad);

            // Aqui se llenan los datos del combo
        //    cargarDatosComboBox();
           // juegoTraductor nuevo = new juegoTraductor();
           // nuevo.cargarDatosJuego(nombreJugador,idioma,dificultad,cartasParaCargar);

            miventana.initStyle(StageStyle.TRANSPARENT);
            miventana.setScene(new Scene(root));
            miventana.show();


        }
        catch (Exception e){

        }

    }





}
