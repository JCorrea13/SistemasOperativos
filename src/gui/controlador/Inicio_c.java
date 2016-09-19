package gui.controlador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import so.Proceso;
import so.SO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class Inicio_c implements SO.CallBack{


    //Componentes graficos
    @FXML private Button btn_craer;
    @FXML private Button btn_agregar;
    @FXML private Button btn_pausa;
    @FXML private Button btn_continuar;
    @FXML private Button btn_parar;
    @FXML private Button btn_interrumpir;
    @FXML private Button btn_estadistica;
    @FXML private TextField txt_procesos;
    @FXML private TextField txt_nombre;
    @FXML private TextField txt_duracion;
    @FXML private TextField txt_creacion;
    @FXML private TextField txt_ejecucion;
    @FXML private TextField txt_ejecucion_actual;
    @FXML private ListView listv_procesos;

    //Componentes logicos
    private SO so;
    private ObservableList<Pane> datos = FXCollections.observableArrayList();
    private int contador_procesos = 0;
    private LinkedList<Panel_proceso_c> c_procesos = new LinkedList();
    private ArrayList<ArrayList> procesos_ref = new ArrayList<>();

    @FXML
    public void initialize(){
        so = new SO(this);
        listv_procesos.setItems(datos);
    }

    @FXML
    public void on_click_crea() throws IOException {
        for(int i = 0; i < Integer.parseInt(txt_procesos.getText()); i ++){
            Pane p = getPanelDatos();
            datos.add(p);
        }
    }

    private Pane getPanelDatos() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/panel_proceso.fxml"));
        Pane p = loader.load();
        Panel_proceso_c controller = loader.getController();

        Proceso proceso = new Proceso(10 , "P"+contador_procesos++, so.getReloj());
        controller.setProceso(proceso);
        so.agregaProceso(proceso);
        c_procesos.push(controller);

        ArrayList a = new ArrayList(2);
        a.add(controller);
        a.add(p);
        procesos_ref.add(a);
        return p;
    }

    @FXML
    public void on_click_agrega() throws IOException {
        Pane p = getPanelDatos();
        datos.add(p);
    }

    @FXML
    public void on_click_pausa(){
        so.setPausa(true);
    }

    @FXML
    public void on_click_continuar(){
        so.setPausa(false);
    }

    @FXML
    public void on_click_interrumpir(){
        so.interrumpir();
    }

    @FXML
    public void on_click_parar(){
        so.pararProceso();
    }

    @Override
    public void updateGui(){
        for (int i = 0; i < procesos_ref.size(); i++){
            ((Panel_proceso_c)procesos_ref.get(i).get(0)).setValores();

            if(!((Panel_proceso_c)procesos_ref.get(i).get(0)).getProceso().isRuning()) {
                int finalI = i;
                Platform.runLater(() ->  datos.remove((procesos_ref.get(finalI).get(1))));
            }
        }

        if(so.getProcesoEjecucion() != null) {
            txt_nombre.setText(so.getProcesoEjecucion().getNombre());
            txt_creacion.setText(String.valueOf(so.getProcesoEjecucion().getCreacion()));
            txt_duracion.setText(String.valueOf(so.getProcesoEjecucion().getDuracion()));
            txt_ejecucion.setText(String.valueOf(so.getProcesoEjecucion().getInicio()));
            txt_ejecucion_actual.setText(String.valueOf(so.getProcesoEjecucion().getTiempo()));
        }
    }

    @FXML
    public void on_click_estadistica() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/Estadistica.fxml"));
        DialogPane d = loader.load();
        Estadistica_c controller = loader.getController();

        for(Panel_proceso_c c :c_procesos)
            controller.agregaProceso(c.getProceso());


        Alert a = new Alert(Alert.AlertType.NONE);
        a.setTitle("Estadistica");
        a.setDialogPane(d);
        a.showAndWait();
    }
}
