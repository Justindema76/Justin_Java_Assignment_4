package weather;

import java.util.Random;

public abstract class Weather {
  protected Random randNum = new Random();
  private int severity;
  private String weatherType;

  public Weather() {
    // Generate random weather type and print
    int weatherNum = randNum.nextInt(4) + 1; // Generate a random number between 0 and 4
    switch (weatherNum) {
      case 0:
        this.weatherType = "Sunny";
        break;
      case 1:
        this.weatherType = "Rainy";
        break;
      case 2:
        this.weatherType = "Windy";
        break;
      case 3:
        this.weatherType = "Stormy";
        break;
      default:
        this.weatherType = "Unknown"; // unknow value
        break;
    }
  }

  public Weather(String weatherType){
    this.weatherType = weatherType;
  }

  // Getters
  public String getWeatherType() {
    return this.weatherType;
  }

  public int getSeverity() {
    return this.severity;
  }

  // Setters
  public void setWeatherType(String weatherType) {
    this.weatherType = weatherType;
  }

  public void setSeverity(int severity) {
    this.severity = severity;
  }

 
}
