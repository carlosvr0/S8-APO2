package model;

import java.util.Comparator;

//Clase comparator no anonima
public class CountryComparator implements Comparator<Country>{

    @Override
    public int compare(Country o1, Country o2) {
        int result = 0;
		result = o2.getGoldMedalH() - o1.getGoldMedalH();
		
		if (result == 0) {
			result = o2.getSilverMedalH() - o1.getSilverMedalH();
		}
		
		if (result == 0) {
			result = o2.getBronzeMedalH() - o1.getBronzeMedalH();
		}

        if(result == 0){
            result = o2.getName().compareTo(o1.getName());
        }  
		return result;

    }
    
	

}
