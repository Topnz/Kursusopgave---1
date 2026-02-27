package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class RecordList implements PropertyChangeListener
{
  private ArrayList<Record> records;

  public RecordList()
  {
    this.records = new ArrayList<>();
  }

  public int getListSize()
  {
    return records.size();
  }

  public Record getRecord(int index)
  {
    return records.get(index);
  }

  public void addRecord(Record record)
  {
    records.add(record);
  }

  public void removeRecord(Record record)
  {
    record.addListener(record.toString(), this);
    record.removeRecord();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    for (int i = 0; i < records.size(); i++)
    {
      if (records.get(i).toString().equals(evt.getPropertyName()))
      {
        records.remove(i);
        return;
      }
    }
  }
}
