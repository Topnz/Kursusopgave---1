package model.state;

import model.Record;
import model.Reservation;

public abstract class RecordState
{
  public void reserveRecord(Record record)
  {
    throw new IllegalStateException("Can't reserve in " + getClass().getSimpleName());
  }

  public void borrowRecord(Record record, Reservation lendedBy)
  {
    throw new IllegalStateException("Can't borrow in " + getClass().getSimpleName());
  }

  public void removeRecord(Record record)
  {
    record.setRemoving(true);
  }

  public void returnRecord(Record record)
  {
    throw new IllegalStateException("Can't return in " + getClass().getSimpleName());
  }
}
