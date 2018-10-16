package cl.hfierroprog.tareasRest.tareasRest.Dao;

import cl.hfierroprog.tareasRest.tareasRest.Entity.Tarea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TareaDao extends CrudRepository<Tarea, Integer> {

    @Query("SELECT t from Tarea t where t.estado = 'COMPLETADA'")
    List<Tarea> getTareasCompletadas();

    @Query("SELECT t from Tarea t where t.estado = 'POR COMPLETAR'")
    List<Tarea> getTareasPorCompletar();
}
