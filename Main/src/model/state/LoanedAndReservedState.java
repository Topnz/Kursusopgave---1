package model.state;

import model.Record;

public class LoanedAndReservedState extends RecordState
{
  @Override
  public void returnRecord(Record record)
  {
    record.setState(new ReservedState());
  }
}
