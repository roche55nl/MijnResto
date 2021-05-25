package mijnRestau.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijnRestau.models.ProductLijst;

public class ZoekenDb {
	public static int gerechten = 0;
	public static int drank = 0;
	public static int kids = 0;

	public static ArrayList<ProductLijst> zoekProduct(String gerecht) {
		ArrayList<ProductLijst> list = new ArrayList<>();
		try {
			Connection con = DbKlant.DBConnection();
			PreparedStatement ps = con.prepareStatement( "SELECT * FROM gerechtendb WHERE gerecht=? ");
			ps.setString(1, gerecht);
			ResultSet rs = ps.executeQuery();
			ProductLijst gl, dl, kl = null;

			while (rs.next()) {
				gl = new ProductLijst(rs.getString("gerecht"), rs.getBigDecimal("prijs"),
						rs.getInt("qty"), rs.getString("beschrijving"), rs.getString("imagePad"));
				gerechten++;
				list.add(gl);
			}
			con.close();
			Connection con1 = DbKlant.DBConnection();
			ps = con1.prepareStatement("SELECT * FROM drankdb WHERE gerecht=? ");
			ps.setString(1, gerecht);
			rs = ps.executeQuery();
			while (rs.next()) {
				dl = new ProductLijst(rs.getString("gerecht"), rs.getBigDecimal("prijs"),
						rs.getInt("qty"), rs.getString("beschrijving"), rs.getString("imagePad"));
				drank++;
				list.add(dl);
			}
			con1.close();
			Connection con2 = DbKlant.DBConnection();
			ps = con2.prepareStatement("SELECT * FROM kids WHERE gerecht=? ");
			ps.setString(1, gerecht);
			rs = ps.executeQuery();

			while (rs.next()) {
				kl = new ProductLijst(rs.getString("gerecht"), rs.getBigDecimal("prijs"),
						rs.getInt("qty"), rs.getString("beschrijving"), rs.getString("imagePad"));
				kids++;
				list.add(kl);
			}
			con2.close();
		} catch (SQLException ex) {
			Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}
}
