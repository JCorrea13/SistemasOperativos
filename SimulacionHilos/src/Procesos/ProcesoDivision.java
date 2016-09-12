package Procesos;

import java.util.Scanner;

/**
 * Created by su on 23/08/16.
 */
public class ProcesoDivision extends Proceso {

    public ProcesoDivision(ThreadGroup tg) {
        super(tg);
    }

    @Override
    public void run(){
        time_start = System.currentTimeMillis();
        System.out.println("Dividiendo __");
        Scanner s = new Scanner(System.in);
        System.out.println("Intruduce un numero:");
        int a = s.nextInt();
        System.out.println("Intruduce un numero:");
        int b = s.nextInt();
        System.out.println("Resultado" + ((int)a / (int)b));
        time_finish = System.currentTimeMillis();
        getTimeDuration();
    }
}
