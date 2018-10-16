package cl.hfierroprog.tareasRest.tareasRest.Service;

import cl.hfierroprog.tareasRest.tareasRest.Entity.ResponseGuardar;
import cl.hfierroprog.tareasRest.tareasRest.Entity.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> getTareas(String filtro);
    ResponseGuardar guardarTarea(Tarea tarea);
    ResponseGuardar cambiarEstadoTarea(Tarea tarea);
    ResponseGuardar eliminarTarea(Integer id);
}
