package so;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Esta clase modela un proceso
 *
 * @author Jose Correa
 * @version 1.0.0
 */

public class Proceso {

    private final SimpleIntegerProperty duracion = new SimpleIntegerProperty();
    private final SimpleIntegerProperty inicio = new SimpleIntegerProperty();
    private final SimpleIntegerProperty fin = new SimpleIntegerProperty(-1);
    private final SimpleIntegerProperty creacion = new SimpleIntegerProperty();
    private final SimpleIntegerProperty tiempo = new SimpleIntegerProperty();
    private final SimpleStringProperty nombre = new SimpleStringProperty();
    private String estado;
    private boolean runing;

    /**
     * Este es el contructor de la clase proceso
     * @param duracion tiempo que dura la ejecucion del proceso en milisegundos
     * @param nombre Nombre del proceso
     */
    public Proceso(int duracion, String nombre, int creacion){
        this.creacion.set(creacion);
        this.duracion.set(duracion * 1000);
        this.tiempo.set(duracion * 1000);
        this.nombre.set(nombre);
        this.estado = "En espera";
        setRuning(true);
    }

    public int getTiempo() {
        return tiempo.get();
    }

    public String getEstado(){
        return estado;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void terminaProceso(int tiempo){
        this.estado = "Terminado";
        this.fin.set(tiempo);
        setRuning(false);
    }

    public int getDuracion() {
        return duracion.get();
    }

    public int getInicio() {
        return inicio.get();
    }

    public int getFin() {
        return fin.get();
    }

    public int getCreacion() {
        return creacion.get();
    }

    public boolean isRuning() {
        return runing;
    }

    public void setRuning(boolean runing) {
        this.runing = runing;
    }

    public void ejecuta(int tiempo_so){

        if(estado.equals("En espera"))
            inicio.set(tiempo_so);

        if (tiempo.get() > 0) {
            tiempo.set(tiempo.get() - 1000);
            this.estado = "Ejecutando";
        } else {
            terminaProceso(tiempo_so);
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SimpleStringProperty getNombre_property(){
        return nombre;
    }

    public SimpleIntegerProperty getCreacion_property(){
        return creacion;
    }

    public SimpleIntegerProperty getInicio_property(){
        return inicio;
    }

    public SimpleIntegerProperty getDuracion_property(){
        return  duracion;
    }

    public SimpleIntegerProperty getFin_property(){
        return fin;
    }

    public SimpleIntegerProperty getTActual_property(){
        return tiempo;
    }
}
