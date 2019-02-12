package com.epam.springbootapp.dao.repository;

import com.epam.springbootapp.dao.model.ProjectJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iProjectRepository extends JpaRepository<ProjectJPA, String> {

//    @Query("SELECT c FROM CompensationJPA c WHERE c.id=:id  AND c.status='approved'")
//    Optional<ProjectJPA> findProjectJPAByProjectId(@Param("projectId") String projectId);

//    Optional<ProjectJPA> findProjectJPAByProjectId(String projectId);


    ProjectJPA findByProjectId(String projectId);
}
