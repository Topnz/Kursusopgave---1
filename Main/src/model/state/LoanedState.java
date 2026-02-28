package model.state;

import model.Record;

public class LoanedState extends RecordState
{
  @Override
  public void reserveRecord(Record record)
  {
    if(!record.isRemoving())
    {
      record.setState(new LoanedAndReservedState());
    }
  }

  @Override
  public void returnRecord(Record record)
  {
    record.setLentBy(null);
    record.setState(new AvailableState(record));
  }
}
