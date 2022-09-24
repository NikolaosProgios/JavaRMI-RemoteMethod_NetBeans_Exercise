package compute;
import java.rmi.Remote;
import java.rmi.RemoteException;

//oses methodous orisoume mesa sto Compute panta me to throws
public interface Compute extends Remote {
	<T> T executeTask(Task<T> t) throws RemoteException;
        /* i executeTask dexetai os orisma ena object ypou Tast (Task<T> t) 
        kai epistrefei pali ena object typoy task */
}
