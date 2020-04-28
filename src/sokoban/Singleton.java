package sokoban;

class Singleton 
{ 

    private static Singleton single_instance = null; 
    private String dificultad;
    private String nivel;
    private String jugador;
    boolean primera = true;
    boolean deshizo = false;
    
    int[] nivelesFaciles = {0,0,0,0,0};
    int[] nivelesMedios = {0,0,0,0,0};
    int[] nivelesDifiles = {0,0,0,0,0};    
            
    public void setDeshizo(boolean deshizo) {
        this.deshizo = deshizo;
    }

    public int[] getNivelesFaciles() {
        return nivelesFaciles;
    }

    public int[] getNivelesMedios() {
        return nivelesMedios;
    }

    public int[] getNivelesDifiles() {
        return nivelesDifiles;
    }

    public boolean isDeshizo() {
        return deshizo;
    }
  
    public void setNivelCompletado(int nivel){
        if(nivel <= 5){
            nivelesFaciles[nivel-1] = 1;
        }else if(nivel > 10){
            nivelesDifiles[nivel - 11] = 1;
        }else{
            nivelesMedios[nivel - 6] = 1;
        }
    }
       

    
    private Singleton() 
    { 
    } 
  

    public static Singleton getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 

    public String getDificultad() {
        return dificultad;
    }
    public boolean getPrimera(){
        return primera;
    }
        
    public void setPrimera(boolean primera) {
        this.primera = primera;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    
} 