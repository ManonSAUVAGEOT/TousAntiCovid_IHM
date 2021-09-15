package tousanticovid.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import tousanticovid.Main;
import tousanticovid.model.AppActive;

public class AppActiveController {
	@FXML
	private Label ifActif;
	@FXML
	private CheckBox checkActif;
	@FXML
	private VBox menu;
	@FXML
	private ToggleButton  menuButton;
	@FXML
	private ImageView menuIconBar;
	@FXML
	private Image IconClose;
	@FXML
	private Image IconBar;
	
	protected AppActive appAct;
	private String mypage;
	private Main main;
	
	public AppActiveController() {
		mypage = "view/Accueil.fxml";
		appAct = new AppActive();
		IconClose = new Image ("tousanticovid/view/images/arrow-left-solid.png", 30, 30, false, false);
		IconBar = new Image ("tousanticovid/view/images/bars-solid.png", 25, 25, false, false);
	}
	/*Actualise la page courante*/
	@FXML
	private void ActuPage() {
		main.showPage(mypage, appAct.getIsChecked());
	}
	
	/*Fonction qui gère l'activation de l'application*/
	@FXML
	private void handleCheckBox() {
		appAct.setIsChecked(checkActif.isSelected());
		if (appAct.getIsChecked()) {
			ifActif.setText("Activé");
			appAct.setIfActif(ifActif.getText());
		}
		else {
			ifActif.setText("Désactivé");
			appAct.setIfActif(ifActif.getText());
		}
		ActuPage();
	}
	/*Fonction qui affiche le menu*/
	@FXML
	private void handleMenuButton() {
		if (menuButton.isSelected()) {
			menu.setVisible(true);
			menu.managedProperty().bind(menu.visibleProperty());
			
			menuIconBar.setImage(IconClose);
		}
		else {
			menuIconBar.setImage(IconBar);
			menu.setVisible(false);
			menu.managedProperty().bind(menu.visibleProperty());
		}
	}
	
	/*fonction qui ferme le menu*/
	@FXML
	private void closeMenu() {
		menuButton.setSelected(false);
		menu.setVisible(false);
		menu.managedProperty().bind(menu.visibleProperty());
		menuIconBar.setImage(IconBar);
	}
	/*fonction qui affiche une nouvelle page*/
	@FXML
	public void showNewPage(ActionEvent event) {
		Node node = (Node) event.getSource() ;
	    String data = (String) node.getUserData();
	    mypage = data;
		main.showPage(data, appAct.getIsChecked());
		closeMenu();
	}
	
	
	@FXML
	private void initialize() {
		menu.setVisible(false);
		menu.managedProperty().bind(menu.visibleProperty());
		
	}	
	public void setMain(Main main, boolean test) {
		this.main = main;
	}
}
