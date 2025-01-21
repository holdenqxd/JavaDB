import java.sql.*;

public class DB {

    private final String host = "localhost";
    private final String port = "5432";
    private final String db_name = "DB";
    private final String login = "postgres";
    private final String password = "";

    private Connection dbConn;

    private Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String str = "jdbc:postgresql://" + host + ":" + port + "/" + db_name;
        Class.forName("org.postgresql.Driver");
        dbConn = DriverManager.getConnection(str, login, password);
        return dbConn;
    }

    public void isConnection() throws SQLException, ClassNotFoundException {
        dbConn = getDBConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public void createTable2(String tableName, String firstColumn, String secondColumn) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(" + firstColumn + ", " + secondColumn +  ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void createTable4(String tableName, String firstColumn, String secondColumn, String thirdColumn, String fourthColumn) throws
            SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(" + firstColumn + ", " + secondColumn + ", " + thirdColumn + ", " + fourthColumn + ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void createTable5(String tableName, String firstColumn, String secondColumn, String thirdColumn, String fourthColumn, String fifthColumn) throws
            SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(" + firstColumn + ", " + secondColumn + ", " + thirdColumn + ", " + fourthColumn + ", " + fifthColumn + ");";

        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);

    }

    public void insertTable2(String tableName, String firstColumnName, String secondColumnName,
                             String firstValue, String secondValue, String firstValue2, String secondValue2) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + tableName + " " +
                "(" + firstColumnName + ", " + secondColumnName +  ") VALUES ("
                + firstValue + ", " + secondValue + "), ("
                + firstValue2 + ", " + secondValue2 + ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void insertTable4(String tableName, String firstColumnName, String secondColumnName, String thirdColumnName, String fourthColumnName,
                             String firstValue, String secondValue, String thirdValue, String fourthValue,
                             String firstValue2, String secondValue2, String thirdValue2, String fourthValue2) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + tableName +
                " (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ", " + fourthColumnName + ") VALUES ("
                + firstValue + ", " + secondValue + ","+ thirdValue + ", " + fourthValue + "), ("
                + firstValue2 + ", " + secondValue2 + ","+ thirdValue2 + ", " + fourthValue2 + ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void insertTable5(String tableName, String firstColumnName, String secondColumnName, String thirdColumnName, String fourthColumnName, String fifthColumnName,
                             String firstValue, String secondValue, String thirdValue, String fourthValue, String fifthValue,
                             String firstValue2, String secondValue2, String thirdValue2, String fourthValue2, String fifthValue2) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + tableName +
                " (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ", " + fourthColumnName + ", " + fifthColumnName + ") VALUES ("
                + firstValue + ", " + secondValue + "," + thirdValue + ", " + fourthValue + ", " + fifthValue + "), ("
                + firstValue2 + ", " + secondValue2 + "," + thirdValue2 + ", " + fourthValue2 + ", " + fifthValue2 + ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void update(String tableName, String column,  String New, String pastname) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE " + tableName + " SET " + column +
                " = " + New + " WHERE " + column + " = " + pastname + ";";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void  selectTable(String tableName) throws SQLException, ClassNotFoundException {
        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName );
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.printf("%d. %s.   ", id, name);
        }
    }

    public void del(String tableName, String name) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM " + tableName + " WHERE id = " + name;
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

}