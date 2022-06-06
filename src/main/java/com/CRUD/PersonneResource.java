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

@Path("personne")
public class PersonneResource {
		@Autowired
		private PersonneRepository personneRepository;
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Personne> getListePersonnes(@QueryParam("username") String username) {
			if(username == null) {
				//List<Personne> output = new ArrayList<>();
				//personneRepository.findAll().forEach(output :: add);
				//return output;
				return (List<Personne>)personneRepository.findAll();
			}
			else {return personneRepository.findByUsername(username);}
		}
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Personne createPersonne(Personne p) {
			return personneRepository.save(p);
		}
		
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Personne getPersonne(@PathParam("id") Long id) {
			Optional<Personne> opt = personneRepository.findById(id);
			if(opt.isPresent()) {return opt.get();}
			else {return null;}
		}
		
		@DELETE
		@Path("{id}")
		public void deletePersonne(@PathParam("id") Long id) {
			personneRepository.deleteById(id);
		}
		
		
		@PATCH
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Personne patchAgePersonne(@PathParam("id") Long id, Personne P) {
			Optional<Personne> oP = personneRepository.findById(id);
			if(oP.isPresent()){
				Personne p = oP.get();
				if(P.getMotPasse() != null) {p.setMotPasse(P.getMotPasse());}
				if(P.getUsername() !=null)  {p.setUsername(P.getUsername());}
				personneRepository.save(p);
				return p;
			}
			else {return null;}
		}
		
		@PUT
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Personne putPersonne(@PathParam("id") Long id, Personne personne) {
			if(personneRepository.findById(id).isPresent()) {
				personne.setId(id);
				personneRepository.save(personne);
				return personne;
			}
			else {return null;}
		}

}
