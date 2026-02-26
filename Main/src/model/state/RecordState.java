package model.state;

import model.Record;

public abstract class RecordState
{
  public void reserveRecord(model.Record record)
  {
    //Will be overridden
  }

  public void borrowRecord(model.Record record)
  {
    //Will be overridden
  }

  public void removeRecord(model.Record record)
  {
    record.setRemoving(true);
  }

  public void returnRecord(Record record)
  {
    //Will be overridden
  }
}
