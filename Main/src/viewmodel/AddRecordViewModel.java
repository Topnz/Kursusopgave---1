package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.ModelManager;
import model.Record;

public class AddRecordViewModel
{
  private ViewState viewState;
  private Model model;

  private StringProperty recordTitle;
  private StringProperty recordArtist;
  private IntegerProperty recordReleaseYear;

  public AddRecordViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;

    this.recordTitle = new SimpleStringProperty("");
    this.recordArtist = new SimpleStringProperty("");
    this.recordReleaseYear = new SimpleIntegerProperty(-1);
  }

  public void addRecord()
  {
    Record record = new Record(recordTitle.get(), recordArtist.get(), recordReleaseYear.get());
    model.addRecord(record);
  }

  public StringProperty getRecordArtist()
  {
    return recordArtist;
  }

  public IntegerProperty getRecordReleaseYear()
  {
    return recordReleaseYear;
  }

  public StringProperty getRecordTitle()
  {
    return recordTitle;
  }
}
