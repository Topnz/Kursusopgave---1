package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import view.controllers.AddRecordViewController;
import view.controllers.OverviewViewController;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private AddRecordViewController addRecordViewController;
  private OverviewViewController overviewViewController;


  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage){
    this.primaryStage = primaryStage;
    openView("overview");
  }

  public void openView(String id){
    Region root = null;
    switch (id)
    {
      case "overview":
        root = loadOverviewView("/view/fxml/overview.fxml"); break;
      case "addrecord":
        root = loadAddRecordView("/view/fxml/addrecord.fxml"); break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadOverviewView(String fxmlFile)
  {
    Region root = null;
    if(overviewViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        overviewViewController = loader.getController();
        overviewViewController.init(this, viewModelFactory.getOverviewViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      overviewViewController.reset();
    }

    return overviewViewController.getRoot();
  }

  private Region loadAddRecordView(String fxmlFile)
  {
    Region root = null;
    if(addRecordViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addRecordViewController = loader.getController();
        addRecordViewController.init(this, viewModelFactory.getAddRecordViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addRecordViewController.reset();
    }

    return addRecordViewController.getRoot();
  }


  public void closeView(){
    primaryStage.close();
  }

  }



