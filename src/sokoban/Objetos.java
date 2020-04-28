package sokoban;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Objetos {
        
    public int heigth = 71;
    public int width = 69;
    /*
    Se encarga de crear un muro el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearMuro() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/MuroJuego.jpg");
        Image image = new Image(imageStream);
        ImageView muro = new ImageView(image);
        muro.setFitWidth(heigth);
        muro.setFitHeight(width);
        
        return muro;
    }
    /*
    Se encarga de crear un sitio el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearSitio() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/SitioCaja.png");
        Image image = new Image(imageStream);
        ImageView sitio = new ImageView(image);
        sitio.setFitWidth(heigth);
        sitio.setFitHeight(width);
        
        return sitio;
    }
    /*
    Se encarga de crear un jugador el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */   
    public ImageView crearJugador() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/RobotV3-38-512.png");
        Image image = new Image(imageStream);
        ImageView jugador = new ImageView(image);
        jugador.setFitWidth(heigth);
        jugador.setFitHeight(width);
        
        return jugador;
    }
           
    /*
    Se encarga de crear un caja el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearCaja() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/Caja.jpg");
        Image image = new Image(imageStream);
        ImageView caja = new ImageView(image);
        caja.setFitWidth(heigth);
        caja.setFitHeight(width);
        
        return caja;
    }   
    /*
    Se encarga de crear una caja verde la cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearCajaVerde() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/cajaVerde.jpeg");
        Image image = new Image(imageStream);
        ImageView caja = new ImageView(image);
        caja.setFitWidth(heigth);
        caja.setFitHeight(width);
        
        return caja;
    }
           
    /*
    Se encarga de crear un piso el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearPiso() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/piso.png");
        Image image = new Image(imageStream);
        ImageView piso = new ImageView(image);
        piso.setFitWidth(heigth);
        piso.setFitHeight(width);
        
        return piso;
    }
        
    /*
    Se encarga de crear una corona la cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */
    public ImageView crearCorona() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/cajaVerde.jpeg");
        Image image = new Image(imageStream);
        ImageView caja = new ImageView(image);
        caja.setFitWidth(30);
        caja.setFitHeight(30);
        
        return caja;
    }
    /*
    Se encarga de crear una X el cual retorna a manera de imageView para
    que pueda ser dibujado en cualquier lugar
    */    
    public ImageView crearX() throws FileNotFoundException{
        FileInputStream imageStream = new FileInputStream("src/ImgProyecto/Caja.jpg");
        Image image = new Image(imageStream);
        ImageView caja = new ImageView(image);
        caja.setFitWidth(30);
        caja.setFitHeight(30);
        
        return caja;
    }
}
