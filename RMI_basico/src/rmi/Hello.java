
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote  {

    /**
     *
     * @return
     * @throws RemoteException
     */
    public String sayHello() throws RemoteException;
}
