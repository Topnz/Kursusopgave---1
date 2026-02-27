package model;

public interface Model
{
  void addRecord(Record record);
  void removeRecord(Record record);
  int getRecord(String id);
  void reserveRecord(int index, Reservation reservedBy);
  void returnRecord();
  void borrowRecord(int index, Reservation lentBy);
}
