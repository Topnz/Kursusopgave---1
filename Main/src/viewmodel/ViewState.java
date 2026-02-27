package viewmodel;

import model.Record;

public class ViewState
{
  private Record selectedRecord;
  private String currentUser;

  public ViewState()
  {
    this.selectedRecord = null;
    this.currentUser = "";
  }

  public Record getSelectedRecord()
  {
    return selectedRecord;
  }

  public void setSelectedRecord(Record selectedRecord)
  {
    this.selectedRecord = selectedRecord;
  }

  public String getCurrentUser()
  {
    return currentUser;
  }

  public void setCurrentUser(String currentUser)
  {
    this.currentUser = currentUser;
  }
}
