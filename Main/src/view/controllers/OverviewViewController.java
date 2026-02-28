package view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewmodel.OverviewViewModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import viewmodel.RecordViewModel;


public class OverviewViewController
{

  @FXML private TableColumn<RecordViewModel, String> tableTitle;
  @FXML private TableColumn<RecordViewModel, String> tableArtist;
  @FXML private TableColumn<RecordViewModel, String> tableReleaseDate;
  @FXML private TableColumn<RecordViewModel, String> tableRentedStatus;


  private ViewHandler viewHandler;
  private Region root;
  private OverviewViewModel overviewViewModel;

  OverviewViewController()
  {
    //called by FXML loader
  }
  public void init(ViewHandler viewHandler, OverviewViewModel overviewViewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.overviewViewModel = overviewViewModel;
    this.root = root;

    tableTitle.setCellValueFactory(cellData -> cellData.getValue().getTitle());

    tableArtist.setCellValueFactory(cellData -> cellData.getValue().getArtist());

    tableReleaseDate.setCellValueFactory(cellData -> cellData.getValue().getReleaseDate());

    tableRentedStatus.setCellValueFactory(cellData -> cellData.getValue().getRentedStatus());

    reset();
  }


  public void reset()
  {
    OverviewViewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML
  private void rentButton()
  {
    overviewViewModel.borrowRecord();
  }


  @FXML
  private void reserveButton()
  {
    overviewViewModel.reserveRecord();
  }

  @FXML
  private void addRecordButton()
  {
    viewHandler.openView("addrecord");
  }

  @FXML
  private void deleteButton()
  {
    overviewViewModel.deleteRecord();
  }

  @FXML
  private void returnButton()
  {
    viewHandler.openView("overview");
  }






}
