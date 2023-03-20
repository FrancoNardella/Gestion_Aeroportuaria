package proyecto_softwaregestionaeroportuaria;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compañias listaCompañias[] = new Compañias[10];
    private int numCompañia;

    public Aeropuerto() {
    }

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompañia = 0;
    }
    
    public Aeropuerto(String nombre, String ciudad, String pais, Compañias c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listaCompañias = c;
        this.numCompañia = c.length;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Compañias[] getListaCompañias() {
        return listaCompañias;
    }

    public void setListaCompañias(Compañias[] listaCompañias) {
        this.listaCompañias = listaCompañias;
    }

    public int getNumCompañia() {
        return numCompañia;
    }

    public void setNumCompañia(int numCompañia) {
        this.numCompañia = numCompañia;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", pais=" + pais + ", listaCompa\u00f1ias=" + listaCompañias + ", numCompa\u00f1ia=" + numCompañia + '}';
    }

    public void insertarCompañias(Compañias compañia){
        //Pedimos una compañia, y el mismo es insertado en el arreglo, utilizando la variable numCompañia como iterador
        listaCompañias[numCompañia] = compañia;
        numCompañia++;
    }
    
    public Compañias getCompañias(int i){
        return listaCompañias[i];
    }
    
    public Compañias getCompañias (String nombre){
        boolean encontrado = false;
        int i = 0;
        Compañias c = null;
        
        while((encontrado==false) && (i<listaCompañias.length)){
            //si el vuelo es igual a algun vuelo (getVuelo) de la listaVuelos
            if (nombre.equals(listaCompañias[i].getNombre())) {
                encontrado=true;
                c = listaCompañias[i];
                
            }
            i++;
        }
         return c;
    }
}