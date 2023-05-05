package ayudadoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ayudadoc.models.docente.Docente;
import ayudadoc.services.DocenteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-doc")
public class DocenteController {
    
    @Autowired
    private DocenteService docenteService;

    @GetMapping("/{id}")
    public Mono<Docente> getDocente(@PathVariable Long id) {

        return docenteService.getById(id);
    }

    @GetMapping("/docentes")
    public Flux<Docente> getDocentes() {
        return docenteService.getAll();
    }

    @PostMapping
    public Mono<Docente> guardarDocente(@RequestBody Docente docente) {
        return docenteService.saveDocente(docente);
    }
}