package gui.controlador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import so.Proceso;
import so.SO;


public class Panel_proceso_c {


    //Componentes graficos
    @FXML private Label txt_nombre;
    @FXML private TextField txt_estado;

    private Proceso proceso;

    @FXML
    public void initialize(){
    }

    public void setProceso(Proceso proceso){
        this.proceso = proceso;
        setValores();
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setValores(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(proceso != null) {
                    txt_nombre.setText(proceso.getNombre());
                    txt_estado.setText(proceso.getEstado());
                }
            }
        });
    }
}
