package gui.controlador;

import gui.vista.TablaProcesos;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableView;
import so.Proceso;


public class Estadistica_c {


    //Componentes graficos
    @FXML private ComboBox cbo_algoritmo;
    @FXML private ComboBox cbo_recurso;
    @FXML DialogPane dp;
    private TablaProcesos tbl_procesos;

    private int cont = 0;

    @FXML
    public void initialize(){
        cbo_algoritmo.getItems().addAll("Fifo");
        cbo_recurso.getItems().addAll("Disco duro"," RAM");
        tbl_procesos = new TablaProcesos();
        dp.setContent(tbl_procesos);
    }

    public void agregaProceso(Proceso proceso){
        tbl_procesos.agregaProceso(proceso);
    }
}

