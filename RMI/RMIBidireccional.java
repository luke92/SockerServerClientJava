import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Observable;
import java.util.Observer;
import java.net.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

interface ReceiveMessageInterface extends Remote
{
    /**
     * @param x
     * @throws RemoteException
     */
    void receiveMessage(String x) throws RemoteException;

    /**
     * @param observer
     * @throws RemoteException
     */
    void addObserver(Remote observer) throws RemoteException;
}

/**
 * 
 */
class RmiClient extends UnicastRemoteObject
{
    /**
     * @param args
     */
    static public void main(String args[])
    {
        ReceiveMessageInterface rmiServer;
        Registry registry;
        String serverAddress = args[0];
        String serverPort = args[1];
        String text = args[2];
        System.out.println("sending " + text + " to " + serverAddress + ":" + serverPort);
        try
        { // Get the server's stub
            registry = LocateRegistry.getRegistry(serverAddress, (new Integer(serverPort)).intValue());
            rmiServer = (ReceiveMessageInterface) (registry.lookup("rmiServer"));

            // RMI client will give a stub of itself to the server
            Remote aRemoteObj = (Remote) UnicastRemoteObject.exportObject(new RmiClient(), 0);
            rmiServer.addObserver(aRemoteObj);

            // call the remote method
            rmiServer.receiveMessage(text);
            // update method will be notified
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (NotBoundException e)
        {
            System.err.println(e);
        }
    }

    public void update(String a) throws RemoteException
    {
        // update should take some serializable object as param NOT Observable
        // and Object
        // Server callsbacks here
    }
}

/**
 * 
 */
class RmiServer extends Observable implements ReceiveMessageInterface
{
    String address;
    Registry registry;

    /**
     * {@inheritDoc}
     */
    public void receiveMessage(String x) throws RemoteException
    {
        System.out.println(x);
        setChanged();
        notifyObservers(x + "invoked me");
    }

    /**
     * {@inheritDoc}
     */
    public void addObserver(final Remote observer) throws RemoteException
    {
        // This is where you plug in client's stub
        super.addObserver(new Observer()
        {
            @Override
            public void update(Observable o,
                Object arg)
            {
                try
                {
                    ((RmiClient) observer).update((String) arg);
                }
                catch (RemoteException e)
                {

                }
            }
        });
    }

    /**
     * @throws RemoteException
     */
    public RmiServer() throws RemoteException
    {
        try
        {
            address = (InetAddress.getLocalHost()).toString();
        }
        catch (Exception e)
        {
            System.out.println("can't get inet address.");
        }
        int port = 3232;
        System.out.println("this address=" + address + ",port=" + port);
        try
        {
            registry = LocateRegistry.createRegistry(port);
            registry.rebind("rmiServer", this);
        }
        catch (RemoteException e)
        {
            System.out.println("remote exception" + e);
        }
    }

    /**
     * 
     * @param args
     */
    static public void main(String args[])
    {
        try
        {
            RmiServer server = new RmiServer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}