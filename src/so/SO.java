package so;

import algoritmos.Fifo;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Esta clase modela el sistema operativo, el cual se encarga de ejecutar
 * los procesos.
 *
 * @author Jose Correa
 * @version 1.0.0
 */
public class SO {

    private Fifo fifo;
    private CallBack callBack;
    private volatile int reloj = 0;
    private boolean pausa = false;

    public SO(CallBack callBack){

        fifo = new Fifo();
        new Timer().schedule(new Reloj(), 0, 1000);
        this.callBack = callBack;
    }

    public class Reloj extends TimerTask{
        @Override
        public void run() {
            if(!pausa)
                fifo.ejecutaProcesos(reloj);
            callBack.updateGui();


            reloj += 1000;
        }
    }

    public void agregaProceso(Proceso proceso){
        fifo.agregarProceso(proceso);
    }

    public int getReloj() {
        return reloj;
    }

    public void setPausa(boolean pausa){
        this.pausa = pausa;
    }

    public void pararProceso(){
        fifo.pararProceso(reloj);
    }

    public void interrumpir(){
        fifo.interrupcion();
    }


    public Proceso getProcesoEjecucion(){
        return fifo.getProceso();
    }
    public interface CallBack{
        public void updateGui();
    }
}
