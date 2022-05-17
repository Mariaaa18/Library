package client;

import model.LoanMagazine;
import model.Magazine;
import server.RemoteBook;
import server.RemoteLoanMagazine;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoanMagazineClientImplementation extends UnicastRemoteObject implements LoanMagazineClient{
    private RemoteLoanMagazine remoteLoanMagazine;

    public LoanMagazineClientImplementation(String  host, int port) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host,port);
        remoteLoanMagazine = (RemoteLoanMagazine) registry.lookup("loanMagazine");

    }

    @Override
    public void addMagazineLoan(LoanMagazine loanMagazine) throws SQLException, RemoteException {
        remoteLoanMagazine.addMagazineLoan(loanMagazine);
    }

    @Override
    public ArrayList<Magazine> getAvailableMagazineList() throws SQLException, RemoteException {
        return remoteLoanMagazine.getAvailableMagazineList();
    }

    @Override
    public void close() throws IOException {
        UnicastRemoteObject.unexportObject(this,true);
    }
}