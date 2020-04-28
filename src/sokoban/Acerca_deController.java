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
import javafx.stage.Stage;


public class Acerca_deController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    /*
    Función para volver a la ventana incial del juego
    */
    @FXML
    void clickBtnVolver(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    
}
