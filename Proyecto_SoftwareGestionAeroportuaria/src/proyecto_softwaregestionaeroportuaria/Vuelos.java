package proyecto_softwaregestionaeroportuaria;

public class Vuelos {
    private String id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int numMaxPasajeros;
    private int numActualPasajeros;
    private Pasajeros listaPasajeros[];

    public Vuelos() {
    }

    public Vuelos(String id, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros = 0;
        this.listaPasajeros = new Pasajeros[numMaxPasajeros];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public void setNumMaxPasajeros(int numMaxPasajeros) {
        this.numMaxPasajeros = numMaxPasajeros;
    }

    public int getNumActualPasajeros() {
        return numActualPasajeros;
    }

    public void setNumActualPasajeros(int numActualPasajeros) {
        this.numActualPasajeros = numActualPasajeros;
    }


    @Override
    public String toString() {
        return "Vuelos{" + "id=" + id + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", precio=" + precio + ", numMaxPasajeros=" + numMaxPasajeros + ", numActualPasajeros=" + numActualPasajeros + ", listaPasajeros=" + listaPasajeros + '}';
    }
    
    public void insertarPasajeros(Pasajeros pasajero){
        //Pedimos un pasajero, y el mismo es insertado en el arreglo, utilizando la variable numActual como iterador
        listaPasajeros[numActualPasajeros] = pasajero;
        numActualPasajeros++;
    }
    
    public Pasajeros getPasajeros (int i){
        return listaPasajeros[i];
    }
    
    public Pasajeros getPasajeros (String pasaporte){
        boolean encontrado = false;
        int i = 0;
        Pasajeros pas = null;
        
        while((encontrado==false) && (i<listaPasajeros.length)){
            //si el pasaporte es igual a algun pasaporte (getPasaporte) de la listaPasajeros
            if (pasaporte==listaPasajeros[i].getPasaporte()) {
                encontrado=true;
                pas = listaPasajeros[i];
                
            }
            i++;
        }
         return pas;
    }
}
