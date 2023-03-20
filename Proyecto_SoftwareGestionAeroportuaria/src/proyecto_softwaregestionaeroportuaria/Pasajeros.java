package proyecto_softwaregestionaeroportuaria;

public class Pasajeros {
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    public Pasajeros() {
    }

    public Pasajeros(String nombre, String pasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Pasajeros{" + "nombre=" + nombre + ", pasaporte=" + pasaporte + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
