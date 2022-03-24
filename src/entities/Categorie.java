package entities;

import java.io.Serializable;

public class Categorie implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCategorie;
	private String nomCategorie;
	private String photo;
;	
	public Categorie() {}
	public Categorie(Long idCategorie,String nomCategorie,String photo)
	{
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	

}
