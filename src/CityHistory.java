public class CityHistory {
    private int historicalDataId;
    private int cityId;
    private String eventDate;
    private int temperature;

    public CityHistory(int historicalDataId, int cityId, String eventDate, int temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }

    public int getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(int historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CityHistory" +
                "historicalDataId=" + historicalDataId +
                ", cityId=" + cityId +
                ", eventDate='" + eventDate + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
