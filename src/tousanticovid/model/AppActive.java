package tousanticovid.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppActive {
	private  StringProperty ifActif;
	private  BooleanProperty isChecked;
	
	public AppActive() {
		this.ifActif = new SimpleStringProperty("Désactivé");
		this.isChecked = new SimpleBooleanProperty(false);
		
	}
	public AppActive(boolean bool, String str) {
		this.ifActif = new SimpleStringProperty(str);
		this.isChecked = new SimpleBooleanProperty(bool);
	}
	
	public String getIfActif() {
		return ifActif.get();
	}
	
	public void setIfActif(String ifActif) {
		this.ifActif.set(ifActif);
	}
	
	public boolean getIsChecked() {
		return isChecked.get();
	}
	
	public void setIsChecked(boolean checked) {
		this.isChecked.set(checked);
	}
	
}
