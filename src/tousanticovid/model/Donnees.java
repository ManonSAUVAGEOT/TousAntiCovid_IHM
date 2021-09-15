package tousanticovid.model;

public class Donnees {
	private String zone;
	private int cas;
	private int deces;
	private int hospi;
	private int rea;
	
	private String casPath;
	private String decesPath;
	private String hospiPath;
	private String reaPath;
	
	
	public Donnees() {
		this.zone ="";
		this.cas = 0;
		this.deces =0;
		this.hospi = 0;
		this.rea=0;	
	}
	
	public Donnees(String zone, int cas, String casPath, int deces, String decesPath, int hospi, String hospiPath, int rea, String reaPath) {
		this.zone =zone;
		this.cas = cas;
		this.deces =deces;
		this.hospi = hospi;
		this.rea=rea;
		
		this.casPath = casPath;
		this.decesPath= decesPath;
		this.hospiPath= hospiPath;
		this.reaPath= reaPath;	
	}
	
	
	public String getZone() {
		return zone;
	}
	
	public int getCas() {
		return cas;
	}
	public String getCasPath() {
		return casPath;
	}
	
	public int getDeces() {
		return deces;
	}
	public String getDecesPath() {
		return decesPath;
	}
	
	public int getHospi() {
		return hospi;
	}
	public String getHospiPath() {
		return hospiPath;
	}
	
	public int getRea() {
		return rea;
	}
	public String getReaPath() {
		return reaPath;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public void setCas(int cas) {
		this.cas = cas;
		
	}
	public void setCasPath(String path) {
		this.casPath = path;
	}
	
	public void setDeces(int deces) {
		this.deces =deces;
		
	}
	public void setDecesPath(String path) {
		this.decesPath = path;
	}
	public void setHospi(int hospi) {
		this.hospi = hospi;
	}
	public void setHospiPath(String path) {
		this.hospiPath = path;
	}
	
	public void setRea(int rea) {
		this.rea=rea;
	}
	public void setReaPath(String path) {
		this.reaPath = path;
	}
	
}
