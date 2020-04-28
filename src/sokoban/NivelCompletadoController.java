package sokoban;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NivelCompletadoController implements Initializable {

    @FXML
    private Button siguiente;
    
    @FXML
    private Label completado;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Singleton partida = Singleton.getInstance();
        partida.getNivel();
        if(Integer.parseInt(partida.getNivel()) == 15 & partida.getDificultad().equals("Difícil")){
            siguiente.setVisible(false);
            completado.setText("Juego Completado!");
        }
    }
    /*
    Se encarga de seleccionar el siguiente nivel y configura la dificultad de la partida.
    */
    @FXML
    void siguienteNivel(ActionEvent event) throws IOException {
        Singleton partida = Singleton.getInstance();
        int nivel = Integer.parseInt(partida.getNivel());
        String nivelSiguiente = String.valueOf(nivel+1);
        partida.setNivel(nivelSiguiente);
        partida.setDeshizo(false);
        if(nivel+1<=5){
            partida.setDificultad("Fácil");
        }else if(nivel+1 > 10){
            partida.setDificultad("Difícil");
        }else{
            partida.setDificultad("Medio");
        }
        
        Parent gui = FXMLLoader.load(getClass().getResource("Juego.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    /*
    Función para volver al menú principal
    */
    @FXML
    void volverMenu(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }    
    
}
