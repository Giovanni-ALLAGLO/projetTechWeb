package com.CRUD;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return the listCommentaires
	 */
	public ArrayList<Commentaire> getListCommentaires() {
		return listCommentaires;
	}

	/**
	 * @param listCommentaires the listCommentaires to set
	 */
	public void setListCommentaires(ArrayList<Commentaire> listCommentaires) {
		this.listCommentaires = listCommentaires;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titre;
	private int duree;
	private String description;
	private int note= -1;
	private ArrayList<Commentaire> listCommentaires =null;
	
	

	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}

	public Film() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the durée
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param durée the durée to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
