package model;

import java.util.Objects;

public class Reservation
{
  private String name;
  private Date time;

  public Reservation(String name, Date time)
  {
    this.name = name;
    this.time = time;
  }

  public String getName()
  {
    return name;
  }

  public Date getTime()
  {
    return time;
  }

  @Override public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;
    Reservation that = (Reservation) obj;
    return Objects.equals(name, that.name) && Objects.equals(time, that.time);
  }
}
