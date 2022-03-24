
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Categorie;
import entities.Produit;
/*
 * version jersey 2.0
 */
class ClientRest {

	public static void main(String[] args) throws Exception 
	{
		
		/*
		 * Consulter une liste de categorie avec la methode GET
		 * 
		 * @Method GET
		*/
		
		//instancie un client jersey
		Client client = ClientBuilder.newClient( new ClientConfig());
		//creer l'url de la ressource d'acces
		WebTarget WebTargetURI = client.target("http://localhost:8080/TP_JAX_RS_Catalogue_Prod");
		//spécifier le url du webService et de la ressource
		WebTarget WebTargetURIPath = WebTargetURI.path("catalogue").path("categories");
		//preciser le format des des données à recuperer ou attendu
		Invocation.Builder invocationBuilde =  WebTargetURIPath.request(MediaType.APPLICATION_JSON);
		// la methode http pour recuperer la ressource souhaite
		Response response = invocationBuilde.get();
		//obtenir le corps de la requete et preciser le type qu'on veut recuperer
		//String corpsReqHTTP = response.readEntity(String.class);
		//System.out.println("Response: " + response.getStatus() + " - " + response.readEntity(String.class));
		
		try {
			 //déserialisation du json de la requete en objet java
			//on transforme la response en String
			String corpsHTTP = response.readEntity(String.class);
			//object jacqson pour désiariliser
			ObjectMapper mapper = new ObjectMapper();
			Categorie[] listCategories = mapper.readValue(corpsHTTP, Categorie[].class);
			
			for(Categorie c :listCategories )
			{
				System.out.println("idCategorie: "+c.getIdCategorie()+" nomCategorie :"+c.getNomCategorie()+" photo: "+c.getPhoto());
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		/*
		 * ajouter une Categorie
		 * 
		 * @Method POST
		 */
		//String jsonObjectCatalogue = "{\"idCategorie\":\"5\",\"nomCategorie\":\"PC\",\"photo\":\"ordi5\"}";
		Client client2 = ClientBuilder.newClient( new ClientConfig());
		WebTarget webTargetURI2 = client2.target("http://localhost:8080/TP_JAX_RS_Catalogue_Prod");
		WebTarget WebTargetURIPath2 = webTargetURI2.path("catalogue").path("categorie");
		Invocation.Builder invocationBuilde2 =  WebTargetURIPath2.request(MediaType.APPLICATION_JSON);
		Response response2 = invocationBuilde2.post(Entity.entity(new Categorie(4L,"PC","pc.jpg"), MediaType.APPLICATION_JSON));
		//corps de la requet retpurner en String
		System.out.println("\n\n"+response2.readEntity(String.class));
		
		/*
		 * mettre a jour un produit
		 * 
		 * @Method PUT
		 */
		Client client3 = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTargetURI3 = client3.target("http://localhost:8080/TP_JAX_RS_Catalogue_Prod");
		WebTarget WebTargetURIPath3 = webTargetURI3.path("catalogue").path("produit");
		Invocation.Builder invocationBuilde3 = WebTargetURIPath3.request(MediaType.APPLICATION_JSON);
		
		//Object to JSON in String
		Produit prod = new Produit(9L,"Jino",700,"jino.jpg",new Categorie(4L,"PC","pc.jpg"));
		
		Response response3 = invocationBuilde3.put(Entity.entity(prod, MediaType.APPLICATION_JSON));
		//corps de la requet retpurner en String
		System.out.println("\n\n"+response3.readEntity(String.class));
		
		/*
		 * Suprimer un produit
		 * 
		 * @Method DELETE
		 * 
		 * @QuerryParam
		 * 
		 */
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		Client client4 = ClientBuilder.newClient(clientConfig);
		
		WebTarget webTargetURI4 = client4.target("http://localhost:8080/TP_JAX_RS_Catalogue_Prod");
		WebTarget WebTargetURIPath4 = webTargetURI4.path("catalogue").path("produit");
		Invocation.Builder invocationBuilde4 = WebTargetURIPath4.request(MediaType.APPLICATION_JSON);
		Form form = new Form();
		form.param("idProd=","1");
		
		//Response response4 = invocationBuilde4.delete(Entity.form(form),MediaType.APPLICATION_JSON);
		
		
		//example
		
		
		 String response4 = invocationBuilde4
				 .method("DELETE", 
                         Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), 
                         String.class);
		//corps de la requet retpurner en String
			System.out.println("\n\n"+response4);
	}

}
