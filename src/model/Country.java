package model;

public class Country implements Comparable<Country> {
    
    private String name;
    //H: hombre
    private int goldMedalH;
    private int silverMedalH;
    private int bronzeMedalH;

    //M: mujer
    private int goldMedalM;
    private int silverMedalM;
    private int bronzeMedalM;
    
    
    public Country(String name, int goldMedalH, int silverMedalH, int bronzeMedalH, int goldMedalM, int silverMedalM, int bronzeMedalM) {
        this.name = name;
        this.goldMedalH = goldMedalH;
        this.silverMedalH = silverMedalH;
        this.bronzeMedalH = bronzeMedalH;
        this.goldMedalM = goldMedalM;
        this.silverMedalM = silverMedalM;
        this.bronzeMedalM = bronzeMedalM;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSilverMedalH() {
        return silverMedalH;
    }
    public void setSilverMedalH(int silverMedalH) {
        this.silverMedalH = silverMedalH;
    }

    public int getGoldMedalH() {
        return goldMedalH;
    }
    public void setGoldMedalH(int goldMedalH) {
        this.goldMedalH = goldMedalH;
    }

    public int getBronzeMedalH() {
        return bronzeMedalH;
    }
    public void setBronzeMedalH(int bronzeMedalH) {
        this.bronzeMedalH = bronzeMedalH;
    }

    public int getGoldMedalM() {
        return goldMedalM;
    }
    public void setGoldMedalM(int goldMedalM) {
        this.goldMedalM = goldMedalM;
    }

    public int getSilverMedalM() {
        return silverMedalM;
    }
    public void setSilverMedalM(int silverMedalM) {
        this.silverMedalM = silverMedalM;
    }
    
    public int getBronzeMedalM() {
        return bronzeMedalM;
    }
    public void setBronzeMedalM(int bronzeMedalM) {
        this.bronzeMedalM = bronzeMedalM;
    }


    public int compareByGoldMedals(Country other) {
		int result = 0;
		if ((this.getGoldMedalH() + this.getGoldMedalM()) < (other.getGoldMedalH() + other.getGoldMedalM())) {
			result = -1;
		}else if ((this.getGoldMedalH() + this.getGoldMedalM()) > (other.getGoldMedalH() + other.getGoldMedalM())) {
			result = 1;
		}
		return result;
	}

    public int compareBySilverMedals(Country other) {
		int result = 0;
		if ((this.getSilverMedalH() + this.getSilverMedalM()) < (other.getSilverMedalH() + other.getSilverMedalM())) {
			result = -1;
		}else if ((this.getSilverMedalH() + this.getSilverMedalM()) > (other.getSilverMedalH() + other.getSilverMedalM())) {
			result = 1;
		}
		return result;
	}

    public int compareByBronzeMedals(Country other) {
		int result = 0;
		if ((this.getBronzeMedalH() + this.getBronzeMedalM()) < (other.getBronzeMedalH() + other.getBronzeMedalM())) {
			result = -1;
		}else if ((this.getBronzeMedalH() + this.getBronzeMedalM()) > (other.getBronzeMedalH() + other.getBronzeMedalM())) {
			result = 1;
		}
		return result;
	}
    
    public int compareByName(Country other){
        int result = 0;
        result = this.getName().compareTo(other.getName());
        return result;
    }

    public String toString(int option) {

        if(option == 1)
            return name + " " + goldMedalH + " " + silverMedalH + " " + bronzeMedalH;
        else if(option == 2)   
            return name + " " + goldMedalM + " " + silverMedalM + " " + bronzeMedalM;
        else
            return name +  " " + (goldMedalH +  goldMedalM) + " " + (silverMedalH + silverMedalM) + " " + (bronzeMedalH + bronzeMedalM);
    }

    @Override
    public int compareTo(Country o) {
        int result = 0;
        result = this.goldMedalM - o.goldMedalM;
        
        if(result == 0)
            result = this.silverMedalM - o.silverMedalM;
            
        if(result == 0)
            result = this.bronzeMedalM - o.bronzeMedalM;

        if(result == 0)
            result = this.name.compareTo(o.name);

        return result;
    
    }
}
