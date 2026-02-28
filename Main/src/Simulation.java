import model.Model;
import model.Record;
import model.Reservation;
import model.Date;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class Simulation
{
  private Model model;
  private Random random;
  private String[] customers = { "Peter", "Alex", "Tobias", "Kübra", "Rumeysa" };

  public Simulation(Model model)
  {
    this.model = model;
    this.random = new Random();

    model.addRecord(new Record("Dark Side of the Moon", "Pink Floyd", 1973));
    model.addRecord(new Record("Thriller", "Michael Jackson", 1982));
    model.addRecord(new Record("Abbey Road", "The Beatles", 1969));
    model.addRecord(new Record("Rumours", "Fleetwood Mac", 1977));
    model.addRecord(new Record("Back in Black", "AC/DC", 1980));
    model.addRecord(new Record("Led Zeppelin IV", "Led Zeppelin", 1971));
    model.addRecord(new Record("Hotel California", "Eagles", 1976));
    model.addRecord(new Record("Born to Run", "Bruce Springsteen", 1975));
    model.addRecord(new Record("Purple Rain", "Prince", 1984));
    model.addRecord(new Record("Nevermind", "Nirvana", 1991));
    model.addRecord(new Record("The Slim Shady LP", "Eminem", 1999));
    model.addRecord(new Record("Kind of Blue", "Miles Davis", 1959));
    model.addRecord(new Record("Tapestry", "Carole King", 1971));
    model.addRecord(new Record("What's Going On", "Marvin Gaye", 1971));
    model.addRecord(new Record("Appetite for Destruction", "Guns N' Roses", 1987));
    model.addRecord(new Record("The Joshua Tree", "U2", 1987));
    model.addRecord(new Record("Innervisions", "Stevie Wonder", 1973));
    model.addRecord(new Record("Blonde on Blonde", "Bob Dylan", 1966));
    model.addRecord(new Record("London Calling", "The Clash", 1979));
    model.addRecord(new Record("OK Computer", "Radiohead", 1997));
    model.addRecord(new Record("Blue", "Joni Mitchell", 1971));
    model.addRecord(new Record("Yoshimi Battles the Pink Robots", "The Flaming Lips", 2002));
    model.addRecord(new Record("Paid in Full", "Eric B. & Rakim", 1987));
    model.addRecord(new Record("Automatic for the People", "R.E.M.", 1992));
    model.addRecord(new Record("The Wall", "Pink Floyd", 1979));

    for (String customer : customers)
    {
      startCustomerThread(customer);
    }
  }

  private void startCustomerThread(String customerName)
  {
    new Thread(() -> {
      System.out.println("[" + customerName + "] Starting session.");

      for (int i = 0; i < customers.length; i++)
      {
        try
        {
          Thread.sleep(3000 + random.nextInt(7000));

          int listSize = model.getListSize();
          if (listSize == 0)
          {
            System.out.println("[" + customerName + "] No records available.");
            continue;
          }

          int recordIndex = random.nextInt(listSize);
          performRandomAction(customerName, recordIndex);
        }
        catch (InterruptedException e)
        {
          System.out.println("[" + customerName + "] Thread interrupted.");
          break;
        }
      }

      System.out.println("[" + customerName + "] Session ended.");
    }, "Thread-" + customerName).start();
  }

  private void performRandomAction(String customerName, int recordIndex)
  {
    int action = random.nextInt(4);

    Reservation reservation = new Reservation(
        customerName,
        new Date(
            random.nextInt(28) + 1,
            random.nextInt(12) + 1,
            2026
        )
    );

    try
    {
      Record record = model.getRecordIndex(recordIndex);
      String recordName = record.toString();
      String stateBefore = record.getStateName();

      switch (action)
      {
        case 0 ->
        {
          System.out.println("[" + customerName + "] Attempting to RESERVE \"" + recordName + "\" (state: " + stateBefore + ")");
          model.reserveRecord(recordIndex, reservation);
        }
        case 1 ->
        {
          System.out.println("[" + customerName + "] Attempting to BORROW \"" + recordName + "\" (state: " + stateBefore + ")");
          model.borrowRecord(recordIndex, reservation);
        }
        case 2 ->
        {
          System.out.println("[" + customerName + "] Attempting to RETURN \"" + recordName + "\" (state: " + stateBefore + ")");
          model.returnRecord(recordIndex);
        }
        case 3 ->
        {
          System.out.println("[" + customerName + "] Attempting to REMOVE \"" + recordName + "\" (state: " + stateBefore + ")");
          model.removeRecord(record);
        }
      }

      System.out.println("[" + customerName + "] Action succeeded. New state: " + record.getStateName());
    }
    catch (IllegalStateException e)
    {
      System.out.println("[" + customerName + "] Action blocked (illegal state): " + e.getMessage());
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("[" + customerName + "] Record no longer exists (removed by another thread).");
    }
  }
}