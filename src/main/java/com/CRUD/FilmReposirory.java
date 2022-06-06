package com.CRUD;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface FilmReposirory extends CrudRepository<Film,Long> {
	
	List<Film> findByDuree(int duree);
	List<Film> findByNote(int note);
	List<Film> findByTitre(String titre);
	
	/*@Query("select f from Film f where f.titre= :titre or f.duree= :duree")
	List<Film> trouverFilmParDureeOuTitre(@Param("titre")
	String titre,@Param("duree") int duree);*/
}
