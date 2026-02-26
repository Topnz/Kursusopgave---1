package model.state;

import model.Record;

public class ReservedState extends RecordState
{
  @Override
  public void borrowRecord(Record record)
  {
    if(record.getLendedBy().equals(record.getReservedBy()))
    {
      record.setState(new LoanedState());
    }
  }
}
