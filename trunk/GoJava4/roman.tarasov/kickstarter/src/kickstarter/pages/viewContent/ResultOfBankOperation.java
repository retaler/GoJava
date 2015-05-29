package kickstarter.pages.viewContent;

public class ResultOfBankOperation extends PageView {

	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n============================");
		header.append("\n| Result of Bank operation |");
		header.append("\n============================");
		header.append("\n");
		header.append("\n------------------------");
		header.append(getImodel().getModelValues().getResultOfBankOperation());
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}