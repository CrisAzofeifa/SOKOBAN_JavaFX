/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ventana_logrosController implements Initializable {

    
    @FXML
    private GridPane logros;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarLogros();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana_logrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /*
    Función que carga la ventana de inicio
    */
    @FXML
    void clickBTNvolver(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    /*
    Función que guarda los logros del usuario, estos guardados en la clase
    Singleton
    */
    void cargarLogros() throws FileNotFoundException{
        Singleton partida = Singleton.getInstance();
        Objetos objetos = new Objetos();
        int [] faciles = partida.getNivelesFaciles();
        int[] medio = partida.getNivelesMedios();
        int[] dificiles = partida.getNivelesDifiles();
        
        for(int i = 0; i < 5;i++){
            if(faciles[i] == 1){
                logros.add(objetos.crearCorona(), 1, i+1);
            }else{
                logros.add(objetos.crearX(), 1, i+1);
            }
        }
        for(int i = 0; i < 5;i++){
            if(medio[i] == 1){
                logros.add(objetos.crearCorona(), 1, i+7);
            }else{
                logros.add(objetos.crearX(), 1, i+7);
            }
        }
        for(int i = 0; i < 5;i++){
            if(dificiles[i] == 1){
                logros.add(objetos.crearCorona(), 1, i+13);
            }else{
                logros.add(objetos.crearX(), 1, i+13);
            }
        }

        
   }
    
}
