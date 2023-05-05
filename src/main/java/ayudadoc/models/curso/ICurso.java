package ayudadoc.models.curso;

import java.util.List;
import java.util.Map;

/**
 * ICurso
 */
public interface ICurso extends IPlanEstudios{

    public  List<Temario>  getTemario();
    public void addTemario( int semana, String tema );
    public int getCodigo();
    public String getNombreCurso();
}
