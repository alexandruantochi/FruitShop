package eu.ubis.eshop.bf.integration.repo;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Connection mysqlConnection = 
				ConnectionHelperClass.getMysqlConnection();

	}

}
