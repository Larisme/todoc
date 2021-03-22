package com.cleanup.todoc.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class ProjectsViewModel extends ViewModel {

    private final ProjectDataRepository projectDataSource;
    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    public ProjectsViewModel(ProjectDataRepository projectDataSource, TaskDataRepository taskDataSource, Executor executor) {
        this.projectDataSource = projectDataSource;
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    public LiveData<List<Project>> getProjects() {
        LiveData<List<Project>> projectTempo = projectDataSource.getProjects();
        if(projectTempo.getValue() == null || projectTempo.getValue().isEmpty()){
            List<Project> newProjects = new ArrayList<>();
            newProjects.add(new Project(1L, "Projet Tartampion", 0xFFEADAD1));
            newProjects.add(new Project(2L, "Projet Lucidia", 0xFFB4CDBA));
            newProjects.add( new Project(3L, "Projet Circus", 0xFFA3CED2));
            projectDataSource.insertProjects(newProjects);
            return projectDataSource.getProjects();
        }
        return projectTempo;

    }

    public void createProject(Project project) {
        executor.execute(() -> {
            projectDataSource.createProject(project);
        });
    }

    public void deleteProject(long projectId) {
        executor.execute(() -> {
            projectDataSource.deleteProject(projectId);
        });
    }
}
