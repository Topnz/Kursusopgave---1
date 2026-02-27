package model;

public class ModelManager implements Model
{
  private RecordList recordList;

  public ModelManager()
  {
    this.recordList = new RecordList();
  }

  @Override public void addRecord(Record record)
  {
    recordList.addRecord(record);
  }

  @Override public void removeRecord(Record record)
  {
    recordList.removeRecord(record);
  }

  @Override public int getRecord(String id)
  {
    return 0;
  }

  @Override public void reserveRecord(int index, Reservation reservedBy)
  {
    Record record = recordList.getRecord(index);
    record.reserveRecord(reservedBy);
  }

  @Override public void returnRecord(int index)
  {
    Record record = recordList.getRecord(index);
    record.returnRecord();
  }

  @Override public void borrowRecord(int index, Reservation lentBy)
  {
    Record record = recordList.getRecord(index);
    record.borrowRecord(lentBy);
  }
}
