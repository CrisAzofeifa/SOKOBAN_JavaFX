package sokoban;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sokoban.Niveles.Niveles;

public class JuegoController implements Initializable{
    
    @FXML
    private Label nombre_label;

    @FXML
    private Label dificultad_label;

    @FXML
    private Label nivel_label;

    @FXML
    private Label mov_label;
    
    @FXML
    private AnchorPane container;
    
    int movimientos = 0;
    
    int jugadorX;
    int jugadorY;
    private int muros[][];
    private int cajas[][];
    private int sitios[][];
    private int muros_extra[][];
    private int deadlocks[][];
    
    @FXML
    private GridPane tablero;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            comenzarPartida();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JuegoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    } 
    
    /*
    Esta función se encarga de dibujar el nivel en la ventana
    utilizando la información cargada con anterioridad
    */
    public void dibujarNivel() throws FileNotFoundException{
        Singleton par = Singleton.getInstance();
        nombre_label.setText(par.getJugador());
        nivel_label.setText(par.getNivel());
        dificultad_label.setText(par.getDificultad());
        mov_label.setText("0");
        
        Objetos objetos = new Objetos();
        
        for (int[] muro : muros) {
            tablero.add(objetos.crearMuro(), muro[0], muro[1]);    
        } 
        for (int[] muro : muros_extra) {
            tablero.add(objetos.crearMuro(), muro[0], muro[1]);  
        }
        for (int[] sitio : sitios) {
            tablero.add(objetos.crearSitio(), sitio[0], sitio[1]);
        }
        for (int[] caja : cajas) {
            if(haySitio(caja[0], caja[1])){
                tablero.add(objetos.crearCajaVerde(), caja[0], caja[1]);
            }else{
                tablero.add(objetos.crearCaja(), caja[0], caja[1]);                 
            }
            
        }

        tablero.add(objetos.crearJugador(), jugadorX, jugadorY);
        
    }
    /*
    Esta función se encargada de iniciar los valores de las partidas
    como son la dificultad y el nivel inicial
    */
    private void comenzarPartida() throws FileNotFoundException {
        Singleton partida = Singleton.getInstance();
        if(partida.getPrimera()){
            partida.setPrimera(false);
            switch (partida.getDificultad()){
                case "Fácil":
                    partida.setNivel(partida.getNivel());
                    selecionarNivel(Integer.parseInt(partida.getNivel()));
                    break;
                case "Medio":
                    partida.setNivel(""+(Integer.parseInt(partida.getNivel())+5));
                    selecionarNivel(Integer.parseInt(partida.getNivel()));
                    break;
                case "Difícil":
                    partida.setNivel(""+(Integer.parseInt(partida.getNivel())+10));
                    selecionarNivel(Integer.parseInt(partida.getNivel()));
                    break;
            }
        }else{
            selecionarNivel(Integer.parseInt(partida.getNivel()));
        }
            

    }
    
    /*
    Encargada de obtener los valores X y Y a la hora de hacer 
    click con el puntero, esto para mover el personaje
    */
    @FXML
    void moverConClick(MouseEvent event) throws FileNotFoundException, IOException {
        int[] celda = calcularCelda((int) event.getX(), (int) event.getY());
        mover_a_Celda(celda);
        comprobarVictoria();
    }
    
    /*
    Recibe la celda a la que se requiere mover el personaje y lo 
    lleva hacia ella.
    */
    void mover_a_Celda(int[] celda) throws FileNotFoundException{
        if(celda[0] == jugadorX){
            if(celda[1] == jugadorY+1){
                moverAbajo();
            }else if(celda[1] == jugadorY-1){
                moverArriba();
            }
        }
        else if(celda[1] == jugadorY){
            if(celda[0] == jugadorX-1){
                moverIzquierda();
            }else if(celda[0] == jugadorX+1){
                moverDerecha();
            }
        }
    }
    
    /*
    Calcula la celda en la que se está haciendo click a partir de las 
    coordenadas X y Y del click del puntero
    */
    int[] calcularCelda(int x,int y){
        Objetos ob = new Objetos();
        int alto = ob.heigth;
        int ancho = ob.width;
        int x_coordenada = 0;
        int y_coordenada = 0;
        for(int i = 0; i <= 10; i++){
            if(x > (ancho*i) & x < (ancho*(i+1))){
                x_coordenada = i;
            }
        }
        for(int i = 0; i <= 6; i++){
            if(y > (alto*i) & y < (alto*(i+1))){
                y_coordenada = i;
            }
        }
        
        int[] celda = {x_coordenada, y_coordenada};
        return celda;
       
    }
    
    /*
    En esta función se inicia el proceso de reiniciar nivel, esta reinicia
    el proceso de carga del nivel utilizando el nivel actual.
    */
    private void reiniciarNivel() throws FileNotFoundException {
        Singleton partida = Singleton.getInstance();
        movimientos = 0;
        actualizarMovimientos();
        selecionarNivel(Integer.parseInt(partida.getNivel()));
        
    }
    
    /*
    Función que detecta al uso de las teclas direcionales para mover al jugador
    */
    @FXML
    void mover(KeyEvent event) throws FileNotFoundException, IOException {
        switch (event.getCode()) {
            case LEFT:
                moverIzquierda();
                comprobarVictoria();
                break;
            case RIGHT:
                moverDerecha();
                comprobarVictoria();
                break;
            case UP:
                moverArriba();
                comprobarVictoria();
                break; 
            case DOWN:
                moverAbajo();
                comprobarVictoria();
                break;
            default:
                break;
        }
    }

    /*
    Se encarga de comprobar si el juego está en estado de victoria o deadlock
    */
    void comprobarVictoria() throws IOException{

        if(compararArraysVictoria()){
            registrarNivelCompletado();
            mensajeVictoria();
        }else if(comprobarDeadLock()){
            mensajeDeadlock();
        }
    }
    
    /*
    Registra que el nivel actual se ha completado para que luego pueda ser consultado
    en la ventana de logros
    */
    void registrarNivelCompletado(){
        Singleton partida = Singleton.getInstance();
        partida.setNivelCompletado(Integer.parseInt(partida.getNivel()));
    }
    /*
    Dispara una alerta para notificar al jugador de que el 
    juego está en estado de deadlock (imposible de ganar)
    */
    void mensajeDeadlock(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Estado de DeadLock!");
        alerta.show();
        
    }
    /*
    Carga la ventana de nivel completado para indicarle la victoria al 
    jugador
    */
    void mensajeVictoria() throws IOException{
        Parent gui = FXMLLoader.load(getClass().getResource("nivelCompletado.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage) container.getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    
    /*
    Revisa si en las posiciones de deadlock se encuentra una caja 
    */
    boolean comprobarDeadLock(){
        for(int[] pos : deadlocks){
            if(hayCaja(pos[0], pos[1])){
                return true;
            }
        }
        return false;
    }
        
    /*
    Función del botón encargada de reiniciar el nivel
    */
    @FXML
    void reiniciarNivel(ActionEvent event) throws FileNotFoundException {
        tablero.getChildren().clear();
        reiniciarNivel();
    }
    /*
    Comprueba si todas las cajas están en los sitios de caja
    */
    boolean compararArraysVictoria(){
        
        for (int[] caja : cajas) {
            boolean temp = true;
            for (int c = 0; c < sitios.length; c++) {
                if ((caja[0] == sitios[c][0]) & (caja[1] == sitios[c][1])) {
                    c = sitios.length;
                    temp = true;
                } else {
                    temp = false;
                }
            } 
            if(!temp){
                return false;
            }
        }
        return true;
    }
    /*
    Método encargado del movimiento del personaje hacia la izquierda.
    En este se toman en cuenta las posiciones de las cajas y muros, para 
    comprobar que el jugador se puede mover.
    */
    void moverIzquierda() throws FileNotFoundException{
        Objetos objetos = new Objetos();
        
        if(!hayMuro(jugadorX-1, jugadorY) & jugadorX - 1 >=0 ){
            if(hayCaja(jugadorX-1, jugadorY) & !hayCaja(jugadorX-2, jugadorY) & jugadorX - 2 >= 0 & !hayMuro(jugadorX-2, jugadorY)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                tablero.add(objetos.crearPiso(), jugadorX-1, jugadorY);
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                if(haySitio(jugadorX-1, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX-1, jugadorY);
                }
                
                if(haySitio(jugadorX-2, jugadorY)){
                    tablero.add(objetos.crearCajaVerde(), jugadorX-2, jugadorY);
                }else{
                    tablero.add(objetos.crearCaja(), jugadorX-2, jugadorY);
                }
                
                if(haySitio(jugadorX-1, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX-1, jugadorY);
                    tablero.add(objetos.crearJugador(), jugadorX-1, jugadorY);
                }else{
                    tablero.add(objetos.crearJugador(), jugadorX-1, jugadorY);
                }
                actualizarPosicionCaja(jugadorX - 1, jugadorY, jugadorX - 2, jugadorY);               
                this.movimientos = movimientos+1;
                this.jugadorX = jugadorX - 1;
            }else if(!hayCaja(jugadorX-1, jugadorY)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                tablero.add(objetos.crearJugador(), jugadorX-1, jugadorY);
                this.movimientos = movimientos+1;
                this.jugadorX = jugadorX - 1; 
            }
            actualizarMovimientos();

        }
    }
    /*
    Método encargado del movimiento del personaje hacia la arriba.
    En este se toman en cuenta las posiciones de las cajas y muros, para 
    comprobar que el jugador se puede mover.
    */
    void moverArriba() throws FileNotFoundException{
        
        Objetos objetos = new Objetos();
        if(!hayMuro(jugadorX, jugadorY-1) & jugadorY - 1 >= 0 ){
            if(hayCaja(jugadorX, jugadorY-1)& !hayCaja(jugadorX, jugadorY-2) & jugadorY - 2 >= 0 & !hayMuro(jugadorX, jugadorY-2)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY-1);
                
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                if(haySitio(jugadorX-1, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY-1);
                }
                
                if(haySitio(jugadorX, jugadorY-2)){
                    tablero.add(objetos.crearCajaVerde(), jugadorX, jugadorY-2);
                }else{
                    tablero.add(objetos.crearCaja(), jugadorX, jugadorY-2);
                }
                
                if(haySitio(jugadorX, jugadorY-1)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY-1);
                    tablero.add(objetos.crearJugador(), jugadorX, jugadorY-1);
                }else{
                    tablero.add(objetos.crearJugador(), jugadorX, jugadorY-1);
                }
                
                actualizarPosicionCaja(jugadorX, jugadorY-1, jugadorX, jugadorY-2);
                this.movimientos = movimientos+1;
                this.jugadorY = jugadorY - 1;
            }else if(!hayCaja(jugadorX, jugadorY-1)){   
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                tablero.add(objetos.crearJugador(), jugadorX, jugadorY-1); 
                this.movimientos = movimientos+1;
                this.jugadorY = jugadorY - 1;  

            }
            actualizarMovimientos();
        }          
    }
    
    /*
    Función que se encarga de actualizar el label de movimientos 
    que le indica al jugador la cantidad de movimientos realizados.
    */
    public void actualizarMovimientos(){
        mov_label.setText(String.valueOf(movimientos));
    }

    /*
    Método encargado del movimiento del personaje hacia la abajo.
    En este se toman en cuenta las posiciones de las cajas y muros, para 
    comprobar que el jugador se puede mover.
    */
    void moverAbajo() throws FileNotFoundException{
       
        Objetos objetos = new Objetos();
        if(!hayMuro(jugadorX, jugadorY+1) & jugadorY + 1 <= 5 ){
            if(hayCaja(jugadorX, jugadorY+1)& !hayCaja(jugadorX, jugadorY+2) & jugadorY + 2 <= 5 & !hayMuro(jugadorX, jugadorY+2)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY+1);
                
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                if(haySitio(jugadorX, jugadorY+1)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY+1);
                }
                
                if(haySitio(jugadorX, jugadorY+2)){
                    tablero.add(objetos.crearCajaVerde(), jugadorX, jugadorY+2);
                }else{
                    tablero.add(objetos.crearCaja(), jugadorX, jugadorY+2);
                }
                
                if(haySitio(jugadorX, jugadorY+1)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY+1);
                    tablero.add(objetos.crearJugador(), jugadorX, jugadorY+1);
                }else{
                    tablero.add(objetos.crearJugador(), jugadorX, jugadorY+1);
                }
                actualizarPosicionCaja(jugadorX, jugadorY+1, jugadorX, jugadorY+2);
                this.movimientos = movimientos+1;
                this.jugadorY = jugadorY + 1;
            }else if(!hayCaja(jugadorX, jugadorY+1)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                tablero.add(objetos.crearJugador(), jugadorX, jugadorY+1); 
                this.movimientos = movimientos+1;
                this.jugadorY = jugadorY + 1;  
            }
            actualizarMovimientos();

        }    
    }
    /*
    Método encargado del movimiento del personaje hacia la derecha.
    En este se toman en cuenta las posiciones de las cajas y muros, para 
    comprobar que el jugador se puede mover.
    */
    void moverDerecha() throws FileNotFoundException{
        
        Objetos objetos = new Objetos();
        if(!hayMuro(jugadorX+1, jugadorY) & jugadorX + 1 <= 9 ){
            if(hayCaja(jugadorX+1, jugadorY)& !hayCaja(jugadorX+2, jugadorY) & jugadorX + 2 <= 9 & !hayMuro(jugadorX+2, jugadorY)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                tablero.add(objetos.crearPiso(), jugadorX+1, jugadorY);
                
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                if(haySitio(jugadorX+1, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX+1, jugadorY);
                }
                
                if(haySitio(jugadorX+2, jugadorY)){
                    tablero.add(objetos.crearCajaVerde(), jugadorX+2, jugadorY);
                }else{
                    tablero.add(objetos.crearCaja(), jugadorX+2, jugadorY);
                }
                
                if(haySitio(jugadorX+1, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX+1, jugadorY);
                    tablero.add(objetos.crearJugador(), jugadorX+1, jugadorY);
                }else{
                    tablero.add(objetos.crearJugador(), jugadorX+1, jugadorY);
                }                
                
                actualizarPosicionCaja(jugadorX + 1, jugadorY, jugadorX + 2, jugadorY);
                this.movimientos = movimientos+1;
                this.jugadorX = jugadorX + 1;
            }else if(!hayCaja(jugadorX+1, jugadorY)){
                tablero.add(objetos.crearPiso(), jugadorX, jugadorY);
                if(haySitio(jugadorX, jugadorY)){
                    tablero.add(objetos.crearSitio(), jugadorX, jugadorY);
                }
                tablero.add(objetos.crearJugador(), jugadorX+1, jugadorY);
                this.movimientos = movimientos+1;
                this.jugadorX = jugadorX + 1;  
            }
            actualizarMovimientos();
        }
    }
    
    /*
    Función que regresa al usuario a la página de inicio
    */
    @FXML
    void volver_menu(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Scene creacionDocs = new Scene(gui);
        
        Stage window = (Stage) container.getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    /*
    Verifica si hay un muro en una posicion dada,
    buscando esta posición en la lista de posiciones
    de las muros
    */
    boolean hayMuro(int x, int y){
        for (int[] muro : muros) {
            if (muro[0] == x & muro[1] == y) {
                return true;
            }
        }
        return false;
    }
    /*
    Verifica si hay un sitio en una posicion dada,
    buscando esta posición en la lista de posiciones
    de las sitio
    */
    boolean haySitio(int x, int y){
        for (int[] sitio : sitios) {
            if (sitio[0] == x & sitio[1] == y) {
                return true;
            }
        }
        return false;
    }
    /*
    Verifica si hay un caja en una posicion dada,
    buscando esta posición en la lista de posiciones
    de las cajas
    */
    boolean hayCaja(int x, int y){
        for (int[] caja : cajas) {
            if (caja[0] == x & caja[1] == y) {
                return true;
            }
        }
        return false;
    }
    
    /*
    Actualiza la posición de una caja en la lista de cajas,
    utilizando la posicion actual y sustituyéndola por la posicion nueva
    */
    void actualizarPosicionCaja(int x_actual, int y_actual, int x,int y){
        for (int[] caja : cajas) {
            if (caja[0] == x_actual & caja[1] == y_actual) {
                caja[0] = x;
                caja[1] = y;
            }
        }        
        
    }
    /*
    Función encargada de seleccionar el nivel, recibe
    un número el cual es el nivel que debe seleccionar.
    Además carga toda la información de este nivel para 
    que sea dibujado en la ventana.
    */
    private void selecionarNivel(int i) throws FileNotFoundException {
        Niveles nivel = new Niveles();
        switch(i) {
            case 1:
              nivel.cargarNivel_1();
                break;
            case 2:
              nivel.cargarNivel_2();
              break;
            case 3:
              nivel.cargarNivel_3();
              break;
            case 4:
              nivel.cargarNivel_4();
              break;
            case 5:
              nivel.cargarNivel_5();
              break;
            case 6:
              nivel.cargarNivel_6();
              break;
            case 7:
              nivel.cargarNivel_7();
              break;
            case 8:
              nivel.cargarNivel_8();
              break;
            case 9:
              nivel.cargarNivel_9();
              break;
            case 10:
              nivel.cargarNivel_10();
              break;
            case 11:
              nivel.cargarNivel_11();
              break;
            case 12:
              nivel.cargarNivel_12();
              break;
            case 13:
              nivel.cargarNivel_13();
              break;
            case 14:
              nivel.cargarNivel_14();
              break;
            case 15:
              nivel.cargarNivel_15();
              break;
        }
        muros = nivel.getMuros();
        deadlocks = nivel.getDeadlocks();
        cajas = nivel.getCajas();
        sitios = nivel.getSitios();
        jugadorX = nivel.getJugador()[0];
        jugadorY = nivel.getJugador()[1];
        muros_extra = nivel.getMurosextra();
        dibujarNivel();          
    }
        

}
