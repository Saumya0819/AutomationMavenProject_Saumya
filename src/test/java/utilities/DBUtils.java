package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static ResultSet getData(String query) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver"); // Load the driver

        String db_url = "jdbc:postgresql://localhost:5432/DVDSHOP_PRACTICE";
        String db_user = "postgres";
        String db_password = "admin";

        Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
        return connection.createStatement().executeQuery(query); // Pass the correct query
    }

    public static List<Map<String, String>> readData(String query) throws SQLException, ClassNotFoundException {
        List<Map<String, String>> dataList = new ArrayList<>();
        ResultSet dataSet = getData(query);

        while (dataSet.next()) {
            Map<String, String> rowData = new HashMap<>();
            for (int c = 1; c <= dataSet.getMetaData().getColumnCount(); c++) {
                String columnName = dataSet.getMetaData().getColumnName(c);
                String columnValue = dataSet.getString(c);
                rowData.put(columnName, columnValue);
            }
            dataList.add(rowData);
        }
        return dataList;
    }
}