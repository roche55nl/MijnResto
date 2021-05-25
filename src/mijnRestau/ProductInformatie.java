package mijnRestau;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mijnRestau.Database.DrankDB;
import mijnRestau.Database.GerechtenDb;
import mijnRestau.Database.KinderMenuDb;
import mijnRestau.models.ProductLijst;

public class ProductInformatie extends JFrame {

	static String KiezCategorie = "";
	public static ArrayList<ProductLijst> cartItem = new ArrayList<ProductLijst>();

	public ProductInformatie() {
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		SpinnerModel value = new SpinnerNumberModel(1, //beginwaarde 
	                1, //minimale waarde 
	                10, //maximum value  
	                1); //stap  
		spinner = new JSpinner(value);   	        
		jPanel1 = new JPanel();    
		lblFoto = new JLabel();
		lblNaam = new JLabel();
		lblPrijs = new JLabel();
		lblVoorraad = new JLabel();
		lblBeschrijf = new JLabel();
		addToCart = new JButton();
		lblInfoNaam = new JLabel();
		lblInfoPrijs = new JLabel();
		lblInfoVoorraad = new JLabel();
		lblInfoBeschrijf = new JLabel();
		lblQty = new JLabel();
		new JTextField();
		lblNaam.setText("Gerecht:");
		lblPrijs.setText("Prijs in euro €:");
		lblVoorraad.setText("In voorraad:");
		lblBeschrijf.setText("Beschrijving:");
		addToCart.setText("Voeg toe aan bestelling");
		lblQty.setText("Aantal: 1");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		
		//addToCart add action listener
		addToCart.setBackground(Color.GRAY);
		addToCart.setForeground(Color.white);
		addToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					addToCartActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}}
		});
		
		//spinner add ChangeListener
		spinner.addChangeListener(new ChangeListener() {  
	        public void stateChanged(ChangeEvent e) {  
	         lblQty.setText("Aantal: " + ((JSpinner)e.getSource()).getValue());  
	        }  
	     });  

		// layout aanmaken voor jpanel1		
		jPanel1.setBackground(new Color(233,226,205));
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setBorder(BorderFactory.createTitledBorder(""));
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
				.addGroup(jPanel1Layout.createParallelGroup().addComponent(lblNaam)
						.addComponent(lblPrijs).addComponent(lblVoorraad).addComponent(lblBeschrijf,70,70,70)
						.addComponent(lblQty)
						.addComponent(lblFoto,180,180,180))
				.addGroup(jPanel1Layout.createParallelGroup().addComponent(lblInfoNaam)
						.addComponent(lblInfoPrijs)
						.addComponent(lblInfoVoorraad,70,70,70)
						.addComponent(lblInfoBeschrijf,250,250,250)
						.addComponent(spinner, 50, 50, 50)
						.addComponent(addToCart)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
				.addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(lblNaam)
						.addComponent(lblInfoNaam))
				.addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(lblPrijs)
						.addComponent(lblInfoPrijs))
				.addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(lblVoorraad)
						.addComponent(lblInfoVoorraad))
				.addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(lblBeschrijf,155,155,155)
						.addComponent(lblInfoBeschrijf,165,165,165))
				.addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(lblQty,45,45,45)
				.addComponent(spinner,30,30,30))
				.addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(addToCart).addComponent(lblFoto, 180, 180, 180)));
		getContentPane().add(jPanel1);
		pack();
	}
	
// product woordt aan de kar toegevoegd, eerst wordt de voorraad gecheckt indien er genoeg is in voorraad kan er pas toegevoegd worden
// als er meer hoeveelheid wordt besteld dan wordt de prijs vermenigvuldigd daarna wordt de voorraad van de juiste categorie aangepast 	
	private void addToCartActionPerformed(ActionEvent evt) throws ParseException {
		String s = lblQty.getText();
		String str = lblInfoPrijs.getText();
		int qty = Integer.parseInt(s.substring(8,s.length()));
		BigDecimal bd = new BigDecimal(qty);
		BigDecimal bd1 = new BigDecimal(str);

		if (Integer.parseInt(this.lblInfoVoorraad.getText()) < Integer.parseInt(s.substring(8,s.length()))) {
			System.out.println(s.substring(8,s.length()));
			JOptionPane.showMessageDialog(null, "Voorraad uitgeput!");
			this.dispose();
		} else {			
			ProductLijst p = new ProductLijst(this.lblInfoNaam.getText(), bd.multiply(bd1),   
					Integer.parseInt(s.substring(8,s.length())), null, null);
			cartItem.add(p);			
			JOptionPane.showMessageDialog(null, "Product toegevoegd!");			
			int minQty = Integer.parseInt(this.lblInfoVoorraad.getText())- Integer.parseInt(s.substring(8,s.length()));
			if (KiezCategorie.equals("drank"))
				DrankDB.updateDrankDb(this.lblInfoNaam.getText(), minQty);
			else if (KiezCategorie.equals("kids"))
				KinderMenuDb.updateKidsDB(this.lblInfoNaam.getText(), minQty);
			else if (KiezCategorie.equals("gerechten"))
				GerechtenDb.updateGerechtenDB(this.lblInfoNaam.getText(), minQty);
			this.dispose();			
		}
	}

	// Variables declaratie
	private JSpinner spinner;
	private JButton addToCart;
	private JPanel jPanel1;
	private JLabel lblNaam;
	public JLabel lblInfoNaam;
	private JLabel lblPrijs;
	public JLabel lblInfoPrijs;
	private JLabel lblVoorraad;
	public JLabel lblInfoVoorraad;
	private JLabel lblBeschrijf;
	public JLabel lblInfoBeschrijf;
	private JLabel lblQty;
	public JLabel lblFoto;
}
