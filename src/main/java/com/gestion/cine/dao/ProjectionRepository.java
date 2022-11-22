package com.gestion.cine.dao;


import com.gestion.cine.dto.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.web.bind.annotation.CrossOrigin;

//@RepositoryRestResource
//@CrossOrigin(origins = "*")
@Repository
public interface ProjectionRepository  extends JpaRepository <Projection, Long>{

}
