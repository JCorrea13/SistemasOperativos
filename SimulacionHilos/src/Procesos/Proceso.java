package Procesos;

import java.util.Scanner;

public class Proceso extends Thread {

    public long time_start;
    public long time_finish;

    public Proceso(ThreadGroup tg){
        super(tg, "Proceso");
    }

    public void getTimeDuration(){
        System.out.println("Tiempo duracion: " + (time_finish - time_start));
    }
}
