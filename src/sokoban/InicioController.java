package sokoban;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController implements Initializable {
    

    @FXML
    private ComboBox<String> dificultad;

    @FXML
    private TextField nombre;

    @FXML
    private ComboBox<String> nivel;
    /*
    Se carga la data en los comboBox de la ventana de inicio
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Singleton partida = Singleton.getInstance();
        partida.setPrimera(true);
        partida.setDeshizo(false);
        dificultad.setValue("Fácil");
        dificultad.getItems().addAll("Fácil", "Medio", "Difícil");
        nivel.setValue("1");
        nivel.getItems().addAll("1", "2", "3", "4", "5");
    }    
    /*
    Función que redirecciona a la ventana de logros del usuario
    */
    @FXML
    void clickBtnLogros(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("ventana_logros.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.setX(600);
        window.setY(15);
        window.show();
    }
    
    /*
    Función que comienza la partida con los datos dados
    por el usuario.
    */
    @FXML
    void clickBtnIniciar(ActionEvent event) throws IOException {
        if(!nombre.getText().equals("")){
            Singleton x = Singleton.getInstance();
            x.setDificultad(dificultad.getValue());
            x.setJugador(nombre.getText());
            x.setNivel(nivel.getValue());
            Parent gui = FXMLLoader.load(getClass().getResource("Juego.fxml"));
            Scene creacionDocs = new Scene(gui);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(creacionDocs);
            window.show();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR,"Ingrese su nombre para continuar.");
            alerta.show();
        }

    }
    
    /*
    Nos redirecciona a la ventana de información del desarrollador
    */
    @FXML
    void clickBtnAcercaDe(ActionEvent event) throws IOException{
        Parent gui = FXMLLoader.load(getClass().getResource("Acerca_de.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    
    
}
