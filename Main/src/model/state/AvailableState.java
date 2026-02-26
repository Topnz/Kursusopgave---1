package model.state;

import model.Record;

public class AvailableState extends RecordState
{
  @Override public void borrowRecord(model.Record record)
  {
    if(!record.isRemoving())
    {
      record.setState(new LoanedState());
    }
  }

  @Override public void reserveRecord(Record record)
  {
    if(!record.isRemoving())
    {
      record.setState(new ReservedState());
    }
  }
}
