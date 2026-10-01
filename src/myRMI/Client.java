package myRMI;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try{
            String ip = "localhost";
            String serverURL = "rmi://"+ip+"/AddServer";
            AddServIntrf addServIntrf = (AddServIntrf) Naming.lookup(serverURL);
            System.out.println("Сумма"+2+" и "+5+" это: "+addServIntrf.add(2,5));
        } catch (Exception e) {
            System.out.println("Произошло исключение "+e);
        }

    }
}
