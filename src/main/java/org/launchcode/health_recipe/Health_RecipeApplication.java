package org.launchcode.health_recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.*;
import java.util.Arrays;


@SpringBootApplication
public class Health_RecipeApplication {

//	//  Database credentials
//	static final String USER = "recipe_user";
//	static final String PASS = "root%recipe5";
//
//	// JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/health_recipe?serverTimezone=UTC";

	public static void main(String[] args) {
		SpringApplication.run(Health_RecipeApplication.class, args);


//		Connection conn = null;
//		Statement stmt = null;
//		try{
////			 Register JDBC driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
////			// Open a connection
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//			//STEP: Execute a query
//			System.out.println("Creating statement...");
//			stmt = conn.createStatement();
//
//			String sql;
//			sql = "SELECT restrictions FROM health_recipe.dietary_restrictions_search";
//			ResultSet rs = stmt.executeQuery(sql);
//
//			//STEP: Extract data from result set
//			while(rs.next()){
//				//Retrieve by column name
//				String restrictions = rs.getString("restrictions");
//
//				//Display values
//				System.out.println("restrictions: " + restrictions);
//			}
//			//STEP: Clean-up environment
//			rs.close();
//			stmt.close();
//			conn.close();
//		}catch(SQLException se){
//			//Handle errors for JDBC
//			se.printStackTrace();
//		}catch(Exception e){
//			//Handle errors for Class.forName
//			e.printStackTrace();
//		}finally{
//			//finally block used to close resources
//			try{
//				if(stmt!=null)
//					stmt.close();
//			}catch(SQLException se2){
//			}// nothing we can do
//			try{
//				if(conn!=null)
//					conn.close();
//			}catch(SQLException se){
//				se.printStackTrace();
//			}//end finally try
//		}//end try
//		System.out.println("Goodbye!");
//	}//end main
//	//end FirstExample

	}
}





