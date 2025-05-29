public class Mision {
    public String descripcion;
    public int nivDificultad; //nivdel de dificultad 1-5
    public float recompensa;

    public Mision() {
    }

    public Mision(String descripcion, int nivDificultad, float recompensa) {
        this.descripcion = descripcion;
        this.nivDificultad = nivDificultad;
        this.recompensa = recompensa;
    }

    //metodos

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivDificultad() {
        return nivDificultad;
    }

    public float getRecompensa() {
        return recompensa;
    }
}
