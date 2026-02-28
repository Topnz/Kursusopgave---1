import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;
import viewmodel.ViewState;

public class Kursusopgave extends Application
{
  private Kursusopgave model;

  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    ViewState viewState = new ViewState();
    ViewModelFactory factory = new ViewModelFactory(model, viewState);
    ViewHandler view = new ViewHandler(factory);
    Simulation simulation = new Simulation(model);
    view.start(primaryStage);
  }

  public void stop()
  {
  }
}
