package tousanticovid;

import java.io.IOException;

import tousanticovid.view.AppActiveController;
import tousanticovid.view.ChiffresController;
import tousanticovid.view.LieuxTestsController;
import tousanticovid.view.RechercheRestoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    public boolean BoolAppAct;
    
    public Main() {
    	primaryStage = getPrimaryStage();
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Tous Anti-Covid");

        initRootLayout();

        showPage("view/Accueil.fxml", false);
    }
    
    /*initialisation de l'affichage via les fichiers FXML*/
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/BorderApp.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            AppActiveController controller = loader.getController();
            controller.setMain(this, false);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*Fonction de chargement des pages*/
    public void showPage(String chemin, boolean actif) {
        try {
        	BoolAppAct = actif;

        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(chemin));
            AnchorPane page = (AnchorPane) loader.load();
            
            if (chemin.contains("IdentifierResto")) {
            	
            	 RechercheRestoController Restocontroller = new RechercheRestoController();
            	 Restocontroller = loader.getController();
            	 Restocontroller.setMain(this);
            }
            else {
            	if (chemin.contains("LieuxTests")) {
            		 LieuxTestsController Testscontroller = new LieuxTestsController();
            		 Testscontroller = loader.getController();
            		 Testscontroller.setMain(this);
            	}
            	else
            	{
            		if(chemin.contains("Chiffres")) {
            			ChiffresController chiffController = new ChiffresController();
            			chiffController = loader.getController();
            			chiffController.setMain(this);
            		}
            			
            	}
            }
            
            
         rootLayout.setCenter(page);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}