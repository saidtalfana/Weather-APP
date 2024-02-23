import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/db_weather"; // change name of database db_studens
    private static final String USERNAME = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, null);
    }

    // change the class Student to City
    public static List<City> getAllCities() throws SQLException {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM City";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int cityId = resultSet.getInt("cityId");
            String cityName = resultSet.getString("cityName");
            int currentTemperature = resultSet.getInt("currentTemperature");
            int currentHumidity = resultSet.getInt("currentHumidity");
            int currentWindSpeed =resultSet.getInt("currentWindSpeed");
            cities.add(new City(cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return cities;
    }

    public static void addCity(City city) throws SQLException {
        String sql = "INSERT INTO City (cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed) VALUES (?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setInt(3, city.getCurrentTemperature());
        statement.setInt(4, city.getCurrentHumidity());
        statement.setInt(5, city.getCurrentWindSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City updated successfully!");
    }

    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE City SET cityName = ?, CurrentTemperature = ?,CurrentHumidity=?,CurrentWindSpeed= ? WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.getCityName());
        statement.setInt(2, city.getCurrentTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(4, city.getCurrentWindSpeed());
        statement.setInt(5, city.getCityId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City updated successfully!");
    }

    public static void deleteCity(int id) throws SQLException {
        String sql = "DELETE FROM City WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City deleted successfully!");
    }

    //////////////////////////
    /////////////////////////
    public static List<CityHistory> getAllCitiesHistory() throws SQLException {
        List<CityHistory> citiesHistory = new ArrayList<>();
        String sql = "SELECT * FROM CityHistory";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int historicalDataId = resultSet.getInt("historicalDataId");
            int cityId = resultSet.getInt("cityId");
            String eventDate = resultSet.getString("eventDate");
            int temperature=resultSet.getInt("temperature");
            citiesHistory.add(new CityHistory(historicalDataId, cityId, eventDate,temperature ));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return citiesHistory;
    }

    public static void addCityHistory(CityHistory cityHistory) throws SQLException {
        String sql = "INSERT INTO CityHistory (historicalDataId, cityId, eventDate,temperature ) VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityHistory.getHistoricalDataId());
        statement.setInt(2, cityHistory.getCityId());
        statement.setString(3, cityHistory.getEventDate());
        statement.setInt(4, cityHistory.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City history updated successfully!");
    }

    public static void updateCityHistory(CityHistory cityHistory) throws SQLException {
        String sql = "UPDATE CityHistory SET cityId = ?, eventDate = ? ,temperature =? WHERE HistoricalDataId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityHistory.getCityId());
        statement.setString(2, cityHistory.getEventDate());
        statement.setInt(3, cityHistory.getTemperature());
        statement.setInt(4, cityHistory.getHistoricalDataId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City History updated successfully!");
    }

    public static void deleteCityHistory(int HistoricalDataId) throws SQLException {
        String sql = "DELETE FROM CityHistory  WHERE HistoricalDataId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, HistoricalDataId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City History deleted successfully!");
    }
}
