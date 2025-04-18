public class WeatherData {
    private int year;
    private int month;
    private float maxTemp;
    private float minTemp;
    private float rainAmount;
    private float meanTemp;

    public WeatherData(int year, int month, float maxTemp, float minTemp, float rainAmount){
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
}
