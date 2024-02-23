import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int choice, cityId;
        String name;
        int temperature,humidity,windSpeed;
        do {
            System.out.println("        ===============================           ");
            System.out.println("              Cities Management                   ");
            System.out.println("         ===============================          ");
            System.out.println("         1: Add City                              ");
            System.out.println("         2: Update City                           ");
            System.out.println("         3: Delete City                           ");
            System.out.println("         4: Display All Cities                    ");
            System.out.println("         5: Quitter                               ");
            System.out.println("         ===============================                  ");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("        ===============================                   ");
            System.out.println("              Cities history Management                   ");
            System.out.println("         ===============================                 ");
            System.out.println("         6: Add City history                             ");
            System.out.println("         7: Update City history                          ");
            System.out.println("         8: Delete City history                          ");
            System.out.println("         9: Display All Cities history                   ");
            System.out.println("         10: Quitter                                     ");
            System.out.println("         ===============================                 ");
            System.out.println("Enter votre choix: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print("city Id: ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("city Name : ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("current Temperature : ");
                    temperature = new Scanner(System.in).nextInt();
                    System.out.print("current Humidity : ");
                    humidity = new Scanner(System.in).nextInt();
                    System.out.print("wind Speed : ");
                    windSpeed = new Scanner(System.in).nextInt();

                    DatabaseManager.addCity(new City(cityId, name, temperature,humidity,windSpeed));
                    break;
                case 2:
                    System.out.print("Enter city ID to update: ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Enter new city Name: ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("Enter new current Temperature: ");
                    temperature = new Scanner(System.in).nextInt();
                    System.out.print("Enter new current Humidity : ");
                    humidity = new Scanner(System.in).nextInt();
                    System.out.print("Enter new wind Speed : ");
                    windSpeed = new Scanner(System.in).nextInt();

                    DatabaseManager.updateCity(new City(cityId, name, temperature,humidity,windSpeed));
                    break;
                case 3:
                    System.out.print("Enter city ID to delete: ");
                    cityId = new Scanner(System.in).nextInt();
                    DatabaseManager.deleteCity(cityId);
                    break;
                case 4:
                    System.out.println("All cities:");
                    for (City std : DatabaseManager.getAllCities()) {
                        System.out.println(std);
                    }
                    break;


                    //////////////////////////////

                case 6:
                    System.out.print("historical Data Id: ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("city Id : ");
                    int cityid = new Scanner(System.in).nextInt();
                    System.out.print("event Date : ");
                    String date = new Scanner(System.in).nextLine();
                    System.out.print("temperature : ");
                    int temperatureH = new Scanner(System.in).nextInt();

                    DatabaseManager.addCityHistory(new CityHistory(cityId, cityid, date,temperatureH));
                    break;
                case 7:
                    System.out.print("Enter city history ID to update: ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Enter new City ID Name: ");
                    cityid = new Scanner(System.in).nextInt();
                    System.out.print("Enter new event Date ");
                    date = new Scanner(System.in).nextLine();
                    System.out.print("Enter new temperature : ");
                    temperatureH = new Scanner(System.in).nextInt();

                    DatabaseManager.updateCityHistory(new CityHistory(cityId, cityid, date,temperatureH));
                    break;
                case 8:
                    System.out.print("Enter city history ID to delete: ");
                    cityId = new Scanner(System.in).nextInt();
                    DatabaseManager.deleteCityHistory(cityId);
                    break;
                case 9:
                    System.out.println("All CitiesHistory:");
                    for (CityHistory std1 : DatabaseManager.getAllCitiesHistory()) {
                        System.out.println(std1);
                    }
                    break;
            }
        } while (choice != 10);
    }
}