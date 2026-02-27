package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewmodel.AddRecordViewModel;
import javafx.event.ActionEvent;

public class AddRecordViewController
{

  @FXML private TextField addRecordArtistTextField;
  @FXML private TextField addRecordTitleTextField;
  @FXML private TextField addRecordReleaseYearTextField;

  private ViewHandler viewHandler;
  private Region root;
  private AddRecordViewModel addRecordViewModel;

  public AddRecordViewController()
  {
    // Called by FXML Loader
  }
  public void init(ViewHandler viewHandler,
      AddRecordViewModel addRecordViewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.addRecordViewModel = addRecordViewModel;
    this.root = root;

    addRecordArtistTextField.textProperty().bindBidirectional(addRecordViewModel.getAddRecordArtistProperty());
    addRecordTitleTextField.textProperty().bindBidirectional(addRecordViewModel.getAddRecordTitleProperty());
    addRecordReleaseYearTextField.textProperty().bindBidirectional(addRecordViewModel.getAddRecordReleaseYearProperty());

    reset();
  }

  public void reset()
  {
    addRecordViewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML
  private void actionButtonPressed()
  {
      boolean addRecord = addRecordViewModel.addRecord();
      if (addRecord)
      {
        viewHandler.openView("Overview");
      }
  }

  @FXML
  private void backButtonPressed()
  {
    viewHandler.openView("overview");
  }
}