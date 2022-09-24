package example.hello;
import java.rmi.registry.Registry;// i eidia i registry
import java.rmi.registry.LocateRegistry;//mas allow na vriskoume tin registry sto diktyos
import java.rmi.RemoteException;import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
    public Server() {  }
    //H monadiki method pou einai diathesimi sto system, afou
    //mono afti einai oristei sto public interface        
    public String CHECK(int[][] t1, int[][] t2, String operation) { String print = "";
        
    if ((t1.length == t2.length) && ((t1[0].length == t2[0].length))) {
/*Άθροιση*/if ("summation".equals(operation)) {            
                print="Operation summation OKAY\n";
                int a = t1.length; int b = t1[0].length; // diastaseis table
                int t3[][] = new int[a][b];//t3=t1+t2
                for (int t3i = 0; t3i < a; t3i++) {// Fill table
                    for (int t3j = 0; t3j < b; t3j++) {
                        t3[t3i][t3j]= t1[t3i][t3j] + t2[t3i][t3j];
                    }
                }
                print+="New Table3=";
                for (int t3i = 0; t3i < t3.length; t3i++) {
                    print+="\n";
                    for (int t3j = 0; t3j < t3[0].length; t3j++) {
                        print+=t3[t3i][t3j] + " ";
                    }
                }
            } 
/*Αφαίρεση*/ else if ("subtraction".equals(operation)){
                print="Operation subtraction OKAY\n";
                int a = t1.length; int b = t1[0].length; // diastaseis table
                int t3[][] = new int[a][b];//t3=t1+t2
                for (int t3i = 0; t3i < a; t3i++) {// Fill table
                    for (int t3j = 0; t3j < b; t3j++) {
                        t3[t3i][t3j] =  t1[t3i][t3j]
                                      - t2[t3i][t3j];
                    }
                }
                print+="New Table3=";
                for (int t3i = 0; t3i < t3.length; t3i++) {
                    print+="\n";
                    for (int t3j = 0; t3j < t3[0].length; t3j++) {
                        print+=t3[t3i][t3j] + " ";
                    }
                }
        }
/*Πολ/μός*/ else if ("multiplication".equals(operation)) {
                print="Operation multiplication OKAY\n";
                int a = t1.length; int b = t1[0].length; // diastaseis table
                int t3[][] = new int[a][b];//t3=t1+t2
                for (int t3i = 0; t3i < a; t3i++) {// Fill table
                    for (int t3j = 0; t3j < b; t3j++) {
                        t3[t3i][t3j] =  t1[t3i][t3j]
                                      * t2[t3i][t3j];
                    }
                }
                print+="New Table3=";
                for (int t3i = 0; t3i < t3.length; t3i++) {
                    print+="\n";
                    for (int t3j = 0; t3j < t3[0].length; t3j++) {
                        print+=t3[t3i][t3j] + " ";
                    }
                }
        }
/*ΓραμμηΣτηλη*/else if ("smm".equals(operation)){//Standard matrix multiplication
                print="Operation matrix multiplication OKAY\n";
                int a = t1.length; int b = t1[0].length; // diastaseis table
                int t3[][] = new int[a][b];//t3=t1+t2
                for (int t3i = 0; t3i < a; t3i++) {// Fill table
                    for (int t3j = 0; t3j < b; t3j++) {
                        t3[t3i][t3j] =  0;
                        for(int t3k=0;t3k<3;t3k++){
                            t3[t3i][t3j]+=t1[t3i][t3k] * t2[t3k][t3j];
                        }
                    }
                }
                print+="New Table3=";
                for (int t3i = 0; t3i < t3.length; t3i++) {
                    print+="\n";
                    for (int t3j = 0; t3j < t3[0].length; t3j++) {
                        print+=t3[t3i][t3j] + " ";
                    }
                }
            }
        }else {print="Wrong dimensions";}    
    return print+="\n";
    }

    public static void main(String args[]) {

        try {  //Me tis parakato entoles , star o server
            // Neo obj typou server
            Server obj = new Server();
            //skeleton obj
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            //vrisouskoume pou trexei i registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
