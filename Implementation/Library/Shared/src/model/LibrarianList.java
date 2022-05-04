package model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Class to implement a list of Librarian Object
 *  with the necessary methods
 * @author Alexandru Dulghier
 */
public class LibrarianList implements Serializable
{
  private ArrayList<Librarian> list;

  /**
   * Constructor with no arguments
   *initializes an empty list of Librarians
   */
  public LibrarianList(){

    list = new ArrayList<Librarian>();
  }

  /**
   * method to add a Librarian to the list
   * @param librarian
   */
  public void addLibrarian(Librarian librarian){
    list.add(librarian);
  }

  /**
   * method to remove a librarian from the list
   * @param librarian
   */
  public void removeLibrarian(Librarian librarian){
    list.remove(librarian);
  }

  /**
   * method to return the entire list of Librarians
   * @return ArrayList<Librarian>
   */
  public ArrayList<Librarian> getLibrarianList(){
    return list;
  }

  /**
   * method that removes one or multiple Librarians from the
   * list if they have the specified ssn as an attribute
   * @param ssn
   */
  public void removeLibrarianBySsn(int ssn){
    for (Librarian x: list){
      if (x.getSnn()==ssn){
        list.remove(x);
      }
    }
  }

  /**
   * Method that returns the first Librarian that has
   * the specified ssn as an attribute
   * @param ssn
   * @return Librarian
   */
  public Librarian getLibrarianBySsn(int ssn){
    for (Librarian x:list){
      if (x.getSnn()==ssn){
        return x;
      }
    }
    return null;
  }

  /**
   * Method that returns the entire List of
   * Librarian in a sting format
   * @return String
   */
  public String toStringArray(){
    String result = "";
    for (Librarian x:list){

      result += x.toString();
      }
    return result;
  }
}
