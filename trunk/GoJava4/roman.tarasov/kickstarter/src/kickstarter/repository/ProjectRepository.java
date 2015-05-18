package kickstarter.repository;

import kickstarter.entities.Project;

public class ProjectRepository {
	iStorage<Project> projects;

	public ProjectRepository() {
		int categoryID = 5;
		projects = new EntityStorage<Project>();
		Project project = new Project("Create electrobike", categoryID);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.ID = 23;
		projects.add(project);

		categoryID = 4;
		project = new Project("Paint the fence of the school", categoryID);
		project.description = "raising money for paint";
		project.ID = 8;
		projects.add(project);

	}

	public int getProjectsLength() {
		return projects.length();
	}

	public Project getProject(int index) {
		return projects.getEntity(index);

	}

	public Project getProjectById(int ID) {
		int length = projects.length();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.getEntity(index);
			if (currentProject.ID == ID) {
				return currentProject;
			}
		}
		return null;
	}
}