package engine;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

// afou to ComptueEngine einai Remote, afou implement to compute .
public class ComputeEngine implements Compute {
/* oi methoous poy einai edo , einai prosvasimes apo ton pelati mon
   otan exoun oristei prota sto interface Compute , opos i executeTask*/
    public ComputeEngine() { //default constructor
	super();
    }

    public <T> T executeTask(Task<T> t) {
	return t.execute(); //methodos poy ipologizei to p
    }// prosvasei o pelatis exei mono se aftin ^

    public static void main(String[] args) {
	//install enos security manager. Leptomeries D25
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
	try {
            // Dimiourgia object
            Compute engine = new ComputeEngine();
            //Dimiourgia stub gia to object 
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);

            String name = "Compute_N";
            //vresto kai dimosiefsi to stub...
            Registry registry = LocateRegistry.getRegistry();
            //... me onoma to name 
            registry.rebind(name, stub);
            //rebind grafei to stub me onoma name stin registry 
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
