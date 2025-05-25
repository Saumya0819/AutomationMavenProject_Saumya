package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import utilities.DBUtils;

public class ReadDB {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		List<Map<String,String>>data = DBUtils.readData(DBQueries.Horror_Movie_List);
        for (Map<String,String>row: data) {		
		
        System.out.println(row);
        }
        System.out.println(data.get(1).get("movie_name"));
	}

}
