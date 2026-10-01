package myRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class AddServImpl extends UnicastRemoteObject implements AddServIntrf {

    public AddServImpl() throws RemoteException {

    }

    @Override
    public double add(double d1, double d2){
        return d1+d2;
    }

}
