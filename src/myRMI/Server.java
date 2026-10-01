package myRMI;

import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
            AddServImpl addServImpl = new AddServImpl();
            Naming.rebind("AddServer", addServImpl); // подключаем объект по этой ссылке
        } catch (Exception e){
            System.out.println("Возникло исключение "+e);
        }
    }
}
