package tousanticovid.model;

import javafx.scene.image.Image;

public class Restaurant {
		
		private String Nom;
		
		private String Adresse;
		
		private Image Img;
			
		public Restaurant() {
			this.Nom = "";
			this.Adresse="";
			this.Img = new Image("tousanticovid/view/images/photo.png", 500, 250, false, false);
		}
		
		public Restaurant(String nom, String adresse, String imgPath) {
			this.Nom = nom;
			this.Adresse=adresse;
			this.Img = new Image(imgPath, 500, 250, false, false);
		}
		
		public String getNom() {
			return Nom;
		}
		
		public String getAdresse() {
			return Adresse;
		}
		public Image getImage() {
			return Img;
		}
		public void setNom(String nom) {
			Nom = nom;
		}
		public void setAdresse(String adr) {
			Adresse=adr;
		}
		public void setImage(String imgPath) {
			Img = new Image(imgPath, 500, 250, false, false);
		}
		
		public boolean vide() {
			if((this.Nom=="")&&(this.Adresse=="")) {
				return true;
			}
			else
			{
				return false;
			}
		}
}
