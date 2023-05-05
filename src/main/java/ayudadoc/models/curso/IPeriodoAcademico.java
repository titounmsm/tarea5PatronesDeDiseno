package ayudadoc.models.curso;

import java.util.List;

public interface IPeriodoAcademico extends IRegimenAcademico, IModalidad {

    public List<Actividad> getActividades();

    public void addActividad( String actividad, String fechas );

    public String getCodigo();

    public String getDescripcion();
    
    public String getTipo();

    public String getFechaInicio();
    
    public String getFechaFin();

    public String getModalidad();

}
