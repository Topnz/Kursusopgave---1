package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import view.ViewHandler;

import javax.swing.table.TableColumn;

public class OverviewViewController
{

  @FXML private TableColumn<OverViewViewModel, String> tableTitle;
  @FXML private TableColumn<OverViewViewModel, String> tableArtist;
  @FXML private TableColumn<OverViewViewModel, String> tableReleaseDate;
  @FXML private TableColumn<OverViewViewModel, String> tableRentedStatus;
  private Region root;

  private ViewHandler viewHandler;
  private Region root;
  private OverViewViewModel overViewViewModel;

  OverviewViewController()
  {
    //called by FXML loader
  }
  public void init(ViewHandler viewHandler, OverViewModel overViewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.overViewViewModel = overViewViewModel;
    this.root = root;

    tableTitle.setCellValueFactory(cellData -> cellData.getValue().

        getTableTitleProperty());

    tableArtist.setCellValueFactory(cellData -> cellData.getValue().

        getTableArtistProperty());

    tableReleaseDate.setCellValueFactory(cellData -> cellData.getValue().

        getTableReleaseDateProperty());

    tableRentedStatus.setCellValueFactory(cellData -> cellData.getValue().

        getTableRentedStatusProperty());

    reset();
  }


  public void reset()
  {
    OverViewViewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }


}
