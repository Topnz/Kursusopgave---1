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
    setTitle(title);
    setArtist(artist);
    setReleaseYear(releaseYear);
    this.removing = false;
    this.reservedBy = null;
    this.lentBy = null;
    this.property = new PropertyChangeSupport(this);
    this.state = new model.state.AvailableState(this);
  }

  public void setState(RecordState state)
  {
    this.state = state;
  }

  public void setTitle(String title)
  {
    if (title == null || title.isEmpty() || title.length() > 40) throw new IllegalArgumentException("Title must be between 1 and 40 characters.");
    this.title = title;
  }

  public void setArtist(String artist)
  {
    if (artist == null || artist.isEmpty() || artist.length() > 30)
      throw new IllegalArgumentException("Artist must be between 1 and 30 characters.");
    this.artist = artist;
  }

  public void setReleaseYear(int releaseYear)
  {
   if (releaseYear < 1800 || releaseYear > 2026)
     throw new IllegalArgumentException("Release year must be exactly 4 digits.");
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

  public String getStateName()
  {
    return state.getClass().getSimpleName();
  }

  public void reserveRecord(Reservation reservedBy)
  {
    this.reservedBy = reservedBy;
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
