package proyecto_softwaregestionaeroportuaria;

public class Compañias {
   private String nombre;
   private Vuelos listaVuelos[] = new Vuelos[10];
   private int numVuelo=0;

   public Compañias(String nombre) {
       this.nombre = nombre;
   }

   public Compañias(String nombre, Vuelos v[]) {
       this.nombre = nombre;
       listaVuelos = v;
       numVuelo = v.length;
   }

   public String getNombre() {
       return nombre;
   }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vuelos[] getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(Vuelos[] listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    @Override
    public String toString() {
        return "Compa\u00f1ias{" + "nombre=" + nombre + ", listaVuelos=" + listaVuelos + ", numVuelo=" + numVuelo + '}';
    }
   
    public void insertarVuelos(Vuelos vuelo){
        //Pedimos un vuelo, y el mismo es insertado en el arreglo, utilizando la variable numVuelo como iterador
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }
    
    public Vuelos getVuelo (int i){
        return listaVuelos[i];
    }
    
    public Vuelos getVuelo (String id){
        boolean encontrado = false;
        int i = 0;
        Vuelos v = null;
        
        while((encontrado==false) && (i<listaVuelos.length)){
            //si el vuelo es igual a algun vuelo (getVuelo) de la listaVuelos
            if (id==listaVuelos[i].getId()) {
                encontrado=true;
                v = listaVuelos[i];
                
            }
            i++;
        }
         return v;
    }
}
