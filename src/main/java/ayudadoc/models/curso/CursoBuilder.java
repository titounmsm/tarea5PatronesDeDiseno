package ayudadoc.models.curso;

import java.util.ArrayList;
import java.util.List;

public class CursoBuilder implements ICursoBuilder{
    private int codigo;
    private String nombreCurso;
    
    private String escuela;
    private String vigenciaPlan;

   
    private List<Temario> temas = new ArrayList<Temario>();
    
    public CursoBuilder(int codigo, String nombreCurso) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
    }

    @Override
    public CursoBuilder withPlanificacion(String escuela, String vigenciaPlan) {
        this.escuela = escuela;
        this.vigenciaPlan = vigenciaPlan;
        return this;        
    }

    @Override
    public CursoBuilder withTemario(List<Temario> Temario) {
        this.temas = Temario;
        return this;
    }

    public Curso build() {
    
        Curso curso = new Curso();  
        curso.setCodigo(this.codigo);
        curso.setEscuela(this.escuela);
        curso.setNombreCurso(nombreCurso);
        curso.setVigenciaPlan(this.vigenciaPlan); 
        
        curso.setTemas(this.temas);
        
        return curso;
    }
    
    
}
