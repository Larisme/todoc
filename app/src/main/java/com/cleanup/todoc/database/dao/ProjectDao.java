package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();

    @Insert
    long insertProject(Project project);

    @Insert
    void insertProjects (List<Project> projects);

    @Update
    int updateProject(Project project);

    @Query("DELETE FROM projects WHERE id = :projectId")
    int deleteProject(long projectId);
}
