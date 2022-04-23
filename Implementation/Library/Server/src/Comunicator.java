

import model.*;
import server.*;
import client.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Comunicator extends UnicastRemoteObject implements RemoteBook, RemoteMagazine {

    private DBConnector connector;
    private ArrayList<Object[]> list;

    public Comunicator() throws RemoteException {
        connector = new DBConnectorImplementation("org.postgresql.Driver","jdbc:postgresql://tai.db.elephantsql.com/naeoxool",
            "naeoxool","1eiSjWkSFVXj15hc0j47p_js1irgaDWr");
        connector.start();

        list=connector.getBookList();

    }

    public ArrayList<Object []> getBookList() throws RemoteException{
        list  = connector.getBookList();
        return list;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        //We need DB
        // resolve nul values
        connector.addBook(book.getId(), book.getIsbn(), book.getPublisher(),
            book.getTitle(), book.getYear_published(), book.getAuthor(),
            book.getEdition(),1802007570);
        list=connector.getBookList();

    }



    @Override
    public void removeBook(int id) throws RemoteException {
        connector.removeBook(id);
    }


    @Override
    public void addMagazine(Magazine magazine) throws RemoteException {
        //
    }


    @Override
    public void removeMagazine(int id) throws RemoteException{
        //
    }

}


