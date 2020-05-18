
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        try {
        	// Obtenemos una referencia al registro en el localhost, puerto 1099
        	Registry registry = LocateRegistry.getRegistry();
        	
        	// Obtenemos una referencia al registro en el equipo <nombre>, en el puerto <puerto>
            //Registry registry = LocateRegistry.getRegistry(<nombre>, <puerto>);
        	
        	// Buscamos el servidor en el registro por clave (nombre con que se registro)
            Hello stub = (Hello) registry.lookup("Hello");
            
            //Ejecutamos cualquiera de sus métodos
            String response = stub.sayHello();
            System.out.println("Respuesta: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
