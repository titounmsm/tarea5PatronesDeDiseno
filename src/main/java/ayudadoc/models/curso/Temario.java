package ayudadoc.models.curso;

public class Temario {
    int semana; 
    String tema;
    public Temario(int semana, String tema) {
        this.semana = semana;
        this.tema = tema;
    }
    public void setSemana(int semana) {
        this.semana = semana;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public int getSemana() {
        return semana;
    }
    public String getTema() {
        return tema;
    }
}
