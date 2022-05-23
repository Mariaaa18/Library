package client;

import model.LoanBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class LoanBookRmiTest
{
  private static Registry registry;
  private static LoanBookClient loanBookClient;


  @BeforeAll
  public static void setUp()
      throws NotBoundException, IOException, AlreadyBoundException
  {
    registry = LocateRegistry.createRegistry(1111);
    loanBookClient = new LoanBookClientImplementation("localhost",Registry.REGISTRY_PORT);
    registry.bind("loanBook",loanBookClient);
  }

  @Test
  public void checkGetLibraryUser() throws RemoteException
  {
    String expected = "gianni";
   Assertions.assertEquals(loanBookClient.getUser("12456789909").getFirstName(),expected);

  }

  @Test
  public void checkGetLibraryUserWrongSsn() throws RemoteException
  {
    Assertions.assertEquals(null,loanBookClient.getUser("barbapap"));
  }

  @Test
  public void checkAvailableBookList() throws SQLException, RemoteException
  {
    Assertions.assertEquals(1,loanBookClient.getAvailableBookList().size());
  }

  @Test
  public void addLoanBook() throws SQLException, RemoteException
  {
    loanBookClient.addBookLoan(new LoanBook(6,"hjk"));
  }
}
