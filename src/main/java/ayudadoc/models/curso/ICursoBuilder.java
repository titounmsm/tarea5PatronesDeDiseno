package ayudadoc.models.curso;

import java.util.List;

public interface ICursoBuilder {
    public CursoBuilder withPlanificacion( String escuela, String vigenciaPlan);

    public CursoBuilder withTemario(List<Temario> Temario);
 
}
