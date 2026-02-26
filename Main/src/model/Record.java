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

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setArtist(String artist)
  {
    this.artist = artist;
  }

  public void setReleaseYear(int releaseYear)
  {
    this.releaseYear = releaseYear;
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

  public void borrowRecord(Reservation lendedBy)
  {
    if(this.reservedBy != null && this.reservedBy.equals(lendedBy))
    {
      this.lendedBy = lendedBy;
      this.reservedBy = null;
    }
    else if(this.reservedBy == null && this.lendedBy == null)
    {
      this.lendedBy = lendedBy;
    }

    state.borrowRecord(this);
  }

  public void reserveRecord(Reservation reservedBy)
  {
    if(this.reservedBy == null)
    {
      this.reservedBy = reservedBy;
    }
    state.reserveRecord(this);
  }

  public void returnRecord()
  {
    state.returnRecord(this);
    this.lendedBy = null;
  }

  public void removeRecord()
  {

    state.removeRecord(this);
  }

  public void setRemoving(boolean removingValue)
  {
    this.removing = removingValue;
  }
}
