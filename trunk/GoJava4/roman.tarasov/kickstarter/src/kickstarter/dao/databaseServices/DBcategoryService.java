package kickstarter.dao.databaseServices;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iCategoryService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.Category;

public class DBcategoryService implements iCategoryService {
	private List<Category> categories;
	private iDatabaseService dbService;
	public DBcategoryService(iDatabaseService dbService) {
		this.dbService=dbService;
		
		categories = new ArrayList<Category>();
		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		categories.add(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		categories.add(category);
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public void createCategories(iDAO sourceDAO)
			throws SQLException {
		List<Category> categories = sourceDAO.getCategoryService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  categories ");
		statement
				.executeUpdate("CREATE TABLE categories (id SERIAL not null PRIMARY KEY, category varchar(255))");
		for (Category category : categories) {
			statement.executeUpdate("INSERT INTO categories VALUES ("
					+ category.getID() + "," + "'" + category.getName() + "')");
		}
	}
}