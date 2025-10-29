package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutovermietungModel {
		private Auto auto;

		public Auto getAuto() {
			return auto;
		}

		public void setAuto(Auto auto) {
			this.auto = auto;
		}
		
		
		
		
		
		
		public void leseAusDatei(String typ) throws IOException {
            try (BufferedReader ein = new BufferedReader(new FileReader("AutosAusgabe.csv"))) {

                // Erste Zeile: Kennzeichen, Typ, Modell, Preis, (leer)
                String ersteZeile = ein.readLine();


                String[] teil1 = ersteZeile.split(";");

                // Zweite Zeile: Vermietungen
                String zweiteZeile = ein.readLine();



                String[] vermietetArr = zweiteZeile.split(";");

                // Auto-Objekt erzeugen
                this.auto = new Auto(
                    teil1[0],                        // Kennzeichen
                    teil1[1],                        // Typ
                    teil1[2],                        // Modell
                    Float.parseFloat(teil1[3]),      // Tagespreis
                    vermietetArr                     // Vermietet von-bis
                );
            }
        }
		public void schreibeAutoInCsvDatei() throws IOException {
			
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("AutosAusgabe.csv", true));
				aus.write(auto.gibAutoZurueck(';'));
				aus.close();
	   			
			
		}
			
		}
			
		



