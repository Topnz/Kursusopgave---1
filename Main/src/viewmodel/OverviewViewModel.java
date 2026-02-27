package viewmodel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Date;
import model.Model;
import model.Record;
import model.Reservation;

public class OverviewViewModel
{
  private ObservableList<RecordViewModel> list;
  private Model model;
  private ViewState viewState;
  private StringProperty errorProperty;

  public OverviewViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;

    this.list = FXCollections.observableArrayList();
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

  public void addRecord(Record record)
  {
    model.addRecord(record);
  }

  public void deleteRecord(Record record)
  {
    model.removeRecord(record);
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
        errorProperty.set(e.getMessage());
      }
    }
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
        errorProperty.set(e.getMessage());
      }
    }
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
        errorProperty.set(e.getMessage());
      }
    }
  }

  public void clear()
  {

  }
}
