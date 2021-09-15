package tousanticovid.view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import tousanticovid.Main;
import tousanticovid.model.Lieux;

public class LieuxTestsController {
	
	
	@FXML
	private Label nomLabel;
	
	@FXML
	private Label adresseLabel;
	
	@FXML
	private Label typeLabel;
	
	@FXML
	private Text reglesText;
	
	@FXML
	private HBox legendeBox;
	
	@FXML
	private ScrollPane CartePane;
	
	@FXML
	private Button geoButton;
	
	@FXML 
	private AnchorPane textPane;
	
	private List<Lieux> ListLieux;
	
	
	private Main main;

	public LieuxTestsController() {
		ListLieux = new ArrayList<Lieux>();
		ListLieux.add(new Lieux("ptMermoz", "200 avenue Jean Mermoz, 64000 Pau", "Laboratoire BIOPOLE PAU", "Lieu de test: ouvert de 7h à 18h30, +33559321020", "Port du masque obligatoire, test sur rendez-vous."));
		ListLieux.add(new Lieux("ptPau", "76 Avenue du Général Leclerc, 64000 Pau", "Laboratoire médical", "Lieu de test: ouvert de 7h à 18h30, +33559847842", "Port du masque obligatoire, sans rendez-vous."));
		ListLieux.add(new Lieux("ptBiocoop", "41 Avenue Fouchet, 64000 Pau", "Bio Béarn Coop", "Magasin: ouvert de 9h à 19h30, +33559138181", "Port du masque obligatoire, 8 clients maximum."));
		ListLieux.add(new Lieux("ptSport", "25 Boulevard Recteur Jean Sarrailh, 64000 Pau", "Gymnase Clermont", "Lieu commun: +33559627108", "Masque obligatoire, sport collectif adulte interdit."));
		ListLieux.add(new Lieux("ptCentre", "Avenue Louis Sallenave, 64000 Pau", "Centre commercial Tempo", "Lieu commun: ouvert de 9h à 20h, +33559808080", "Port du masque obligatoire."));
		ListLieux.add(new Lieux("ptMagasin", "51 Avenue du Loup, 64000 Pau", "Lidl", "Magasin: ouvert de 8h30 à 20h, +33800900343", "Port du masque obligatoire."));
	}

	/*Affiche les infos du lieu dans le gridpane*/
	@FXML
	private void AfficheInfos(ActionEvent event) {
		Node node = (Node) event.getSource() ;
	    String id = node.getId();
	    
	    for (int i=0; i<ListLieux.size();i++) {
			if(ListLieux.get(i).getId().equals(id)) {
				nomLabel.setText(ListLieux.get(i).getNom());
				adresseLabel.setText(ListLieux.get(i).getAdresse());
				typeLabel.setText(ListLieux.get(i).getType());
				reglesText.setText(ListLieux.get(i).getRegles());
			}
		}
	}
	/*Affiche la carte interactive et cache le pane informatif*/
	@FXML
	private void AfficheCarte() {
		if (main.BoolAppAct) {
			CartePane.setVisible(true);
			CartePane.managedProperty().bind(CartePane.visibleProperty());
			
			legendeBox.setVisible(true);
			legendeBox.managedProperty().bind(legendeBox.visibleProperty());
			
			textPane.setVisible(false);
			textPane.managedProperty().bind(textPane.visibleProperty());
		}
		else
		{
			geoButton.setDisable(true);
			geoButton.managedProperty().bind(geoButton.disabledProperty());
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeight(300);
			alert.setContentText("Veuillez activer l'application en cliquant sur le bouton en haut à droite de votre écran.");

			alert.showAndWait();
			
			
		}
	}
	
	@FXML
	private void initialize() {
		nomLabel.setText("");
		adresseLabel.setText("");
		typeLabel.setText("");
		reglesText.setText("");
	}
 
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}
