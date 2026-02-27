package viewmodel;

import javafx.beans.property.*;
import model.Record;

public class RecordViewModel
{
  private StringProperty title;
  private StringProperty artist;
  private IntegerProperty releaseDate;
  private StringProperty rentedStatus;

  public RecordViewModel(Record record)
  {
    this.title = new SimpleStringProperty(record.getTitle());
    this.artist = new SimpleStringProperty(record.getArtist());
    this.releaseDate = new SimpleIntegerProperty(record.getReleaseYear());
    this.rentedStatus = new SimpleStringProperty(record.getStateName());
  }

  public StringProperty getTitle()
  {
    return title;
  }

  public StringProperty getArtist()
  {
    return artist;
  }

  public IntegerProperty getReleaseDate()
  {
    return releaseDate;
  }

  public StringProperty getRentedStatus()
  {
    return rentedStatus;
  }
}
