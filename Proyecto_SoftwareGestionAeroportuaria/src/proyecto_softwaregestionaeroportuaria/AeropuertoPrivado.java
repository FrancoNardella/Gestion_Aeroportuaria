package proyecto_softwaregestionaeroportuaria;

public class AeropuertoPrivado extends Aeropuerto{
    private String listaEmpreasas[] = new String[10];
    private int numEmpresa;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañias[] c, String e[]) {
        super(nombre, ciudad, pais, c);
        this.listaEmpreasas = e;
        this.numEmpresa = e.length;
    }

    public String[] getListaEmpreasas() {
        return listaEmpreasas;
    }

    public void setListaEmpreasas(String[] listaEmpreasas) {
        this.listaEmpreasas = listaEmpreasas;
    }

    public int getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(int numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    @Override
    public String toString() {
        return "AeropuertoPrivado{" + "listaEmpreasas=" + listaEmpreasas + ", numEmpresa=" + numEmpresa + '}';
    }
    
    public void insertarEmpresas(String e[]){
        //Pedimos una compañia, y el mismo es insertado en el arreglo, utilizando la variable numCompañia como iterador
        this.listaEmpreasas = e;
        this.numEmpresa = e.length;
    }
    
    public void insertarEmpresa(String e){
        listaEmpreasas[numEmpresa] = e;
        numEmpresa++;
    }
    
}
