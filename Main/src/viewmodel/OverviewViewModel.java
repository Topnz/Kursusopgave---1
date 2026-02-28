package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Date;
import model.Model;
import model.Record;
import model.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OverviewViewModel implements PropertyChangeListener
{
  private ObservableList<RecordViewModel> list;
  private Model model;
  private ViewState viewState;

  public OverviewViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;

    model.addListener("add", this);
    model.addListener("remove", this);
    model.addListener("borrow", this);
    model.addListener("reserve", this);
    model.addListener("return", this);


    this.list = FXCollections.observableArrayList();

    update();
  }

  public ObservableList<RecordViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();

    for(int i = 0; i < model.getListSize() ; i++)
    {
      list.add(new RecordViewModel(model.getRecordIndex(i)));
    }
  }

  public void deleteRecord()
  {
    Record record = viewState.getSelectedRecord();
    if (record != null)
    {
      model.removeRecord(record);
    }

    update();
  }

  public void borrowRecord()
  {
    Record selectedRecord = viewState.getSelectedRecord();

    if(selectedRecord != null)
    {
      java.util.Date date = new java.util.Date();

      try
      {
        int index = model.getRecord(selectedRecord.toString());
        model.borrowRecord(index, new Reservation(viewState.getCurrentUser(),
            new Date(date.getDay() + 1, date.getMonth() + 1, date.getYear())));
      }
      catch (IllegalStateException e)
      {

      }
    }

    update();
  }

  public void returnRecord()
  {
    Record selectedRecord = viewState.getSelectedRecord();

    if(selectedRecord != null)
    {
      try
      {
        int index = model.getRecord(selectedRecord.toString());
        model.returnRecord(index);
      }
      catch (IllegalStateException e)
      {

      }
    }

    update();
  }

  public void reserveRecord()
  {
    Record selectedRecord = viewState.getSelectedRecord();

    if(selectedRecord != null)
    {
      java.util.Date date = new java.util.Date();

      try
      {
        int index = model.getRecord(selectedRecord.toString());
        model.reserveRecord(index, new Reservation(viewState.getCurrentUser(),
            new Date(date.getDay() + 1, date.getMonth() + 1, date.getYear())));
      }
      catch (IllegalStateException e)
      {

      }
    }

    update();
  }

  public void setSelectedRecord(Record record)
  {
    viewState.setSelectedRecord(record);
  }

  public void clear()
  {
    list.clear();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      update();
    });
  }
}
