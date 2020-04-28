/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban.Niveles;

/**
 *
 * @author azofe
 */
public class Niveles {
    private int muros[][];
    private int jugador[];
    private int cajas[][];
    private int sitios[][];
    private int murosextra[][];
    private  int deadlocks[][];
    


    public int[][] getMurosextra() {
        return murosextra;
    }

    public int[][] getMuros() {
        return muros;
    }

    public int[] getJugador() {
        return jugador;
    }

    public int[][] getCajas() {
        return cajas;
    }

    public int[][] getSitios() {
        return sitios;
    }
    
    public int[][] getDeadlocks() {
        return deadlocks;
    }
    
    /*
    Carga la información de los niveles
    */
    public void setData(int[][] cajas, int[][] muros, int[][] sitios, int[] jugador, int[][] muros_extra, int[][] deadlocks) {
        this.cajas = cajas;
        this.muros = muros;
        this.sitios = sitios;
        this.jugador = jugador;
        this.murosextra = muros_extra;
        this.deadlocks = deadlocks;
    }
    
    /*
    Cargan la información que se deberá utilizar para dibujar cada uno de los niveles.
    */
    
    public void cargarNivel_1(){
        int muros_nivel[][] = {{1,1},{1,2},{1,3},{1,4},{1,5},{2,1},{2,5},{3,0},{3,1},{3,4},{3,5},{4,0},{4,5},{5,0},{5,5},{6,0},{6,1},{6,2},{6,5},{7,2},{7,3},{7,4},{7,5}};
        int jugador_nivel[] = {2,2};
        int muros_extra[][] = {{0,0},{0,1},{1,0},{0,2},{0,3},{0,4},{0,5},{2,0},{2,1},{7,0},{7,1},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = { {5,2},{5,3}};
        int sitios_nivel[][] = { {2,3},{4,2}};
        int bloqueos[][] = {{4,1},{5,1},{2,2},{2,4},{4,4},{6,4},{6,3},{5,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
        
    }

    public void cargarNivel_2() {
        int muros_nivel[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{1,0},{1,5},{2,0},{2,5},{3,0},{3,3},{3,5},{4,0},{4,1},{4,5},{5,1},{5,2},{5,3},{5,4},{5,5}};
        int jugador_nivel[] = {1,1};
        int muros_extra[][] = {{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5},{5,0}};
        int cajas_nivel[][] = { {2,2},{3,2}};
        int sitios_nivel[][] = { {1,2},{3,2}};
        int bloqueos[][] = {{1,1},{2,1},{3,1},{1,4},{4,4},{4,2},{4,3},{2,4},{3,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_3(){
        int muros_nivel[][] = {{2,3},{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{1,0},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,5},{5,0},{5,5},{6,1},{6,2},{6,3},{6,4},{6,5}};
        int jugador_nivel[] = {1,1};
        int muros_extra[][] = {{6,0},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5},{5,0}};
        int cajas_nivel[][] = { {2,2},{3,2}};
        int sitios_nivel[][] = { {3,3},{5,3}};
        int bloqueos[][] = {{1,1},{2,1},{3,1},{4,1},{1,2},{1,3},{1,4},{2,4},{3,4},{4,4},{5,4},{5,1}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_4(){
        int muros_nivel[][] = {{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,4},{4,5},{5,0},{5,5},{6,0},{6,1},{6,5},{7,1},{7,5},{8,1},{8,2},{8,3},{8,4},{8,5}};
        int jugador_nivel[] = {6,3};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{1,0},{0,3},{0,4},{0,5},{7,0},{8,0},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = { {3,3},{4,3},{5,3}};
        int sitios_nivel[][] = { {5,2},{6,2},{6,4}};
        int bloqueos[][] = {{2,1},{3,1},{4,1},{5,1},{2,2},{2,3},{2,4},{3,4},{5,4},{7,4},{7,3},{7,2}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_5(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,5},{5,0},{5,5},{6,0},{6,1},{6,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5}};
        int jugador_nivel[] = {2,3};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{3,1},{3,2},{3,3}};
        int sitios_nivel[][] = {{3,1},{5,3},{2,4}};
        int bloqueos[][] = {{2,1},{5,1},{6,2},{6,3},{6,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_6(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{2,0},{2,1},{2,5},{3,0},{3,3},{3,5},{4,0},{4,5},{5,0},{5,4},{5,5},{6,0},{6,5},{7,1},{7,5}};
        int jugador_nivel[] = {6,4};
        int muros_extra[][] = {{7,0},{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{5,3},{6,3},{7,3}};
        int sitios_nivel[][] = {{3,2},{4,2},{7,4}};
        int bloqueos[][] = {{3,1},{4,1},{5,1},{6,1},{2,2},{2,3},{2,4},{3,4},{4,4},{6,4},{7,2}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_7(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,5},{5,0},{5,3},{5,5},{6,0},{6,1},{6,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5}};
        int jugador_nivel[] = {3,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{2,2},{4,2},{5,2}};
        int sitios_nivel[][] = {{2,1},{4,1},{4,4}};
        int bloqueos[][] = {{5,1},{2,4},{6,4},{6,2},{6,3}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_8(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,1},{2,5},{3,0},{3,1},{3,5},{4,0},{4,5},{5,0},{5,2},{5,5},{6,0},{6,4},{6,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5}};
        int jugador_nivel[] = {6,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{3,4},{4,2},{5,3}};
        int sitios_nivel[][] = {{2,2},{4,4},{4,2}};
        int bloqueos[][] = {{4,1},{5,1},{6,1},{6,2},{6,3},{2,4},{5,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_9(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,3},{3,5},{4,0},{4,5},{5,0},{5,5},{6,0},{6,1},{6,5},{7,1},{7,2},{7,5},{8,2},{8,3},{8,4},{8,5}};
        int jugador_nivel[] = {2,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{7,0},{8,0},{8,1},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{4,3},{4,2},{5,2}};
        int sitios_nivel[][] = {{3,2},{5,2},{5,3}};
        int bloqueos[][] = {{2,1},{3,1},{4,1},{5,1},{2,2},{2,3},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4},{7,3},{6,2}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    
    public void cargarNivel_10(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,5},{5,0},{5,1},{5,3},{5,5},{6,0},{6,1},{6,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5}};
        int jugador_nivel[] = {6,4};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{4,3},{5,2},{5,4}};
        int sitios_nivel[][] = {{5,2},{6,2},{4,4}};
        int bloqueos[][] = {{2,1},{3,1},{2,2},{2,3},{2,4},{6,4},{1,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_11(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,3},{3,5},{4,0},{4,5},{5,0},{5,2},{5,4},{5,5},{6,0},{6,5},{7,0},{7,1},{7,5},{8,1},{8,2},{8,3},{8,4},{8,5}}; 
        int jugador_nivel[] = {4,3};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{3,2},{4,2},{5,3}};
        int sitios_nivel[][] = {{4,1},{4,4},{6,2}};
        int bloqueos[][] = {{2,1},{6,1},{2,4},{6,4},{7,4},{7,2},{7,3}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_12(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,3},{4,5},{5,0},{5,5},{6,0},{6,1},{6,2},{6,3},{6,4},{6,5}};
        int jugador_nivel[] = {2,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{2,2},{3,2},{4,2}};
        int sitios_nivel[][] = {{2,3},{4,4},{5,1}};
        int bloqueos[][] = {{2,1},{2,4},{5,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_13(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,2},{3,5},{4,0},{4,5},{5,0},{5,2},{5,5},{6,0},{6,5},{7,0},{7,1},{7,5},{8,1},{8,2},{8,3},{8,4},{8,5}};
        int jugador_nivel[] = {2,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{8,0},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{4,3},{5,3},{6,2}};
        int sitios_nivel[][] = {{2,3},{7,4},{5,3}};
        int bloqueos[][] = {{2,1},{3,1},{4,1},{5,1},{6,1},{2,4},{7,2}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_14(){
        int muros_nivel[][] = {{2,0},{2,1},{2,2},{2,3},{2,4},{2,5},{3,0},{3,5},{4,0},{4,5},{5,0},{5,2},{5,5},{6,0},{6,5},{7,0},{7,1},{7,5},{8,1},{8,2},{8,3},{8,4},{8,5}};
        int jugador_nivel[] = {6,1};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{8,0},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{6,2},{6,3},{5,4}};
        int sitios_nivel[][] = {{6,2},{6,4},{7,4}};
        int bloqueos[][] = {{3,1},{4,1},{5,1},{6,1},{3,2},{3,3},{3,4},{7,2}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    public void cargarNivel_15(){
        int muros_nivel[][] = {{1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,5},{3,0},{3,5},{4,0},{4,3},{4,5},{5,0},{5,1},{5,5},{6,0},{6,1},{6,3},{6,5},{7,1},{7,5},{8,1},{8,2},{8,3},{8,4},{8,5}};
        int jugador_nivel[] = {7,4};
        int muros_extra[][] = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{7,0},{8,0},{9,0},{9,1},{9,2},{9,3},{9,4},{9,5}};
        int cajas_nivel[][] = {{5,2},{5,3},{6,4}};
        int sitios_nivel[][] = {{3,2},{4,1},{5,4}};
        int bloqueos[][] = {{2,1},{2,2},{2,3},{2,4},{7,2},{7,3},{7,4}};
        setData(cajas_nivel, muros_nivel, sitios_nivel, jugador_nivel,muros_extra, bloqueos);
    }
    

}
