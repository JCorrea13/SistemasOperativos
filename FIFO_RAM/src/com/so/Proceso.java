package com.so;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

class Proceso {

    private int tiempo;
    private String nombre;
    private Timer t;
    private boolean runing;

    /**
     * Este es el contructor de la clase proceso
     * @param tiempo Tiempo que dura la ejecucion del proceso en milisegundos
     * @param nombre Nombre del proceso
     */
    public Proceso(int tiempo, String nombre) {
        this.tiempo = tiempo * 1000;
        this.nombre = nombre;
    }

    public void start(){
        System.out.println("Inicio proceso " + nombre);
        setRuning(true);
        t = new Timer();
        t.schedule(new Ejecucion(), 0, 1000);
    }

    public void pausa(){
        System.out.println("Proceso " + nombre +" en puasa");
        t.cancel();
    }

    public void stop(){
        System.out.println("Proceso " + nombre +" terminado en: " + tiempo);
        terminaProceso();
    }
    public void continuar(){
        System.out.println("Continuando proceso " + nombre);
        t = new Timer();
        t.schedule(new Ejecucion(), 0, 1000);
    }

    public void interrupir(){
        pausa();
        System.out.println("INTERRUPCION");
        continuar();
    }

    private void terminaProceso(){
        t.cancel();
        System.out.println("Fin del proceso");
        setRuning(false);
    }

    public boolean isRuning() {
        return runing;
    }

    public void setRuning(boolean runing) {
        this.runing = runing;
    }

    public class Ejecucion extends TimerTask{

        @Override
        public void run() {
            if(tiempo > 0) {
                System.out.println("Ejecucion " + nombre + ": " + tiempo );
                tiempo -= 1000;
            }else{
                terminaProceso();
            }
        }
    }
}
