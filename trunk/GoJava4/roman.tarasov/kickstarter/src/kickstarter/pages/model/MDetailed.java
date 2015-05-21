package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MDetailed extends PageModel {
	public MDetailed(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {

		if (message.equals("p")) {
			ModelOptions o = imodel.getModelOptions();
			//o.intOption = imodel.getSavedCategory();
			imodel.nextWithOptions(PROJECTS, o);
			return;
		}
		if (message.equals("c")) {
			imodel.next(COMMENT_PAGE);
			return;
		}
		if (message.equals("i")) {
			ModelOptions o = imodel.getModelOptions();
			o.intOption = intOption;
			imodel.nextWithOptions(INVEST_PAGE, o);
			return;
		}
		if (message.equals("d")) {
			ModelOptions o = imodel.getModelOptions();
			o.intOption = intOption;
			imodel.nextWithOptions(DONATE_PAGE, o);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, DETAILED_PROJECT);
	}
}