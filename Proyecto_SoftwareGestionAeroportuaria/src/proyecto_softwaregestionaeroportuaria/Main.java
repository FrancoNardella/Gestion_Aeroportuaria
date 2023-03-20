package proyecto_softwaregestionaeroportuaria;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    final static int numAerop = 4;
    static Aeropuerto aeropuertos[] = new Aeropuerto[numAerop];
    
    public static void main(String[] args) {
        
        insertarDatosAeropuertos(aeropuertos);
        menu();
        
    }
    
    public static void insertarDatosAeropuertos(Aeropuerto aeropuertos[]){
        aeropuertos[0] = new AeropuertoPublico(100000000, "Ezeiza", "Buenos Aires", "Argentina");
        aeropuertos[0].insertarCompañias(new Compañias("Aerolineas Argentinas"));
        aeropuertos[0].insertarCompañias(new Compañias("LATAM"));
        aeropuertos[0].getCompañias("Aerolineas Argentinas").insertarVuelos(new Vuelos("AA45", "Buenos Aires", "Lima", 850.90, 150));
        aeropuertos[0].getCompañias("Aerolineas Argentinas").insertarVuelos(new Vuelos("AA44", "Buenos Aires", "Rio de Janeiro", 800, 120));
        aeropuertos[0].getCompañias("LATAM").insertarVuelos(new Vuelos("LT14", "Lima", "Roma", 500.90, 180));
        aeropuertos[0].getCompañias("Aerolineas Argentinas").getVuelo("AA45").insertarPasajeros(new Pasajeros("Pasajero1", "OP2MNR5", "Argentino"));
        aeropuertos[0].getCompañias("Aerolineas Argentinas").getVuelo("AA45").insertarPasajeros(new Pasajeros("Pasajero2", "PL6MER1", "Argentino"));
        aeropuertos[0].getCompañias("LATAM").getVuelo("LT14").insertarPasajeros(new Pasajeros("Pasajero3", "LD3MET8", "Colombiano"));
        
        aeropuertos[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
        aeropuertos[1].insertarCompañias(new Compañias("AirEuropa"));
        String empresas[] = {"Empresa1", "Empresa2"};
        ((AeropuertoPrivado)aeropuertos[1]).insertarEmpresas(empresas);
        aeropuertos[1].getCompañias("AirEuropa").insertarVuelos(new Vuelos("AE014", "Madrid", "Buenos Aires", 1000.25, 200));
        aeropuertos[1].getCompañias("AirEuropa").getVuelo("AE014").insertarPasajeros(new Pasajeros("Pasajero4", "LD3MET8", "Colombiano"));
        
        aeropuertos[2] = new AeropuertoPublico(60000000, "Aeropuerto Bogota", "Bogota", "Colombia");
        aeropuertos[2].insertarCompañias(new Compañias("AirAmerica"));
        aeropuertos[2].insertarCompañias(new Compañias("VuelaBogota"));
        aeropuertos[2].getCompañias("AirAmerica").insertarVuelos(new Vuelos("AAM030", "Bogota", "Lima", 200.20, 130));
        aeropuertos[2].getCompañias("AirAmerica").insertarVuelos(new Vuelos("AAM031", "Bogota", "Lima", 200.10, 130));
        aeropuertos[2].getCompañias("AirAmerica").getVuelo("AAM030").insertarPasajeros(new Pasajeros("Pasajero5", "PD3RTC9", "Peruano"));
        aeropuertos[2].getCompañias("AirAmerica").getVuelo("AAM030").insertarPasajeros(new Pasajeros("Pasajero6", "AW9MHT2", "Chileno"));
        
        aeropuertos[3] = new AeropuertoPublico(50000000, "Aeropuerto Mexico", "Mexico", "Mexico");
        aeropuertos[3].insertarCompañias(new Compañias("AeroMexico"));
        aeropuertos[3].getCompañias("AeroMexico").insertarVuelos(new Vuelos("AEM1053", "Mexico", "Nueva York", 500.20, 160));
        aeropuertos[3].getCompañias("AeroMexico").insertarVuelos(new Vuelos("AEM1052", "Mexico", "Lima", 450.10, 150));
        aeropuertos[3].getCompañias("AeroMexico").getVuelo("AEM1053").insertarPasajeros(new Pasajeros("Pasajero7", "CG3FJB5", "Ecuatoriano"));
        
    }
    
    public static void menu(){
        String nombreAeropuerto, nombreCompañia, origen, destino;
        Aeropuerto aeropuerto;
        Compañias compañias;
        int op=0;
        
        do{
            System.out.println("\n\t..:MENU:..");
            System.out.println("1. Consultar Aeropuertos (Publicos o Privados)");
            System.out.println("2. Ver Empresas(Privado) o Subvención(Publico)");
            System.out.println("3. Lista Compañias por Aeropuerto");
            System.out.println("4. Lista de Vuelos por Compañia");
            System.out.println("5. Lista posibles Vuelos de Origen a Destinos");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");
            op = sc.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2:
                    System.out.println("");
                    verEmpresaSubvencion(aeropuertos);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("\nIngrese nombre del Aeropuerto: ");
                    nombreAeropuerto = sc.nextLine();
                    System.out.println("");
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    
                    if (aeropuerto==null) {
                        System.out.println("El Aeropuerto no existe.");                       
                    }else{
                        mostrarCompañias(aeropuerto);
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("\nIngrese nombre del Aeropuerto: ");
                    nombreAeropuerto = sc.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    
                    if (aeropuerto==null) {
                        System.out.println("El Aeropuerto no existe.");
                                             
                    }else{
                        System.out.print("Ingrese el nombre de la compañia: ");
                        nombreCompañia = sc.nextLine();
                        compañias = aeropuerto.getCompañias(nombreCompañia);
                        mostrarVuelos(compañias);
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("\nIngrese ciudad de origen: ");
                    origen = sc.nextLine();
                    System.out.print("Ingrese ciudad de destino: ");
                    destino = sc.nextLine();
                    mostrarCiudadOrigenDestino(origen, destino, aeropuertos);
                    break;
                case 6:
                    System.out.println("\nGracias Vuelva Pronto!");
                    break;
                default:  
                    System.out.println("ERROR: Seleccione una opcion valida");
            }
            System.out.println("");
        }while(op!=6);
    }
    
    //OP 1
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for (int i = 0; i < aeropuertos.length; i++) {
            //instanceof determina si el aeropuerto pertenece o no a aerop privado.
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("\nAeropuerto Privado");
                System.out.println("\tNombre: " + aeropuertos[i].getNombre());
                System.out.println("\tCiudad: " + aeropuertos[i].getCiudad());
                System.out.println("\tPais: " + aeropuertos[i].getPais());
                
            }else{
                System.out.println("\nAeropuerto Publico");
                System.out.println("\tNombre: " + aeropuertos[i].getNombre());
                System.out.println("\tCiudad: " + aeropuertos[i].getCiudad());
                System.out.println("\tPais: " + aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }
    
    //OP 2
    public static void verEmpresaSubvencion(Aeropuerto aeropuertos[]){
        String empresas[];
        
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado: " + aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpreasas();
                System.out.println("Empresas:");
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println("\t" + empresas[j]);
                    
                }
                
            }else{
                System.out.println("Aeropuerto Publico: " + aeropuertos[i].getNombre());
                System.out.println("\tSubvencion: " + ((AeropuertoPublico)aeropuertos[i]).getSubvencion());     
                
            }
            System.out.println("");
        }
    }
    
    //OP 3
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
               
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        
        while((encontrado==false) && (i<aeropuertos.length)){
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado=true;
                aero = aeropuertos[i];
                
            }
            i++; 
        }
        
         return aero;
    }
    
    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas compañias del aeropuerto: " + aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
            System.out.println("\t- " + aeropuerto.getCompañias(i).getNombre());
        }
    }
    
    //OP 4
    public static void mostrarVuelos(Compañias compañia){
        System.out.println("\nLos vuelos de la compañia: " + compañia.getNombre());
        for (int i = 0; i < compañia.getNumVuelo(); i++) {
            System.out.println("\tId: " + compañia.getVuelo(i).getId());
            System.out.println("\tCiudad Origen: " + compañia.getVuelo(i).getCiudadOrigen());
            System.out.println("\tCiudad Destino: " + compañia.getVuelo(i).getCiudadDestino());
            System.out.println("\tPrecio: $" + compañia.getVuelo(i).getPrecio());
            System.out.println("");
        }
    }
    
    //OP 5
    public static Vuelos[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelos vuelo;
        int contador = 0;
        Vuelos listaVuelos[];
        
        for (int i = 0; i < aeropuertos.length; i++) { //Recorremos aeropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) { //Recorremos compañias
                for (int k = 0; k < aeropuertos[i].getCompañias(j).getNumVuelo(); k++) { //Recorremos vuelos
                    vuelo = aeropuertos[i].getCompañias(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelos[contador];
        int q = 0;
        
        //Comparamos si la ciudad de origen que es ingresada es igual a alguna que tenemos y la de destino igual, se guarda el vuelo dentro del arreglo lista de vuelos
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañias(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañias(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }  
            }
        }
        return listaVuelos;
    }
    
    public static void mostrarCiudadOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelos vuelo[];
        vuelo = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if (vuelo.length==0) {
            System.out.println("No existen vuelos de esa ciudad origen a destino");
        }else{
            System.out.println("\nVuelos encontrados: ");
            for (int i = 0; i < vuelo.length; i++) {
                System.out.println("\tId: " + vuelo[i].getId());
                System.out.println("\tCiudad Origen: " + vuelo[i].getCiudadOrigen());
                System.out.println("\tCiudad Destino: " + vuelo[i].getCiudadDestino());
                System.out.println("\tPrecio: $" + vuelo[i].getPrecio());
                System.out.println("");
            }
        }
        
    }
}
