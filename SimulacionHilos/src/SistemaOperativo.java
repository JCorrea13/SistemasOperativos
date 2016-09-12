import Procesos.*;

public class SistemaOperativo {

    public static void main(String [] args) throws InterruptedException {

        ThreadGroup tg = new ThreadGroup("Grupo de hilos");

        ProcesoDivision pd = new ProcesoDivision(tg);
        pd.start();
        pd.join();

        ProcesoMultiplicacion pm = new ProcesoMultiplicacion(tg);
        pm.start();
        pm.join();

        ProcesoResta pr = new ProcesoResta(tg);
        pr.start();
        pr.join();

        ProcesoResto prr = new ProcesoResto(tg);
        prr.start();
        prr.join();

        ProcesoSuma ps = new ProcesoSuma(tg);
        ps.start();
        ps.join();
    }
}
