package com.CRUD;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.CRUD.Film;


@Entity
public class Personne implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
    private String motPasse;
    private ArrayList<Film> listFilms=null;
    //urlphotoprofile

    
    /**
	 * @return the listFilms
	 */
	public ArrayList<Film> getListFilms() {
		return listFilms;
	}
	/**
	 * @param listFilms the listFilms to set
	 */
	public void setListFilms(ArrayList<Film> listFilms) {
		this.listFilms = listFilms;
	}
	public Personne() {
    	super();
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the motPasse
	 */
	public String getMotPasse() {
		return motPasse;
	}
	/**
	 * @param motPasse the motPasse to set
	 */
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

}
