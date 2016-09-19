package algoritmos;

import so.Proceso;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Esta clase modela el algoritmo Fifo
 * para la ejecucion de procesos
 *
 * @author Jose Correa
 * @version 1.0.0
 */

public class Fifo {

    private Queue<Proceso> cola;
    private Proceso proceso = null;
    private boolean interrupcion = false;

    public Fifo() {
        cola = new LinkedList<>();
    }

    public void agregarProceso(Proceso nombre_proceso){
        cola.add(nombre_proceso);
    }

    public int getNumeroProcesos(){
        return cola.size();
    }


    public void ejecutaProcesos(int tiempo_so) {

        if(proceso == null || !proceso.isRuning())
            setProceso(cola.poll());

        if(proceso != null)
            if(interrupcion) {
                proceso.setEstado("INTERRUMPIDO");
                interrupcion = false;
            }else
                proceso.ejecuta(tiempo_so);
    }

    public void pararProceso(int tiempo_so){
        if(getProceso() != null)
            getProceso().terminaProceso(tiempo_so);
        setProceso(cola.poll());
    }

    public void interrupcion(){
        interrupcion = true;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
}
