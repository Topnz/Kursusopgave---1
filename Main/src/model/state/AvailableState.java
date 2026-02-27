package model.state;

import model.Record;
import model.Reservation;

public class AvailableState extends RecordState
{
  public AvailableState(Record record)
  {
    if (record.isRemoving())
    {
      record.fireRemoveEvent();
    }
  }

  @Override public void borrowRecord(Record record, Reservation lendedBy)
  {
    record.setState(new LoanedState());
  }

  @Override public void reserveRecord(Record record)
  {
    record.setState(new ReservedState());
  }

  @Override public void removeRecord(Record record)
  {
    record.fireRemoveEvent();
  }
}
