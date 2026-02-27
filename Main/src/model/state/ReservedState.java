package model.state;

import model.Record;
import model.Reservation;

public class ReservedState extends RecordState
{
  @Override
  public void borrowRecord(Record record, Reservation lendedBy)
  {
    if(lendedBy.equals(record.getReservedBy()))
    {
      record.setReservedBy(null);
      record.setState(new LoanedState());
    }
  }
}
