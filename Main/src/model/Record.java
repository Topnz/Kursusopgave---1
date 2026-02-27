package model;

import model.state.RecordState;
import utility.observer.NamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Record implements NamedPropertyChangeSubject
{
  private String title;
  private String artist;
  private int releaseYear;
  private boolean removing;
  private Reservation reservedBy;
  private Reservation lentBy;
  private RecordState state;
  private PropertyChangeSupport property;

  public Record(String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    this.removing = false;
    this.reservedBy = null;
    this.lentBy = null;
    this.property = new PropertyChangeSupport(this);
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

  public void setLentBy(Reservation lentBy)
  {
    this.lentBy = lentBy;
  }

  public void setReservedBy(Reservation reservedBy)
  {
    this.reservedBy = reservedBy;
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

  public Reservation getLentBy()
  {
    return lentBy;
  }

  public Reservation getReservedBy()
  {
    return reservedBy;
  }

  public boolean isRemoving()
  {
    return removing;
  }

  public void borrowRecord(Reservation lentBy)
  {

    state.borrowRecord(this, lentBy);
  }

  public void reserveRecord(Reservation reservedBy)
  {
    state.reserveRecord(this);
  }

  public void returnRecord()
  {
    state.returnRecord(this);
  }

  public void removeRecord()
  {
    state.removeRecord(this);
  }

  public void setRemoving(boolean removingValue)
  {
    this.removing = removingValue;
  }

  public void fireRemoveEvent()
  {
    property.firePropertyChange(toString(), false, true);
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

  @Override public String toString()
  {
    return title + " " + artist + " " + releaseYear;
  }
}
