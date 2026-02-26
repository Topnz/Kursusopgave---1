package model;

import model.state.RecordState;

public class Record
{
  private String title;
  private String artist;
  private int releaseYear;
  private boolean removing;
  private Reservation reservedBy;
  private Reservation lendedBy;
  private RecordState state;

  public Record(String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    this.removing = false;
    this.reservedBy = null;
  }

  public void setState(RecordState state)
  {
    this.state = state;
  }

  public String setTitle()
  {
    return title;
  }

  public String setArtist()
  {
    return artist;
  }

  public int setReleaseYear()
  {
    return releaseYear;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public int getReleaseYear()
  {
    return releaseYear;
  }

  public Reservation getLendedBy()
  {
    return lendedBy;
  }

  public Reservation getReservedBy()
  {
    return reservedBy;
  }

  public boolean isRemoving()
  {
    return removing;
  }

  public void borrowRecord(Reservation reservedBy)
  {
    if(this.reservedBy )
    {
      this.reservedBy = reservedBy;
    }
  }

  public void reserveRecord(Reservation reservedBy)
  {
    if(this.reservedBy != null)
    {
      this.reservedBy = reservedBy;
    }
  }

  public void returnRecord()
  {

  }

  public String recordStatus()
  {
    return "";
  }

  public void removeRecord()
  {

  }

  public void setRemoving(boolean removingValue)
  {
    this.removing = removingValue;
  }
}
