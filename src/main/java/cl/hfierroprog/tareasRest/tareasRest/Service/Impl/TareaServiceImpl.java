package cl.hfierroprog.tareasRest.tareasRest.Service.Impl;

import cl.hfierroprog.tareasRest.tareasRest.Dao.TareaDao;
import cl.hfierroprog.tareasRest.tareasRest.Entity.ResponseGuardar;
import cl.hfierroprog.tareasRest.tareasRest.Entity.Tarea;
import cl.hfierroprog.tareasRest.tareasRest.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tareaService")
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaDao tareaDao;

    @Override
    public List<Tarea> getTareas(String filtro) {

        if(filtro.equals("TODAS")){
            return (List<Tarea>) tareaDao.findAll();
        } else if (filtro.equals("COMPLETADAS")) {
            return tareaDao.getTareasCompletadas();
        } else {
            return tareaDao.getTareasPorCompletar();
        }
    }

    @Override
    public ResponseGuardar guardarTarea(Tarea tarea) {
        ResponseGuardar response = new ResponseGuardar();

        try{
            Tarea tareaBD = tareaDao.save(tarea);

            if(tareaBD == null) {
                response.setCodigo(HttpStatus.BAD_REQUEST);
                response.setMensaje("Error al guardar la tarea!");
            } else {
                response.setCodigo(HttpStatus.OK);
                response.setMensaje("Tarea guardada correctamente!");
                response.setTarea(tareaBD);
            }
        } catch (Exception ex) {
            response.setCodigo(HttpStatus.BAD_REQUEST);
            response.setMensaje("Error al guardar la tarea!");
        }

        return response;
    }

    @Override
    public ResponseGuardar cambiarEstadoTarea(Tarea tarea) {
        ResponseGuardar response = new ResponseGuardar();

        String estado = tareaDao.findById(tarea.getId()).get().getEstado();

        if(estado.equals("POR COMPLETAR")){
            tarea.setEstado("COMPLETADA");
        } else {
            tarea.setEstado("POR COMPLETAR");
        }

        try {
            Tarea tareaDB = tareaDao.save(tarea);

            if(tareaDB == null) {
                response.setCodigo(HttpStatus.BAD_REQUEST);
                response.setMensaje("Error al actualizar el estado de la tarea!");
            }  else {
                response.setCodigo(HttpStatus.OK);
                response.setMensaje("Estado de la tarea actualizado correctamente!");
                response.setTarea(tareaDB);
            }
        } catch (Exception ex) {
            response.setCodigo(HttpStatus.BAD_REQUEST);
            response.setMensaje("Error al actualizar el estado de la tarea!");
        }

        return response;
    }

    @Override
    public ResponseGuardar eliminarTarea(Integer id) {
        ResponseGuardar response = new ResponseGuardar();

        Tarea tareaDb = tareaDao.findById(id).get();
        tareaDao.delete(tareaDb);

        response.setCodigo(HttpStatus.OK);
        response.setMensaje("Tarea eliminada correctamente!");

        return response;
    }
}
