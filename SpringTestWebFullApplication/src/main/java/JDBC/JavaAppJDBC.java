package JDBC;

import java.sql.*;

public class JavaAppJDBC {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "1";

    public static void main(String[] argv) throws SQLException {
        getDbUserTable();
    }


    private static Connection getDBConnection(){
        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
            return connection;
        } else {
            System.out.println("Failed to make connection to database");
            return null;
        }
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DBUSER("
                + "USER_ID VARCHAR(80) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void getDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT city_name FROM city";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String city_name = rs.getString("city_name");
                //int age = rs.getInt("age");
                //int kolvo_people = rs.getInt("kolvo_people");

                System.out.print("city_name: " + city_name);
                //System.out.print("; age : " + age);
                //System.out.println("; kolvo_people : " + kolvo_people);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}