package ayudadoc.services;

import org.springframework.stereotype.Service;

import ayudadoc.helpers.AyudocLog;
import ayudadoc.helpers.error.AyudaDocException;
import ayudadoc.models.curso.CursoBuilder;
import ayudadoc.models.curso.ICurso;
import ayudadoc.models.curso.IPeriodoAcademico;
import ayudadoc.models.curso.PeriodoAcademico;
import ayudadoc.models.curso.PeriodoAcademicoBuilder;
import reactor.core.publisher.Mono;

@Service
public class CursoService {
    
    private IPeriodoAcademico periodoActual;
    private ICurso cursoActual;

    public Mono<IPeriodoAcademico> createPeriodo(String codigo, String descripcion, 
                                                 String tipo, String fechaInicio, String fechaFin, 
                                                 String modalidad) {

        periodoActual = new PeriodoAcademico(codigo, descripcion, tipo, 
                                        fechaInicio, fechaFin, modalidad);

        AyudocLog.getInstance().log("debug", "Creando: " + periodoActual.getCodigo() );
        return Mono.just( periodoActual );
    }

    public Mono<IPeriodoAcademico> getPeriodo(String codigo)  {

        AyudocLog.getInstance().log("debug", "Recibe el código: ["+ codigo +"]");
        IPeriodoAcademico periodo = null;

        if (periodoActual!=null && periodoActual.getCodigo().equals(codigo))   {

            periodo = periodoActual;
        }
        else {

            return Mono.error(
                new AyudaDocException("Periodo académico no existe", "El periodo académico no existe")
            );
        }
        //periodo.addActividad("Prematricula", "Jueves 16 y viernes 17 de marzo");
        //periodo.addActividad("Matrícula regular", "Lunes 20 al viernes 24 de marzo");
        //periodo.addActividad("Clases", "Inicio: Lunes 27 de marzo - Término: Viernes 14 de julio");
        
        return Mono.just(periodo);
    }

    public Mono<IPeriodoAcademico> createPeriodo(IPeriodoAcademico periodo) {

        PeriodoAcademicoBuilder periodoBuilder = new PeriodoAcademicoBuilder(periodo.getCodigo(), 
                                                                             periodo.getDescripcion());
        if (periodo.getFechaInicio()!=null)    {

            periodoBuilder.withPlanificacion( periodo.getTipo(), periodo.getFechaInicio(), periodo.getFechaFin());
        }

        if (periodo.getModalidad()!=null)    {

            periodoBuilder.withModalidad( periodo.getModalidad());
        }

        if (periodo.getActividades()!=null)    {

            periodoBuilder.withActividades( periodo.getActividades());
        }

        periodoActual = periodoBuilder.build();
        AyudocLog.getInstance().log("debug", "Creando con build: " + periodoActual.getCodigo() );
        return Mono.just( periodoActual );
    }

    
    public Mono<ICurso> createCurso(ICurso curso) {

        CursoBuilder cursoBuilder = new CursoBuilder(curso.getCodigo(),curso.getNombreCurso());
        
        if (curso.getVigenciaPlan()!=null)    {

            cursoBuilder.withPlanificacion( curso.getEscuela(), curso.getVigenciaPlan());
        }

        if (curso.getTemario()!=null)    {

            cursoBuilder.withTemario( curso.getTemario());
        }

        cursoActual = cursoBuilder.build();
        AyudocLog.getInstance().log("debug", "Creando con build: " + cursoActual.getCodigo() );
        return Mono.just( cursoActual );
    }

    public Mono<ICurso> getCurso(int codigoCurso) {
        AyudocLog.getInstance().log("debug", "Recibe el código: ["+ codigoCurso +"]");
        ICurso curso = null;

        if (cursoActual!=null && cursoActual.getCodigo() == codigoCurso)   {

            curso = cursoActual;
        }
        else {

            return Mono.error(
                new AyudaDocException("Curso no existe", "El Curso no existe")
            );
        }
        //periodo.addActividad("Prematricula", "Jueves 16 y viernes 17 de marzo");
        //periodo.addActividad("Matrícula regular", "Lunes 20 al viernes 24 de marzo");
        //periodo.addActividad("Clases", "Inicio: Lunes 27 de marzo - Término: Viernes 14 de julio");
        
        return Mono.just(curso);
    }
}
