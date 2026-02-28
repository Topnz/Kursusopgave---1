package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private RecordList recordList;
  private PropertyChangeSupport property;

  public ModelManager()
  {
    this.recordList = new RecordList();
    this.property = new PropertyChangeSupport(this);
  }

  @Override public void addRecord(Record record)
  {
    recordList.addRecord(record);
    property.firePropertyChange("add", null, record);
  }

  @Override public void removeRecord(Record record)
  {
    recordList.removeRecord(record);
    property.firePropertyChange("remove", record, null);
  }

  @Override public Record getRecordIndex(int index)
  {
    return recordList.getRecord(index);
  }

  @Override public int getRecord(String id)
  {
    return recordList.getRecordIndex(id);
  }

  @Override public void reserveRecord(int index, Reservation reservedBy)
  {
    Record record = recordList.getRecord(index);
    record.reserveRecord(reservedBy);
    property.firePropertyChange("reserve", null, reservedBy);
  }

  @Override public void returnRecord(int index)
  {
    Record record = recordList.getRecord(index);
    record.returnRecord();
    property.firePropertyChange("return", null, true);
  }

  @Override public void borrowRecord(int index, Reservation lentBy)
  {
    Record record = recordList.getRecord(index);
    record.borrowRecord(lentBy);
    property.firePropertyChange("borrow", null, lentBy);
  }


  @Override public int getListSize()
  {
    return (recordList.getListSize());
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(propertyName, listener);
  }
}
