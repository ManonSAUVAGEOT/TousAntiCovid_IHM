package tousanticovid.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tousanticovid.Main;
import tousanticovid.model.Restaurant;

public class RechercheRestoController {
	
	@FXML
	private ChoiceBox<String> SearchChoice;
	
	@FXML 
	private Pane nomPane;
	@FXML 
	private Pane geoPane;
	@FXML 
	private Pane QRPane;
	
	@FXML
	private AnchorPane RestoInfo;
	
	@FXML
	private TextField nomCherche;
	@FXML
	private Button ConfirmButton;
	@FXML
	private Button CancelSearchButton;
	@FXML
	private Button GeoButton;
	@FXML
	private Text nomResto;
	@FXML
	private Text adresseResto;
	@FXML
	private ImageView ImageViewResto;
	
	private Restaurant resto;
	
	private List<Restaurant> ListResto;
	
	private Main main;
	
	public RechercheRestoController() {
		ListResto = new ArrayList<Restaurant>();
		ListResto.add(0, new Restaurant("La Coquille", "25 rue de la forêt, Bidart, 64125","tousanticovid/view/images/Restaurants/coquille.jpg"));
		ListResto.add(1, new Restaurant("Paradis", "12 rue de l'ange, Pau, 64000","tousanticovid/view/images/Restaurants/paradis.jpg"));
	}
	/*Affiche la zone qui correspond au type de recherche séléctionné dans le choiceBox*/
	@FXML
	private void ShowPane(String str) {
		HideAllPane();
		if (str=="Nom") {
			nomPane.setVisible(true);
			nomPane.managedProperty().bind(nomPane.visibleProperty());
		}
		else {
			if(str=="Géolocalisation") {
				geoPane.setVisible(true);
				geoPane.managedProperty().bind(geoPane.visibleProperty());
				
				GeoButton.setDisable(!main.BoolAppAct);
				GeoButton.managedProperty().bind(GeoButton.disabledProperty());
			}
			else {
				if (str=="QRCode") {
					QRPane.setVisible(true);
					QRPane.managedProperty().bind(QRPane.visibleProperty());
				}
			}
		}
		
		ShowConfirm();
	}
	/*Cache tous les pane des zones géolocalisation, QRCode et Nom*/
	@FXML
	private void HideAllPane() {
		nomPane.setVisible(false);
		nomPane.managedProperty().bind(nomPane.visibleProperty());
		
		geoPane.setVisible(false);
		geoPane.managedProperty().bind(geoPane.visibleProperty());
		
		QRPane.setVisible(false);
		QRPane.managedProperty().bind(QRPane.visibleProperty());
		
		HideConfirm();
	}
	/*Affiche la zone de confirmation*/
	@FXML
	private void ShowConfirm() {
		RestoInfo.setVisible(true);
		RestoInfo.managedProperty().bind(RestoInfo.visibleProperty());
		
		ConfirmButton.setVisible(true);
		ConfirmButton.managedProperty().bind(ConfirmButton.visibleProperty());
		
		CancelSearchButton.setVisible(true);
		CancelSearchButton.managedProperty().bind(CancelSearchButton.visibleProperty());
	}
	/*Cache la zone de confirmation*/
	@FXML
	private void HideConfirm() {
		RestoInfo.setVisible(false);
		RestoInfo.managedProperty().bind(RestoInfo.visibleProperty());
		
		ConfirmButton.setVisible(false);
		ConfirmButton.managedProperty().bind(ConfirmButton.visibleProperty());
		
		CancelSearchButton.setVisible(false);
		CancelSearchButton.managedProperty().bind(CancelSearchButton.visibleProperty());
	}
	
	/*recherche si le nom cherché est dans la liste ListResto*/
	private void NomDansListe(String nom) {
		for (int i = 0; i < ListResto.size(); i++) {
			if(ListResto.get(i).getNom().equalsIgnoreCase(nom)) {	
				resto.setNom(ListResto.get(i).getNom());
				resto.setAdresse(ListResto.get(i).getAdresse());
				resto.setImage(ListResto.get(i).getImage().getUrl());
				}  
		    }
		}
	/*Permet de lancer la recherche en appuyant sur la touche ENTREE*/
	@FXML
	private void SearchByNameENTER(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.ENTER) {
			SearchByName();
		}
	}
	/*Recherche le restaurant par nom*/
	@FXML
	private void SearchByName() {	
		ShowConfirm(); 
				
		if(nomCherche.getText()!="") {
			initRestoTemp();
			
			NomDansListe(nomCherche.getText());
			
			
			if(resto.vide()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Le restaurant \"" + nomCherche.getText() + "\" n'a pas été trouvé.");

				alert.showAndWait();
			}
			else {
				nomResto.setText(resto.getNom());
				adresseResto.setText(resto.getAdresse());
				ImageViewResto.setImage(resto.getImage());

				ConfirmButton.setDisable(false);
				ConfirmButton.managedProperty().bind(ConfirmButton.disabledProperty());
				
				CancelSearchButton.setDisable(false);
				CancelSearchButton.managedProperty().bind(CancelSearchButton.disabledProperty());
			}
			nomCherche.clear();
		}
	}
	/*Recherche le restaurant par QRCode ou Géolocalisation*/
	@FXML
	private void SearchGeoOrQR() {
		initRestoTemp();
		ShowConfirm(); 
		int i = 0;
		resto.setNom(ListResto.get(i).getNom());
		resto.setAdresse(ListResto.get(i).getAdresse());
		resto.setImage(ListResto.get(i).getImage().getUrl());
		
		nomResto.setText(resto.getNom());
		adresseResto.setText(resto.getAdresse());
		ImageViewResto.setImage(resto.getImage());

		ConfirmButton.setDisable(false);
		ConfirmButton.managedProperty().bind(ConfirmButton.disabledProperty());
		
		CancelSearchButton.setDisable(false);
		CancelSearchButton.managedProperty().bind(CancelSearchButton.disabledProperty());
	}
	
	/*fonction qui confirme le restaurant sélectionné*/
	@FXML
	private void Confirm() {
		DateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy  à HH:mm");
		Date date = new Date();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeight(500);
		alert.setContentText("Votre présence a bien été enregistrée au restaurant \"" + resto.getNom()+"\", le "+ dateFormat.format(date));

		alert.showAndWait();
		
		initRestoTemp();
	}
	
	/*Supprime le restaurant séléctionné*/
	@FXML
	private void CancelSearch() {
		initRestoTemp();
	}
	
	/*Initialise le Restaurant tampon*/
	@FXML
	private void initRestoTemp() {
		resto = new Restaurant();
		nomResto.setText(resto.getNom());
		adresseResto.setText(resto.getAdresse());
		ImageViewResto.setImage(resto.getImage());
		
		ConfirmButton.setDisable(true);
		ConfirmButton.managedProperty().bind(ConfirmButton.disabledProperty());
		
		CancelSearchButton.setDisable(true);
		CancelSearchButton.managedProperty().bind(CancelSearchButton.disabledProperty());
	}
	
	@FXML
	private void initialize() {
		initRestoTemp();
		
		SearchChoice.setItems(FXCollections.observableArrayList("Nom","Géolocalisation","QRCode"));
		
		 ChangeListener<String> changeListener = new ChangeListener<String>() {
		@Override
        public void changed(ObservableValue<? extends String> observable, //
        		String oldValue, String newValue) {
            if (newValue != null) {
                ShowPane(newValue);
            }
        }
    };
    
    SearchChoice.getSelectionModel().selectedItemProperty().addListener(changeListener);
   
    SearchChoice.setValue("QRCode");
        
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
}
