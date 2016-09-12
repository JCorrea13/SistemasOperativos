package com.so;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AlgoritmoFIFO implements Runnable{

    private Queue<Proceso> cola;
    public static Scanner s = new Scanner(System.in);
    private Proceso proceso = null;
    private volatile boolean fin = false;

    public AlgoritmoFIFO() {
        cola = new LinkedList<>();
    }

    public void agregarProceso(Proceso nombre_proceso){
        cola.add(nombre_proceso);
    }

    public int getNumeroProcesos(){
        return cola.size();
    }


    public void ejecutaProcesos() throws InterruptedException {

        setProceso(cola.poll());
        while(getProceso() != null){
            proceso.start();
            while(proceso.isRuning());
            setProceso(cola.poll());
        }
        System.out.println("Final de procesos");
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    @Override
    public void run() {
        //aqui se lee el teclado indeterminadamente
        while(!fin){
            switch(s.next().charAt(0)){
                case 's':
                case 'S': if(getProceso() != null)
                            getProceso().stop();
                            break;
                case 'c':
                case 'C': if(getProceso() != null)
                            getProceso().continuar();
                            break;
                case 'i':
                case 'I': if(getProceso() != null)
                            getProceso().interrupir();
                            break;
                case 'p':
                case 'P': if(getProceso() != null)
                            getProceso().pausa();
                            break;
            }
        }
    }

    public static void main(String [] args) throws InterruptedException {
        AlgoritmoFIFO fifo = new AlgoritmoFIFO();
        System.out.println("Numero de procesos: ");
        int total = s.nextInt();
        Random r = new Random();

        for(int i = 0; i < total; i++)
            fifo.agregarProceso(new Proceso( r.nextInt(10) + 1 , i + ""));

        System.out.println("Inicio de ejecucion: ");
        Thread t = new Thread(fifo);
        t.start();
        fifo.ejecutaProcesos();
        fifo.fin = true;
    }
}
