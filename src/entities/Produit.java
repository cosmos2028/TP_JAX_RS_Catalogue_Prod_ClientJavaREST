package entities;

import java.io.Serializable;

public class Produit implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idProduit;
	private String designation;
	private double prix;
	private String photo;
	private Categorie categorie;
	
	
	public Produit() {}
	public Produit(Long idProduit, String designation, double prix, String photo, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.prix = prix;
		this.photo = photo;
		this.categorie = categorie;
		
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/*
	 * @JsonIgnore : permet de ne pas serialiser et deserialiser 
	 * l'objet categorie  lors de l'envoi er reception de 
	 * l'objet produit
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/*
	 * @JsonSetter : apres avoir utilise @JsonIgnore et si on veut 
	 * serialiser l'objet produit et sa categorie ,il faut utiliser @JsonSetter 
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	

}
