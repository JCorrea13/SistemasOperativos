package Procesos;

import java.util.Scanner;

/**
 * Created by su on 23/08/16.
 */
public class ProcesoSuma extends Proceso {

    public ProcesoSuma(ThreadGroup tg) {
        super(tg);
    }

    @Override
    public void run(){
        time_start = System.currentTimeMillis();
        System.out.println("Sumando __");
        Scanner s = new Scanner(System.in);
        System.out.println("Intruduce un numero:");
        int a = s.nextInt();
        System.out.println("Intruduce un numero:");
        int b = s.nextInt();
        System.out.println("Resultado" + (a + b));
        time_finish = System.currentTimeMillis();
    }

}