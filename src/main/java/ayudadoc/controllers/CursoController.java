package ayudadoc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ayudadoc.models.curso.Curso;
import ayudadoc.models.curso.ICurso;
import ayudadoc.models.curso.IPeriodoAcademico;
import ayudadoc.models.curso.PeriodoAcademico;
import ayudadoc.services.CursoService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-cur")
public class CursoController {
    
    
    @Autowired
    private CursoService cursoService;

   

    @GetMapping("/{codigoCurso}")
    public Mono<ICurso> getCurso(@PathVariable int codigoCurso) {

        return cursoService.getCurso(codigoCurso);
    }

    @PostMapping("/c2")
    public Mono<ICurso> crearCursoC2(@RequestBody Curso curso) {

        return cursoService.createCurso( curso );
    }



}
