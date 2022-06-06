package com.CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PersonneRepository extends CrudRepository<Personne,Long> {
	
	List<Personne> findByUsername(String username);
	
	/*@Query("update Personne p set p.motPasse = :motPasse where p.id= :id")
	@Modifying
	void updatingMotPasse(@Param("motPasse")String motPasse , @Param("id")Long id);
	*/
}
