package tousanticovid.view;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import tousanticovid.model.Donnees;
import tousanticovid.util.BigNumbers;
import tousanticovid.Main;

public class ChiffresController {
	
	@FXML
	private Label lieu;
	@FXML
	private Label nbcas;
	@FXML
	private ImageView nbcasGraph;
	@FXML
	private Label nbdeces;
	@FXML
	private ImageView nbdecesGraph;
	@FXML
	private Label nbhosp;
	@FXML
	private ImageView nbhospGraph;
	@FXML
	private Label nbrea;
	@FXML
	private ImageView nbreaGraph;
	@FXML
	private ToggleButton toggleAffiche;
	@FXML
	private Pane SearchPane;
	@FXML
	private TextField rechercheField;
	@FXML
	private Button rechercheButton;
	@FXML
	private Button geoButton;
	
	private List<Donnees> ListDonnees;

	private Main main;
	
	public ChiffresController() {
		ListDonnees = new ArrayList<Donnees>();
		ListDonnees.add(new Donnees("France", 2281475, "tousanticovid/view/images/Chiffres/nbcas.png", 54981, "tousanticovid/view/images/Chiffres/nbmort.png", 26070, "tousanticovid/view/images/Chiffres/nbhospi.png", 3230, "tousanticovid/view/images/Chiffres/nbrea.png"));
		ListDonnees.add(new Donnees("Nouvelle Aquitaine", 2994, "tousanticovid/view/images/Chiffres/nbcasNouvAquit.png", 1428, "tousanticovid/view/images/Chiffres/nbdecesNouvAquit.png", 1350, "tousanticovid/view/images/Chiffres/nbhospiNouvAquit.png", 158, "tousanticovid/view/images/Chiffres/nbreaNouvAquit.png"));
		ListDonnees.add(new Donnees("Pyrénées Atlantiques", 1108, "tousanticovid/view/images/Chiffres/nbcasPyreeAtlant.png", 240, "tousanticovid/view/images/Chiffres/nbdecesPyreeAtlant.png", 236, "tousanticovid/view/images/Chiffres/nbhospiPyreeAtlant.png", 23, "tousanticovid/view/images/Chiffres/nbreaPyreeAtlant.png"));
		ListDonnees.add(new Donnees("Pau", 64, "tousanticovid/view/images/Chiffres/nbcasPau.png", 3, "tousanticovid/view/images/Chiffres/nbdecesPau.png", 23, "tousanticovid/view/images/Chiffres/nbhospiPau.png", 6, "tousanticovid/view/images/Chiffres/nbreaPau.png"));
	}
	/*fonction qui affiche la zone de recherche*/
	@FXML
	private void ShowSearchPane() {
		if (toggleAffiche.isSelected()) {
			SearchPane.setVisible(true);
			SearchPane.managedProperty().bind(SearchPane.visibleProperty());
		}
		else
		{
			SearchPane.setVisible(false);
			SearchPane.managedProperty().bind(SearchPane.visibleProperty());
		}
	}
	/*fonction qui ferme la zone de recherche*/
	@FXML
	private void closeSearchPane() {
		toggleAffiche.setSelected(false);
		SearchPane.setVisible(false);
		SearchPane.managedProperty().bind(SearchPane.visibleProperty());
		
	}
	/*fonction qui permet de lancer la recherche en appuyant sur la touche ENTREE*/
	@FXML
	private void RechercheNomENTER(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.ENTER) {
			RechercheNom();
		}
	}
	/*Fonction qui recheche le nom de la zone dans la liste ListDonnees et affiche les informations dans la page*/
	@FXML
	private void RechercheNom() {
		boolean trouve = false;
		
		for (int i=0; i<ListDonnees.size(); i++) {
			if (ListDonnees.get(i).getZone().equalsIgnoreCase(rechercheField.getText())) {
				trouve = true;
				lieu.setText(ListDonnees.get(i).getZone());
				
				nbcas.setText(BigNumbers.FormatConvert(ListDonnees.get(i).getCas())+" cas confirmés");
				nbcasGraph.setImage(new Image (ListDonnees.get(i).getCasPath()));
				
				nbdeces.setText(BigNumbers.FormatConvert(ListDonnees.get(i).getDeces()) +" décès");
				nbdecesGraph.setImage(new Image(ListDonnees.get(i).getDecesPath()));
				
				nbhosp.setText(BigNumbers.FormatConvert(ListDonnees.get(i).getHospi())+" patients hospitalisés");
				nbhospGraph.setImage(new Image(ListDonnees.get(i).getHospiPath()));
				
				nbrea.setText(BigNumbers.FormatConvert(ListDonnees.get(i).getRea())+" patients en réanimation");
				nbreaGraph.setImage(new Image(ListDonnees.get(i).getReaPath()));
			}
		}
		if(!trouve) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("La région, le département ou la ville cherché n'a pas été trouvé.");

			alert.showAndWait();
		}
		else {
			rechercheField.clear();
			closeSearchPane();
		}
		
	}
	/*fonction qui simule la géolocalisation*/
	@FXML
	private void geolocalise() {
		if(main.BoolAppAct) {
			lieu.setText(ListDonnees.get(3).getZone());
			
			nbcas.setText(BigNumbers.FormatConvert(ListDonnees.get(3).getCas())+" cas confirmés");
			nbcasGraph.setImage(new Image (ListDonnees.get(3).getCasPath()));
			
			nbdeces.setText(BigNumbers.FormatConvert(ListDonnees.get(3).getDeces()) +" décès");
			nbdecesGraph.setImage(new Image(ListDonnees.get(3).getDecesPath()));
			
			nbhosp.setText(BigNumbers.FormatConvert(ListDonnees.get(3).getHospi())+" patients hospitalisés");
			nbhospGraph.setImage(new Image(ListDonnees.get(3).getHospiPath()));
			
			nbrea.setText(BigNumbers.FormatConvert(ListDonnees.get(3).getRea())+" patients en réanimation");
			nbreaGraph.setImage(new Image(ListDonnees.get(3).getReaPath()));
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Veuillez activer l'application en cliquant sur le bouton en haut à droite de votre écran.");
			alert.setHeight(300);
			alert.showAndWait();
			
			geoButton.setDisable(true);
			geoButton.managedProperty().bind(geoButton.disabledProperty());
		}
	}
	
	
	@FXML
	private void initialize() {
	}
	
	public void setMain(Main main) {
		
		this.main=main;
	}
}
