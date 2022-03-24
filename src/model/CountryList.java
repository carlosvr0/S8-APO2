package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryList {

    private List<Country> data;

    public CountryList(){
        data = new  ArrayList<Country>();
    }


    public void loadData(String path) throws IOException { //reader
		File file = new File(path); //ruta del archivo
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		
		int counter = Integer.parseInt(input.readLine());
	
		while (counter > 0) {
			String line = input.readLine();
			String [] countryInfo = line.split("\\;");
			
            String name = countryInfo[0];
			int goldMedalH = Integer.parseInt(countryInfo[1]);
			int silverMedalH = Integer.parseInt(countryInfo[2]);
			int bronzeMedalH = Integer.parseInt(countryInfo[3]);

			int goldMedalM = Integer.parseInt(countryInfo[4]);
            int silverMedalM = Integer.parseInt(countryInfo[5]);
			int bronzeMedalM = Integer.parseInt(countryInfo[6]);

            data.add(new Country(name, goldMedalH, silverMedalH, bronzeMedalH, goldMedalM, silverMedalM, bronzeMedalM));
            counter--;
		}

		input.close();
		fr.close();
    }

    public void sortMaleMedals(){
        Collections.sort(data, new CountryComparator());
    }

    public void sortFemaleMedals(){
        Collections.sort(data);
    }

    public void sortByGoldMedals(){
    	boolean inversion = true;
        
    	for(int i = 0; i < data.size() && inversion; i++) {
    		inversion = false;
    		for(int m = 1; m < data.size()-i; m++){
            	
            	int result = data.get(m).compareByGoldMedals(data.get(m-1));
            
            	if(result > 0) { //oro
            		Country temp = data.get(m);
                    data.set(m, data.get(m-1));
                    data.set(m-1, temp);
                    inversion = true;
            	}
            	
            	if(result == 0) { //plata
            		Country temp = data.get(m);
                    data.set(m, data.get(m-1));
                    data.set(m-1, temp);
                    inversion = true;
                    result = data.get(m).compareBySilverMedals(data.get(m-1));
            	}
            	
            	if(result == 0) { //bronce
            		Country temp = data.get(m);
                    data.set(m, data.get(m-1));
                    data.set(m-1, temp);
                    inversion = true;
                    result = data.get(m).compareByBronzeMedals(data.get(m-1));
            	}
            	
            	if(result == 0) {//nombre
            		Country temp = data.get(m);
                    data.set(m, data.get(m-1));
                    data.set(m-1, temp);
                    inversion = true;
                    result = data.get(m).compareByName(data.get(m-1)); 
            	}
            }
    	}   
    }
  

    public String pirntData(){
        String info = "";

        for(int m = 0; m < data.size(); m++){
            info += data.get(m).getName() + "       " + data.get(m).getGoldMedalH() + "       " + data.get(m).getSilverMedalH() + "       " + data.get(m).getBronzeMedalH()
                    + "       " + data.get(m).getGoldMedalM() + "       " + data.get(m).getSilverMedalM() + "       " + data.get(m).getBronzeMedalM() + "\n";
        }

        info += "TAMAÑO: " + data.size();

        return info;
    }


    public List<Country> getListC() {
        return data;
    }
    public void setListC(List<Country> data) {
        this.data = data;
    }


}