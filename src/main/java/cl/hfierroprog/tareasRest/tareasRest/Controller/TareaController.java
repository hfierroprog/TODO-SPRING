package cl.hfierroprog.tareasRest.tareasRest.Controller;

import cl.hfierroprog.tareasRest.tareasRest.Entity.ResponseGuardar;
import cl.hfierroprog.tareasRest.tareasRest.Entity.Tarea;
import cl.hfierroprog.tareasRest.tareasRest.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/getTareas")
    @CrossOrigin(allowedHeaders = "*")
    public List<Tarea> getTarasController(@RequestParam("filtro") String filtro) {
        return tareaService.getTareas(filtro);
    }

    @PostMapping("/guardarTarea")
    @CrossOrigin(allowedHeaders = "*")
    public ResponseGuardar guardarTarea(@RequestBody Tarea tarea) {
        return tareaService.guardarTarea(tarea);
    }

    @PutMapping("/actualizarTarea")
    @CrossOrigin(allowedHeaders = "*")
    public ResponseGuardar actualizarTarea(@RequestBody Tarea tarea){
        return tareaService.cambiarEstadoTarea(tarea);
    }

    @DeleteMapping("/eliminarTarea")
    @CrossOrigin(allowedHeaders = "*")
    public ResponseGuardar eliminarTarea(@RequestParam("id") Integer id) {
        return tareaService.eliminarTarea(id);
    }
}
