package tousanticovid.model;

public class Lieux {
	
		private String Id;
		
		private String Type;

		private String Nom;
		
		private String Adresse;
		
		private String Regles;
			
		public Lieux() {
			this.Id = "";
			this.Type = "";
			this.Nom = "";
			this.Adresse = "";
			this.Regles = "";
		}
		
		public Lieux(String id, String type, String nom, String adresse, String regles) {
			this.Id = id;
			this.Type = type;
			this.Nom = nom;
			this.Adresse = adresse;
			this.Regles = regles;
		}
		
		public String getId() {
			return Id;
		}
		
		public String getType() {
			return Type;
		}

		public String getNom() {
			return Nom;
		}
		
		public String getAdresse() {
			return Adresse;
		}
		public String getRegles() {
			return Regles;
		}
		
		public void setId(String id) {
			Id = id;
		}
		
		public void setType(String type) {
			Type = type;
		}
		public void setNom(String nom) {
			Nom = nom;
		}
		public void setAdresse(String adr) {
			Adresse = adr;
		}
		public void setRegles(String regles) {
			Regles = regles;
		}

}