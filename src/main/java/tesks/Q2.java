package tesks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2 {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/task";
        String userName = "root";
        String password = "A73635@dan";
        
        try(Connection conn = DriverManager.getConnection(url, userName, password);
                Statement stmt = conn.createStatement();
             ) {		      
                 String sql = "CREATE TABLE employee " +
                          "(empcodes INTEGER not NULL, " +
                          " empnames VARCHAR(255), " + 
                          " empages INTEGER, " + 
                          " esalaries INTEGER, "+
                          " PRIMARY KEY ( empcodes ))"; 

                stmt.execute(sql);
            String insertQuery = "INSERT INTO employee (empcodes, empnames, empages, esalaries) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
                int[] empcodes = {101, 102, 103, 104, 105};
                String[] empnames = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
                int[] empages = {25, 30, 20, 40, 25};
                double[] esalaries = {10000, 20000, 40000, 800000, 90000};
                
                for (int i = 0; i < empcodes.length; i++) {
                    ps.setInt(1, empcodes[i]);
                    ps.setString(2, empnames[i]);
                    ps.setInt(3, empages[i]);
                    ps.setDouble(4, esalaries[i]);
                    ps.execute();
                }
                
                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
	
}
