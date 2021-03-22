package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectDataRepository {

    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) { this.projectDao = projectDao; }

    public LiveData<List<Project>> getProjects(){ return this.projectDao.getProjects(); }

    public void createProject(Project project) { projectDao.insertProject(project); }

    public void insertProjects(List<Project> projects) {projectDao.insertProjects(projects);}

    public void updateProject(Project project){ projectDao.updateProject(project); }

    public void deleteProject(long projectId) { projectDao.deleteProject(projectId); }
}
