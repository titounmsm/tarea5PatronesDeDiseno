package ayudadoc.models.curso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ayudadoc.models.docente.Docente;

public class Curso implements ICurso {
    private int codigo;
    private String nombreCurso;
    
    private String escuela;
    private String vigenciaPlan;

   
    private List<Temario> temas = new ArrayList<Temario>();
    public Curso(){}
    public Curso(int codigo, String nombreCurso, String escuela, String vigenciaPlan, List<Temario> temas) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.escuela = escuela;
        this.vigenciaPlan = vigenciaPlan;
        this.temas = temas;
    }

    @Override
    public String getEscuela() {
        return escuela;
    }
    @Override
    public String getVigenciaPlan() {
        return vigenciaPlan;
    }
    @Override
    public List<Temario> getTemario() {
        return temas;
    }
    @Override
    public void addTemario(int semana, String tema) {
        temas.add(new Temario(semana, tema));
    }


    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    public void setVigenciaPlan(String vigenciaPlan) {
        this.vigenciaPlan = vigenciaPlan;
    }
    public List<Temario> getTemas() {
        return temas;
    }
    public void setTemas(List<Temario> temas) {
        this.temas = temas;
    }

    
    
    
}
