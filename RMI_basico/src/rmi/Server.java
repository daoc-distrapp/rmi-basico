
package rmi;

import java.rmi.registry.Registry;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello, Serializable {

    public Server() {}

    @Override
    public String sayHello() {
    	System.out.println("Petici�n recibida");
        return "Hello, world!";
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            //Obtiene una referencia a un registro activo en el puerto por defecto (1099)
            Registry registry = LocateRegistry.getRegistry();
            
            //Crea un nuevo registro local a este programa, en el puerto indicado
            //Registry registry = LocateRegistry.createRegistry(1099);
            
            //Registra el proxy (stub) del servidor (clase Server) en el registro, con una clave o nombre
            registry.rebind("Hello", stub); //o registry.bind("Hello", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
