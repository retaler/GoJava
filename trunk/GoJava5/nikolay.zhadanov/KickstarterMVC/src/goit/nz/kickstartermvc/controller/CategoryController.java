package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.view.CategoryView;

public class CategoryController implements DispatcherListener {

	private MainPageController parentController;
	private CategoryModel model;
	private CategoryView view;
	private int userChoice;

	public CategoryController(CategoryModel model, CategoryView view,
			MainPageController parent) {
		this.model = model;
		this.view = view;
		parentController = parent;
	}

	@Override
	public int onInput(String input) {
		int move = 0;
		try {
			userChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			showMessage("Input waits for integer numbers only - try one more time");
			return move;
		}
		if (userChoice == 0) {
			move = -1;
		} else if (userChoice > 0 && userChoice <= model.size()) {
			move = 1;
		} else {
			showMessage("Wrong option number");
		}
		return move;
	}

	@Override
	public void onTakeControl(int move) {
		if (move >= 0) {
			updateModel();
		}
		updateView();
	}
	
	public Project getChosenProject() {
		return model.getChosenProject(userChoice);
	}
	
	private void updateModel(){
		model.update(parentController.getChosenCategoryName());
	}
	
	private void updateView() {
		view.printProjects(model);
	}
	
	private void showMessage(String msg) {
		view.showMsg(msg);
	}

}