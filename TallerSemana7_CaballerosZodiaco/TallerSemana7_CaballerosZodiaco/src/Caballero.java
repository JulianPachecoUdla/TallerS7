public class Caballero {
    private int ID;
    private String nombre;
    private String rango; //Bronce, plata, oro
    private String constelacion;
    private int nivPoder; //1 a 10
    private Mision mision;



    public Caballero(int ID, String nombre, String rango, String constelacion, int nivPoder, Mision mision) {
        this.ID = ID;
        this.nombre = nombre;
        this.rango = rango;
        this.constelacion = constelacion;
        this.nivPoder = nivPoder;
        this.mision = mision;
    }

    //metodos getter
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRango() {
        return rango;
    }

    public String getConstelacion() {
        return constelacion;
    }

    public int getNivPoder() {
        return nivPoder;
    }

    public Mision getMision() {
        return mision;
    }

    //metodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }

    public void setNivPoder(int nivPoder) {
        this.nivPoder = nivPoder;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public float calcularAporte(){
        if (mision == null){
            return 0;
        }
        float aporte = mision.getRecompensa() * 0.10f;
        return aporte;
    }

    public float calcularImpuesto(){
        if (mision == null) return 0;

        float recompensa = mision.getRecompensa();
        float impuesto;

        if (recompensa <= 100000){
            impuesto = 0;
        } else if (recompensa <= 200000) {
            impuesto = 0.12f * (recompensa - 100000);
        } else if (recompensa <= 400000) {
            impuesto = 0.12f * 100000 + 0.25f * (recompensa - 200000);
        } else {
            impuesto = 0.12f * 100000 + 0.25f * 200000 + 0.35f * (recompensa - 400000);
        }
        return impuesto;
    }
}
