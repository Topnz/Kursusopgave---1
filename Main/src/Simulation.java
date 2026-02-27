import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Simulation implements PropertyChangeListener
{
  public Simulation(Model model)
  {
    new Thread(() -> {
      String[] costumers = { "Peter", "Alex", "Tobias", "Kübra", "Rumeysa" };
      for (int i = 0; i < 6; i++)
      {
        try
        {

          Thread.sleep(15000);
        }
        catch (InterruptedException e)
        {
          break;
        }
      }
    }).start();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("-->"+evt.getPropertyName() + ": " + evt.getNewValue());
  }
}