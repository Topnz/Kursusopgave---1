package view.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;
import view.ViewHandler;
import viewmodel.OverviewViewModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import viewmodel.RecordViewModel;


public class OverviewViewController
{

  @FXML private TableView<RecordViewModel> table;
  @FXML private TableColumn<RecordViewModel, String> tableTitle;
  @FXML private TableColumn<RecordViewModel, String> tableArtist;
  @FXML private TableColumn<RecordViewModel, String> tableReleaseYear;
  @FXML private TableColumn<RecordViewModel, String> tableRecordState;


  private ViewHandler viewHandler;
  private Region root;
  private OverviewViewModel overviewViewModel;

  public OverviewViewController()
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

    tableReleaseYear.setCellValueFactory(cellData -> {
      int releaseYear = cellData.getValue().getReleaseDate().get();
    return new SimpleStringProperty(releaseYear + "");
    });

    tableRecordState.setCellValueFactory(cellData -> cellData.getValue().getRentedStatus());

    table.setItems(overviewViewModel.getList());

    table.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
      if (newVal != null)
      {
        overviewViewModel.setSelectedRecord(newVal.getRecord());
      }
    });

    reset();
  }


  public void reset()
  {
    overviewViewModel.update();
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
    overviewViewModel.returnRecord();
  }






}
