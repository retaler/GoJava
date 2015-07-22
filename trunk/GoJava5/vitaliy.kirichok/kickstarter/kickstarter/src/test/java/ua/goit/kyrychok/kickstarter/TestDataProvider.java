package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.*;

import java.util.ArrayList;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

@Deprecated
public class TestDataProvider {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void init() {
        categories = new ArrayList<>();
        Category category;
        Project project;
        category = new Category("Category 1");
        project = new Project("1st project", 10010, convertDate("01.08.2015"), "desc", 350000,  "http://stackoverflow.com/");
        project.addFaq(new Faq("Question 1", "Answer on question 1"));
        project.addFaq(new Faq("Question 2", "Answer on question 2"));
        project.addProjectEvent(new ProjectEvent(convertDate("01.01.2015"), "Project event 1"));
        project.addProjectEvent(new ProjectEvent(convertDate("01.07.2015"), "Project event 2"));
        project.addReward(new Reward(1000, "Some reward for donate 10$"));
        project.addReward(new Reward(3000, "Some reward for donate 30$"));
        project.addReward(new Reward(4000, "Some reward for donate 40$"));
        category.addProject(project);
        project = new Project("2nd project", 10010, convertDate("01.08.2015"), "desc", 350000, "http://stackoverflow.com/");
        category.addProject(project);
        categories.add(category);
        categories.add(new Category("Category 2"));
        categories.add(new Category("Category 3"));
    }

    public List<Project> getProjects(int categoryIndex) {
        return categories.get(categoryIndex).getProjects();
    }

    public Category getCategory(int categoryIndex) {
        return categories.get(categoryIndex);
    }

    public Project getProject(int categoryIndex, int projectIndex) {
        return categories.get(categoryIndex).getProjects().get(projectIndex);
    }
}
