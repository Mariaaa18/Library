package server;

import model.*;
import server.storage.BookStorage;
import server.storage.LibrarianStorage;
import server.storage.LibraryUserStorage;
import server.storage.MagazineStorage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class Communicator extends UnicastRemoteObject implements RemoteBook, RemoteMagazine, RemoteLibrarian, RemoteLibraryUser{
    private MagazineStorage magazineStorage;
    private BookStorage bookStorage;
    private LibrarianStorage librarianStorage;
    private LibraryUserStorage libraryUserStorage;
//    private GenreStorage genreStorage;


    public Communicator(MagazineStorage magazineStorage, BookStorage bookStorage, LibrarianStorage librarianStorage,LibraryUserStorage libraryUserStorage) throws RemoteException {
        this.magazineStorage = magazineStorage;
        this.bookStorage = bookStorage;
        this.librarianStorage = librarianStorage;
        this.libraryUserStorage = libraryUserStorage;
//        this.genreStorage = genreStorage;
    }

//    @Override public void addGenre(Genre genre)
//        throws SQLException, RemoteException
//    {
//        genreStorage.addGenre(genre);
//    }
//
//    @Override public void removeGenre(int id)
//        throws SQLException, RemoteException
//    {
//        genreStorage.removeGenre(id);
//    }
//
//    @Override public ArrayList<Genre> getGenreList()
//        throws SQLException, RemoteException
//    {
//        return genreStorage.getGenreList();
//    }

    @Override
    public void addBook(Book book) throws RemoteException, SQLException {
        bookStorage.addBook(book);

    }

    @Override
    public void removeBook(int id) throws RemoteException, SQLException
    {
        bookStorage.removeBook(id);
    }

    @Override public ArrayList<Book> getBookList() throws RemoteException, SQLException
    {
        return bookStorage.getBookList();
    }

    @Override public GenreList getGenreList()
        throws RemoteException, SQLException
    {
        return bookStorage.getGenreList();
    }

    @Override
    public void addMagazine(Magazine magazine) throws RemoteException, SQLException {
        magazineStorage.addMagazine(magazine);
    }

    @Override
    public void removeMagazine(int id) throws RemoteException, SQLException
    {
        magazineStorage.removeMagazine(id);
    }
    @Override
    public ArrayList<Magazine> getMagazineList()
        throws SQLException, RemoteException
    {
        return magazineStorage.getMagazineList();
    }

    @Override public void addLibrarian(Librarian librarian) throws RemoteException, SQLException {
        librarianStorage.addLibrarian(librarian);
    }

    @Override public void removeLibrarian(String SSN) throws RemoteException, SQLException {
        librarianStorage.removeLibrarian(SSN);
    }

    @Override public ArrayList<Librarian> getLibrarianList() throws RemoteException, SQLException {
        return librarianStorage.getLibrarianList();
    }

    @Override public void addLibraryUser(LibraryUser libraryUser)
        throws RemoteException, SQLException
    {
        libraryUserStorage.addLibraryUser(libraryUser);
    }

    @Override public void removeLibraryUser(String ssn)
        throws RemoteException, SQLException
    {
        libraryUserStorage.removeLibraryUser(ssn);
    }

    @Override public ArrayList<LibraryUser> getLibraryUserList()
        throws RemoteException, SQLException
    {
        return libraryUserStorage.getLibraryUserList();
    }

}


