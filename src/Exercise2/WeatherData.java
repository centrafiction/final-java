package Exercise2;

public class WeatherData {
    // THIS IS A DECLARATION IT DECLARES THAT IT EXISTS ESSENTIALLY
    private int year;
    private int month;
    private float maxTemp;
    private float minTemp;
    private float rainAmount;
    private float meanTemp;

    public WeatherData(int year, int month, float maxTemp, float minTemp, float rainAmount){
        // THIS IS THE CONSTRUCTOR DO NOT FORGET
        this.year = year;
        this.month = month;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.rainAmount = rainAmount;
        this.meanTemp = (maxTemp + minTemp) / 2;
    }

    // Getter Methods
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public float getMeanTemp() {
        return (maxTemp + minTemp)/2;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public float getRainAmount() {
        return rainAmount;
    }
    //This converts the data from the CSV file into a spaced readable format
    public String toCSV() {
        return year + "," + month + "," + maxTemp + "," + minTemp + "," + getMeanTemp() + "," + rainAmount;
    }
}
