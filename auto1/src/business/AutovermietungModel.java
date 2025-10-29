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

            
                String ersteZeile = ein.readLine();


                String[] teil1 = ersteZeile.split(";");

                String zweiteZeile = ein.readLine();



                String[] vermietetArr = zweiteZeile.split(";");

               
                this.auto = new Auto(
                    teil1[0],                        
                    teil1[1],                      
                    teil1[2],                       
                    Float.parseFloat(teil1[3]),      
                    vermietetArr                     
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
			
		



