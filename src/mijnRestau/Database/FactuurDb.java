package mijnRestau.Database;

import javax.swing.*;
import mijnRestau.models.Factuur;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// toevoegen
public class FactuurDb {

	// hiermee worden de waarden van een factuur opgeslagen op database
	public static void voegToeFactuurDB(String username, BigDecimal bedrag, String date) {
		try {
			Connection con = DbKlant.DBConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO factuurdb ( username , bedrag, date ) VALUES (?,?,?)");
			ps.setString(1, username);
			ps.setBigDecimal(2, bedrag);
			ps.setString(3, date);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Bedankt. Uw bestelling werd doorgegeven!");
		} catch (SQLException ex) {
			Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// hiermee worden de waarden van een factuur opgehaald uit database om die
	// verder weer te geven op een tabel
	public static ArrayList<Factuur> facturen() {
		ArrayList<Factuur> customers = new ArrayList<>();
		try {
			Connection con = DbKlant.DBConnection();
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("SELECT id, username, bedrag, date FROM factuurdb");
			Factuur pl;
			while (rs.next()) {
				pl = new Factuur(rs.getInt("id"), rs.getString("username"), rs.getBigDecimal("bedrag"),
						rs.getString("date"));
				customers.add(pl);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return customers;
	}

	// facturen verwijderen
	public static void deletefactuurdb() {
		try {
			Connection con = DbKlant.DBConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM factuurdb");
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alle entries worden verwijderd!");
		} catch (SQLException ex) {
			Logger.getLogger(GerechtenDb.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}