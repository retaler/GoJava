package storages;
import entities.Quote;


public class QuotesStorage {
	
	private Quote[] quotes = new Quote[10];
	int[] deleted = new int[10];
	int pointer = 0;
	
	
	
	Quote quote = new Quote("Inspiting quote #1","Unknow author");
	
	
	
	
	
	
	public void addQuote(Quote newQuote) {
		if (pointer >= quotes.length) {
			Quote[] newQuotes = new Quote[quotes.length + 10];
			System.arraycopy(quotes, 0, newQuotes, 0, quotes.length);
			quotes = newQuotes;
			
			int[] newDeleted = new int[quotes.length + 10];
			System.arraycopy(deleted, 0, newDeleted, 0, quotes.length);
			deleted = newDeleted;
			
		}
	}


}
