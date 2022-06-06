package com.CRUD;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@Path("film")
public class FilmResource  {
	@Autowired
    private FilmReposirory BDD;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilms(@QueryParam("titre") String titre) {
        if (titre != null) {
            return BDD.findByTitre(titre);//stream().filter(f -> f.getduree() == duree).toList();
        }
        return (List<Film>) BDD.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void ajouterPersonnes(Film f) {
        BDD.save(f);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Film> getFilmById(@PathParam("id") long id) {
            return BDD.findById(id);
       
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFilmById(@PathParam("id") long id) {
         BDD.deleteById(id);
    }

    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remplacerFilmByID(@PathParam("id") long id, Film f) {
    	Film op=BDD.findById(id).get();
    	
    	if(f.getDuree()!=0) {
    		op.setDuree(f.getDuree());
    	}
    	if(new String(f.getTitre())!=null) {
    		op.setTitre(f.getTitre());
    	}
    	
    	BDD.save(op);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateAgeByID(@PathParam("id") Long id, Film f) {
      f.setId(id);
      BDD.save(f);
    }

}
