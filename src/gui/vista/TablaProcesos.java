package gui.vista;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import so.Proceso;

public class TablaProcesos extends TableView {

    ObservableList<Proceso> datos = FXCollections.observableArrayList();
    public TablaProcesos(){

        TableColumn<Proceso, String> col_nombre = new TableColumn("Nombre");
        col_nombre.setCellValueFactory(param -> param.getValue().getNombre_property());

        TableColumn<Proceso, String> col_creacion = new TableColumn("Creacion");
        col_creacion.setCellValueFactory(param -> param.getValue().getCreacion_property().asString());

        TableColumn<Proceso, String> col_inicio = new TableColumn("Inicio");
        col_inicio.setCellValueFactory(param -> param.getValue().getInicio_property().asString());

        TableColumn<Proceso, String> col_duracion = new TableColumn("Duración");
        col_duracion.setCellValueFactory(param -> param.getValue().getDuracion_property().asString());

        TableColumn<Proceso, String> col_final = new TableColumn("Final");
        col_final.setCellValueFactory(param -> param.getValue().getFin_property().asString());

        TableColumn<Proceso, String> col_tactual = new TableColumn("Ejecución");
        col_tactual.setCellValueFactory(param -> param.getValue().getTActual_property().asString());

        setItems(datos);
        getColumns().addAll(col_nombre, col_creacion, col_inicio, col_duracion, col_final, col_tactual);
    }

    public void agregaProceso(Proceso proceso){
        datos.addAll(proceso);
    }
}
