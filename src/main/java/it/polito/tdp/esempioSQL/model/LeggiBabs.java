package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root"; //indirizzo per aprire il DataBase
		
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT NAME FROM station"; //Scritta su MariaDB, BRUTTO!!!!!
			
			/*
			 * Se la Query modifica (INSERT, UPDATE, etc), usare excecuteUpdate()
			 */
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
			}
			
			/*
			 * Posso aprire un nuovo statement, ma devo prima chiudere quello che non mi serve piu'
			 */
			st.close();
			
			Statement st2 = conn.createStatement();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Pattern di tipo FACTORY: creazione di una classe,
		//senza conoscere il tipo della classe (NON potevo usare new)
		//Uso un metodo fornito da un'altra classe che internamente 
		//fara' new e conoscerà il tipo di classe effettivo
		
		
	}
	public static void main(String args[]) {
		 LeggiBabs babs = new LeggiBabs();
		 babs.run();
	}
}
