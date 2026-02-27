package model.state;

import model.Record;

public class LoanedAndReservedState extends RecordState
{
  @Override
  public void returnRecord(Record record)
  {
    record.setLentBy(null);
    record.setState(new ReservedState());
  }
}
