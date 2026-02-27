package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private OverviewViewModel overviewViewModel;
  private AddRecordViewModel addRecordViewModel;

  public ViewModelFactory(Model model, ViewState viewState)
  {
    this.overviewViewModel = new OverviewViewModel(model, viewState);
    this.addRecordViewModel = new AddRecordViewModel(model, viewState);
  }

  public OverviewViewModel getOverviewViewModel()
  {
    return overviewViewModel;
  }

  public AddRecordViewModel getAddRecordViewModel()
  {
    return addRecordViewModel;
  }
}
