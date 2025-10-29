package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Auto;
import business.AutovermietungModel;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AutovermietungControl {

	AutovermietungModel atModel;
	AutovermietungView atView;
	

	public AutovermietungControl(Stage st){
    	
    	atModel = new AutovermietungModel();
    	atView = new AutovermietungView(this, atModel, st);
    }
	
	
	
	void leseAusDateiControl(String typ){
		try {
			if("csv".equals(typ)){
			this.atModel.leseAusDatei(typ);
			atView.zeigeInformationsfensterAn("Das Auto wurde gelesen!");
		}
			else{
	   			atView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}}
			catch(IOException exc){
				atView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				atView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		
		
		
	}
	
	void schreibeAutoInCsvDatei() {
		try {
			atModel.schreibeAutoInCsvDatei();
		}	
		catch(IOException exc){
			atView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			atView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
}
