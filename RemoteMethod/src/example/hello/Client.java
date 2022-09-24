package example.hello;import java.rmi.registry.LocateRegistry;import java.rmi.registry.Registry;

public class Client {
    private Client() {    }

    public static void main(String[] args) {
 //Matrix table 1
        int a = 3; int b = 3; // diastaseis table  
        int t1[][] = new int[a][b];  //create matrix table
        int t1k = 1; //1st timi stoixeiou
        for (int t1i = 0; t1i < a; t1i++) {// Fill table
            for (int t1j = 0; t1j < b; t1j++) {
                t1[t1i][t1j] = t1k++;// rand.nextInt(10);
            }
        }
 //Matrix table 2
        a = 3; b = 3; // diastaseis table
        int t2[][] = new int[a][b]; //create matrix table
        int t2k = 1; //1st timi stoixeiou
        for (int t2i = 0; t2i < a; t2i++) { // Fill table
            for (int t2j = 0; t2j < b; t2j++) {
                t2[t2i][t2j] = t2k++;// rand.nextInt(10);
            }
        }
        String operation="summation"; // summation or subtraction or multiplication or smm

        String host = (args.length < 1) ? null : args[0];
        try {
            //vriskei tin registry
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");//server stub
/*Step 1 - The Client sends two matrices to the Server, and the operation to be performed on them. */

/*Step2*/  System.out.println("response: "+stub.CHECK(t1, t2, operation));
 
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
