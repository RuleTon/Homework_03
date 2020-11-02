package Homework03_02;

import java.sql.*;


public class Database {




    public static void main(String[] args) throws SQLException {
        connectionToData();
       register();
       login();

        

    }

    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW_USER = "INSERT INTO users(login, password, name, surname) VALUES(?, ?, ?, ?);";
    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String OPEN_SESSION = "UPDATE users set session = 'online' WHERE id = ?;";
    private static Connection connection;

    private static int id;
    private static String login;
    private static String password;
    private static String name;
    private static String surname;



    public static void connectionToData() throws SQLClientInfoException {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void register() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void login() throws SQLClientInfoException{
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            setValues(resultSet);

            preparedStatement = connection.prepareStatement(OPEN_SESSION);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setValues(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                login = resultSet.getString("login");
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String getSurname() {

        return surname;
    }

    public static String getName() {


        return name;
    }

    public static String getLogin() {

        return login;
    }

    public static int getId() {

        return id;
    }
}
