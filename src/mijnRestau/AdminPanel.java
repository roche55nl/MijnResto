package mijnRestau;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mijnRestau.Database.DbKlant;
import mijnRestau.Database.DrankDB;
import mijnRestau.Database.FactuurDb;
import mijnRestau.Database.GerechtenDb;
import mijnRestau.Database.KinderMenuDb;
import mijnRestau.models.Factuur;
import mijnRestau.models.Klant;
import mijnRestau.models.ProductLijst;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
	//boolean imageChooser = false;
	String path;
	
	public AdminPanel() {
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		
	}

	private void initComponents() {
	
		jpanel1 = new JPanel();
		jpanel2 = new JPanel();
		AchtergrondPanl = new JPanel();
		updatePanel = new JPanel();
		checkVoorraadPanel = new JPanel();
		facturatiePanel = new JPanel();		
		adrespanel = new JPanel();		
		new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jlabel7 = new JLabel();
		jlabel8 = new JLabel();
		jlabel9 = new JLabel();
		jlabel10 = new JLabel();
		jlabel11 = new JLabel();		
		selectedPhoto = new JLabel();		
		updateButton = new JButton();
		checkVoorraadButton = new JButton();
		adresButton = new JButton();
		factuurButton = new JButton();
		fotoSelect = new JButton();
		voegButton = new JButton();
		updateVoorraadButton = new JButton();
		verwijder1 = new JButton();
		verwijder2 = new JButton();		
		updateGegevens = new JButton();		
		gaNaar = new JButton();		
		mGerecht = new JTextField();
		mQty = new JTextField();
		UpdateGerecht = new JTextField();
		delGerecht = new JTextField();
		mPrijs = new JTextField();		
		mFotoPath = new JTextField();
		UpdateQty = new JTextField();
		mCat = new JComboBox<>();
		VoorraadStatusCat = new JComboBox<>();
		delUpdateCat = new JComboBox<>();		
		jScrollPane1 = new JScrollPane();
		mBeschrijving = new JTextArea();		
		jScrollPane3 = new JScrollPane();
		jScrollPane4 = new JScrollPane();
		adressenTable = new JTable();
		checkVoorraadTable = new JTable();
		factuurtbl = new JTable();
		jScrollPane2 = new JScrollPane();
		selectedPhoto.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_Add_Image_100px.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	
		//updateButton (de bedoeling is om het gerechtenmenu up te daten met nieuwe producten) add action listener
		updateButton.setText("Nieuwe invoer");
		updateButton.setBackground(Color.gray);
		updateButton.setForeground(Color.white);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateButtonActionPerformed(evt);}});
		
		// gaNaar add action listener
		gaNaar.setText("Menu");
		gaNaar.setBackground(Color.gray);
		gaNaar.setForeground(Color.white);
		gaNaar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gaNaarButtonActionPerformed(evt);}});

		// checkVoorraadButton add action listener
		checkVoorraadButton.setText("Controleer voorraad");
		checkVoorraadButton.setBackground(Color.gray);
		checkVoorraadButton.setForeground(Color.white);
		checkVoorraadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				checkVoorraadButtonActionPerformed(evt);}});

		// factuurButton add action listener
		factuurButton.setText("Facturatie");
		factuurButton.setBackground(Color.gray);
		factuurButton.setForeground(Color.white);
		factuurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				factuurButtonActionPerformed(evt);}});
		
		// adresButton add action listener
		adresButton.setText("Klantengegevens");
		adresButton.setBackground(Color.gray);
		adresButton.setForeground(Color.white);
		adresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				adresButtonActionPerformed(evt);}});

		// panelMenu(nieuw ivoer, check Voorraad, facturatie,..)		
		jpanel1.setBackground(new Color(233,226,205));
		GroupLayout jpanel1Layout = new GroupLayout(jpanel1);
		jpanel1.setLayout(jpanel1Layout);
		jpanel1Layout.setHorizontalGroup(jpanel1Layout.createParallelGroup()	
						.addComponent(updateButton,200,200,200)
						.addComponent(checkVoorraadButton,200,200,200)
						.addComponent(factuurButton,200,200,200)
						.addComponent(adresButton,200,200,200)
						.addComponent(gaNaar,200,200,200));
		jpanel1Layout.setVerticalGroup(jpanel1Layout.createSequentialGroup()					
						.addComponent(factuurButton,65,65,65)							
						.addComponent(checkVoorraadButton,65,65,65)
						.addComponent(updateButton,65,65,65)
						.addComponent(adresButton,65,65,65)
						.addComponent(gaNaar,65,65,65));
		jpanel2.add(jpanel1);	
		jpanel2.setBackground(new Color(233,226,205));	
		AchtergrondPanl.setLayout(new CardLayout());

		// panel product details
	
		updatePanel.add(jLabel1);	
		updatePanel.add(jLabel2);
		updatePanel.add(jLabel3);
		updatePanel.add(jLabel4);
		updatePanel.add(jLabel5);
		updatePanel.add(jLabel6);
		updatePanel.add(mCat);
		mCat.setForeground(Color.white);
		mCat.setBackground(Color.gray);
		updatePanel.add(selectedPhoto);
		updatePanel.add(mPrijs);		
		updatePanel.add(mGerecht);
		updatePanel.add(mQty);
		updatePanel.add(mFotoPath);
		
		jLabel1.setText("Productdetails");
		jLabel1.setFont(new Font("Courier New", Font.BOLD, 18));
		jLabel2.setText("Gerecht:");
		jLabel3.setText("categorie:");	
		jLabel4.setText("Prijs:");
		jLabel5.setText("Hoeveelheid:");
		jLabel6.setText("Gerecht beschrijving:");
		mFotoPath.setText("Foto uploaden:");
		voegButton.setText("Update");		
		voegButton.setForeground(Color.white);		
		voegButton.setBackground(Color.gray);		
		jlabel7.setText("Gerecht:");
		jlabel10.setText("Gerecht:");		
		jlabel8.setText("Vooraad bijwerken:");
		jlabel9.setText("Verwijderen:");		
		jlabel11.setText("Hoeveelheid: ");
		mFotoPath.setEditable(false);
		
		// ComboBox om de categorie te bepalen om een bepaalde product up te daten 
		mCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));
		jScrollPane1.setViewportView(mBeschrijving);
		selectedPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		fotoSelect.setText("Klik hier");
		fotoSelect.setIcon(new ImageIcon(getClass().getResource("/icons/up.png")));
		fotoSelect.setBackground(Color.GRAY);
		fotoSelect.setForeground(Color.white);
		jlabel9.setForeground(Color.white);
		jlabel9.setBackground(Color.gray);
		
		updatePanel.add(fotoSelect);
		
		//fotoSelect add action listener
		fotoSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fotoSelectActionPerformed(evt);
			}
		});
	
		// voegButton add action listener
		voegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				voegButtonActionPerformed(evt);
			}
		});
		updatePanel.add(voegButton);
		AchtergrondPanl.add(updatePanel);

		// Tabel checkvoorraad aanmaken
		checkVoorraadTable.setBackground(Color.gray);
		checkVoorraadTable.setForeground(Color.white);
		checkVoorraadTable.setModel(new DefaultTableModel(new Object[][] {
		}, new String[] { "Gerecht", "Voorraad", "categorie" }));
		checkVoorraadTable.setEnabled(false);
		checkVoorraadTable.setRowHeight(20);
		jScrollPane3.setViewportView(checkVoorraadTable);
				
		// adressentabel aanmaken
		adressenTable.setColumnSelectionAllowed(true);
		adressenTable.setForeground(Color.white);
		adressenTable.setBackground(Color.gray);
		adressenTable.setModel(new DefaultTableModel(new Object[][] {
			
		}, new String[] { "ID", "naam", "voornaam", "email", "straat", "huisnummer", "postcode", "stad" }));
	
		adressenTable.setEnabled(true);
		adressenTable.setRowHeight(20);
		jScrollPane4.setViewportView(adressenTable);

		VoorraadStatusCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));
		VoorraadStatusCat.setForeground(Color.white);
		VoorraadStatusCat.setBackground(Color.gray);

		// updateVoorraadButton add action listener
		updateVoorraadButton.setText("Update Vooraad");
		updateVoorraadButton.setForeground(Color.white);
		updateVoorraadButton.setBackground(Color.gray);
		updateVoorraadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateVoorraadButtonActionPerformed(evt);
			}
		});

		// verwijder1 button (om een bepaalde gerecht uit database te verwijderen) add action listener
		verwijder1.setText("Verwijderen");
		verwijder1.setForeground(Color.white);
		verwijder1.setBackground(Color.gray);		
		verwijder1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				verwijder1ActionPerformed(evt);
			}
		});
		
		// ComboBox om de categorie te bepalen om een bepaalde product te verwijderen 
		delUpdateCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));
		delUpdateCat.setForeground(Color.white);
		delUpdateCat.setBackground(Color.gray);

		// updatePanel Grouplayout aanmaken
		updatePanel.setBackground(new Color(233,226,205));
		GroupLayout updatepanelLayout = new GroupLayout(updatePanel);
		updatePanel.setBorder(BorderFactory.createTitledBorder("Nieuw Invoer"));
		updatePanel.setLayout(updatepanelLayout);
		updatepanelLayout.setHorizontalGroup(updatepanelLayout.createSequentialGroup().addGap(140, 140, 140)
				.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel1,180,180,180)
								.addComponent(jLabel2,200,200,200)
								.addComponent(jLabel3,200,200,200)
								.addComponent(jLabel4,200,200,200)
								.addComponent(jLabel5,200,200,200)
								.addComponent(jLabel6,200,200,200)
								.addComponent(mFotoPath,200,200,200))
						.addGroup(updatepanelLayout.createParallelGroup()					
								.addComponent(mGerecht,200,200,200)
								.addComponent(mCat,200,200,200)
								.addComponent(mPrijs,200,200,200)
								.addComponent(mQty,200,200,200)
								.addComponent(mBeschrijving,200,200,200)
								.addGap(150, 150, 150)
								.addComponent(selectedPhoto,200,200,200)
								.addComponent(fotoSelect,200,200,200))
				.addGap(250, 250, 250).addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(voegButton,200,200,200)));
		updatepanelLayout.setVerticalGroup(updatepanelLayout.createSequentialGroup()
				.addGroup(updatepanelLayout.createSequentialGroup()
								.addComponent(jLabel1,30,30,30)
								.addGap(40, 40, 40)				
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel2,30,30,30)
								.addComponent(mGerecht,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel3,30,30,30)
								.addComponent(mCat,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel4,30,30,30)
								.addComponent(mPrijs,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel5,30,30,30)
								.addComponent(mQty,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel6,30,30,30)
								.addComponent(mBeschrijving,120,120,120))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(mFotoPath,35,35,35)
								.addComponent(selectedPhoto,200,200,200).addGap(30,30,30)							
								.addComponent(fotoSelect,35,35,35))
						.addComponent(voegButton,50,50,50)));

		AchtergrondPanl.add(updatePanel);

		// checkVoorraadPanel Grouplayout aanmaken	
		checkVoorraadPanel.setBackground(new Color(233,226,205));
		GroupLayout checkVoorraadPanelLayout = new GroupLayout(checkVoorraadPanel);
		checkVoorraadPanel.setLayout(checkVoorraadPanelLayout);
		checkVoorraadPanelLayout.setHorizontalGroup(checkVoorraadPanelLayout
				.createParallelGroup().addComponent(jScrollPane3,1000,1000,1000)
				.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
						.addGroup(checkVoorraadPanelLayout.createParallelGroup()
								.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
										.addComponent(jlabel9,117,117,117).addGap(25,25,25)
										.addComponent(jlabel10,50,50,50)
										.addComponent(delGerecht,165,165,165)
										.addComponent(delUpdateCat,145,145,145).addGap(25,25,25)
										.addComponent(verwijder1,171,171,171))
								.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
										.addComponent(jlabel8,117,117,117).addGap(25,25,25)
										.addComponent(jlabel7,50,50,50)
										.addComponent(UpdateGerecht,165,165,165)
										.addComponent(VoorraadStatusCat,145,145,145).addGap(25,25,25)
										.addComponent(jlabel11,50,50,80)
										.addComponent(UpdateQty,165,165,165).addGap(25,25,25)))
										.addComponent(updateVoorraadButton)));
		checkVoorraadPanelLayout.setVerticalGroup(checkVoorraadPanelLayout.createParallelGroup()
							.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
									   .addComponent(jScrollPane3,350,350,350)
						    .addGroup(checkVoorraadPanelLayout.createParallelGroup()
							.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
							.addGroup(checkVoorraadPanelLayout.createParallelGroup()
									   .addComponent(jlabel7,30,30,30)
									   .addComponent(UpdateGerecht,30,30,30)
									   .addComponent(jlabel8,30,30,30)))
								.addGroup(checkVoorraadPanelLayout.createSequentialGroup()
								.addGroup(checkVoorraadPanelLayout.createParallelGroup()
									   .addComponent(VoorraadStatusCat,30,30,30)
									   .addComponent(jlabel11,30,30,30)
									   .addComponent(UpdateQty,30,30,30)
									   .addComponent(updateVoorraadButton)))).addGap(25,25,25)
						.addGroup(checkVoorraadPanelLayout.createParallelGroup()
					.addGroup(checkVoorraadPanelLayout.createParallelGroup()
									   .addComponent(jlabel10,30,30,30)
									   .addComponent(delGerecht,30,30,30)
									   .addComponent(jlabel9,30,30,30))
								.addGroup(checkVoorraadPanelLayout.createParallelGroup()
									   .addComponent(delUpdateCat,30,30,30)
									   .addComponent(verwijder1,30,30,30)))));
		AchtergrondPanl.add(checkVoorraadPanel);

		//factuurtabel aanmaken en tonen
		factuurtbl.setForeground(Color.white);
		factuurtbl.setBackground(Color.gray);
		factuurtbl.setModel(new DefaultTableModel(new Object[][] {
		}, new String[] { "Serial", "Username", "Totale factuur in €", "Tijd & datum" }));
		jScrollPane2.setViewportView(factuurtbl);
		
		//verwijder2 button (om facturen te verwijderen) add action listener 
		verwijder2.setText("verwijderen");
		verwijder2.setForeground(Color.white);
		verwijder2.setBackground(Color.gray);
		verwijder2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				verwijder2ActionPerformed(evt);
			}
		});
		
		// updateGegevens button (om gegevens van de klante aab te passen) add action listener 
		updateGegevens.setText("Updaten");
		updateGegevens.setForeground(Color.white);
		updateGegevens.setBackground(Color.gray);
		updateGegevens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateGegevens();
			}
		});
		
		// adresPanel GroupLayout aanmaken	
		adrespanel.setBackground(new Color(233,226,205));
		GroupLayout adrespanelLayout = new GroupLayout(adrespanel);
		adrespanel.setLayout(adrespanelLayout);
		adrespanelLayout.setHorizontalGroup(adrespanelLayout.createParallelGroup()
						.addComponent(jScrollPane4,1000,1000,1000)
				.addGroup(adrespanelLayout.createSequentialGroup()
						.addComponent(updateGegevens,175,175,175)));
		adrespanelLayout.setVerticalGroup(adrespanelLayout.createParallelGroup()
				.addGroup(adrespanelLayout.createSequentialGroup()
						.addComponent(jScrollPane4,495,495,495)
						.addComponent(updateGegevens,45,45,45)));

		AchtergrondPanl.add(adrespanel);
		jpanel2.add(AchtergrondPanl);
						
		facturatiePanel.setBackground(new Color(233,226,205));
		
		// facturatiePanel GroupLayout aanmaken
		GroupLayout facturatiePanelLayout = new GroupLayout(facturatiePanel);
		facturatiePanel.setLayout(facturatiePanelLayout);
		facturatiePanelLayout.setHorizontalGroup(facturatiePanelLayout.createParallelGroup()
						.addComponent(jScrollPane2,1000,1000,1000)
				.addGroup(facturatiePanelLayout.createSequentialGroup()
						.addComponent(verwijder2,175,175,175)));
		facturatiePanelLayout.setVerticalGroup(facturatiePanelLayout.createParallelGroup()
				.addGroup(facturatiePanelLayout.createSequentialGroup()
						.addComponent(jScrollPane2,495,495,495)
						.addComponent(verwijder2,45,45,45)));
		AchtergrondPanl.add(facturatiePanel);
		jpanel2.add(AchtergrondPanl);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup()
				.addComponent(jpanel2)
				.addComponent(AchtergrondPanl)));
		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(jpanel2)
				.addComponent(AchtergrondPanl));
		pack();
	}
	
	// hiermee worden de gegevens van de klanten vanuit database opgevraagd en op het tabel weergegeven 
	private void adresButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(adrespanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) adressenTable.getModel();
		 JTableHeader header = adressenTable.getTableHeader();
		 header.setForeground(Color.GREEN);
			header.setBackground(Color.ORANGE);
			header.setFont(new Font("Lucida", Font.PLAIN, 20));
		model.setRowCount(0);
		Object[] data = new Object[8];
		ArrayList<Klant> list1 = new ArrayList<>();
		
		list1 = DbKlant.MaakTabelKlant();
		for (int i = 0; i < list1.size(); i++) {			
			data[0] = i+1;
			data[1] = list1.get(i).getNaam();
			data[2] = list1.get(i).getVoornaam();
			data[3] = list1.get(i).getEmail();
			data[4] = list1.get(i).getStraat();
			data[5] = list1.get(i).getHuisnummer();
			data[6] = list1.get(i).getPostCode();
			data[7] = list1.get(i).getStad();
			model.addRow(data);
			adressenTable.setRowHeight(20);
		}
	}
	
	//hiermee roepen we een instance van de klas Restaurant op vanuit het adminPanel
	private void gaNaarButtonActionPerformed(ActionEvent evt) {
		Restaurant rest = new Restaurant();
		rest.setVisible(true);
	}
	
	// hiermee worden de facturen van de klanten vanuit database opgevraagd en op het tabel weergegeven 
	private void factuurButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(facturatiePanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) factuurtbl.getModel();
		 JTableHeader header = factuurtbl.getTableHeader();
		 header.setForeground(Color.GREEN);
			header.setBackground(Color.ORANGE);
			header.setFont(new Font("Lucida", Font.PLAIN, 20));
		model.setRowCount(0);
		Object[] data = new Object[4];
		ArrayList<Factuur> list = new ArrayList<>();
		list = FactuurDb.facturen();
		for (int i = 0; i < list.size(); i++) {
			data[0] = i + 1;
			data[1] = list.get(i).getUname();
			data[2] = list.get(i).getBedrag();
			data[3] = list.get(i).getDate();
			model.addRow(data);
			factuurtbl.setRowHeight(20);
		}
	}
	
	// hiermee wordt de hoeveelheid van de verschillende producten vanuit database opgevraagd en op het tabel weergegeven 
	private void checkVoorraadButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(checkVoorraadPanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) checkVoorraadTable.getModel();
		 JTableHeader header = checkVoorraadTable.getTableHeader();
		 header.setForeground(Color.GREEN);
			header.setBackground(Color.ORANGE);
			header.setFont(new Font("Lucida", Font.PLAIN, 20));
		model.setRowCount(0);
		ArrayList<ProductLijst> list = GerechtenDb.checkVoorraad();
		Object data[] = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Gerechten";
			model.addRow(data);
		}

		list.clear();
		list = DrankDB.checkVoorraad();
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Drank";
			model.addRow(data);
		}
		list.clear();
		list = KinderMenuDb.checkVoorraad();
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Kids";
			model.addRow(data);
		}
	}
	
	// hiermee kan de admin toegang krijgen tot de panel om het gerechtenmenu up te daten met nieuwe producten
	private void updateButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(updatePanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
	}
	
	// door op de de knop fotoSelec te klikken wordt er een windowsvenster opengemaakt waardoor er toegang verleend wordt tot de bestanden van de computer, 
	//als er een bepaalde bestand wordt gekozen wordt enkel de pad (in de computer) daarvan opgenomen en de label mFotoPath gezet
	private void fotoSelectActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		File selectedImage = fc.getSelectedFile();
		path = selectedImage.getAbsolutePath();
		try {
			Image img = ImageIO.read(selectedImage);			
			selectedPhoto.setIcon(new ImageIcon(img.getScaledInstance(selectedPhoto.getWidth(), selectedPhoto.getHeight(), Image.SCALE_SMOOTH)));			
			mFotoPath.setText(path);
		} catch (IOException ex) {			
			Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// hiermee wordt een gerecht toegevoegd in database.
	// eerst wordt er nagegaan om welke product het gaat en aan de hand daarvan wordt de gepaste methode opgevraagd  
	private void voegButtonActionPerformed(ActionEvent evt) {
		try {
			if (mCat.getSelectedItem().equals("Drank")) {
				if (!path.equals(""))
					DrankDB.voegInDrankDb(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);}
			else if (mCat.getSelectedItem().equals("Gerechten")) {
				if (!path.equals(""))
					GerechtenDb.voegInGerechtenDB(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);
			} else if (mCat.getSelectedItem().equals("Kids")) {
				if (!path.equals(""))
					KinderMenuDb.VoegInKidsDb(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);}
			mGerecht.setText("");
			mQty.setText("");
			mPrijs.setText("");
			mBeschrijving.setText("");
			mFotoPath.setText("");
			selectedPhoto.setIcon(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			mGerecht.setText("");
			mQty.setText("");
			mPrijs.setText("");
			mBeschrijving.setText("");
			mFotoPath.setText("");
			selectedPhoto.setIcon(null);
			}
	}

	// voorraad updaten in database
	// eerst wordt er nagegaan om welke product het gaat en aan de hand daarvan wordt de gepaste methode opgevraagd 
	private void updateVoorraadButtonActionPerformed(ActionEvent evt) {
		try {
			String gerecht = UpdateGerecht.getText();
			int qty = Integer.parseInt(UpdateQty.getText());
			if (VoorraadStatusCat.getSelectedItem().equals("Gerechten")) {
				GerechtenDb.flag = true;
				GerechtenDb.updateGerechtenDB(gerecht, qty);
			}
			else if (VoorraadStatusCat.getSelectedItem().equals("Drank")) {
				DrankDB.flag = true;
				DrankDB.updateDrankDb(gerecht, qty);
			}
			else if (VoorraadStatusCat.getSelectedItem().equals("Kids")) {
				KinderMenuDb.flag = true;
				KinderMenuDb.updateKidsDB(gerecht, qty);
			}
			UpdateGerecht.setText("");
			UpdateQty.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// gerecht verwijderen uit database
	// eerst wordt er nagegaan om welke product het gaat en aan de hand daarvan wordt de gepaste methode opgevraagd 
	private void verwijder1ActionPerformed(ActionEvent evt) {
		try {
			String del = delGerecht.getText();
			if (delUpdateCat.getSelectedItem().equals("Gerechten")) {
				GerechtenDb.delete(del);
			} else if (delUpdateCat.getSelectedItem().equals("Drank")) {
				DrankDB.delete(del);
			} else if (delUpdateCat.getSelectedItem().equals("Kids")) {
				KinderMenuDb.delete(del);
			}
			delGerecht.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);}
	}

	// gegevens verwijderen uit database
	private void verwijder2ActionPerformed(ActionEvent evt) {
		FactuurDb.deletefactuurdb();
	}

	// hiermee worden de  gegevens van de klanten aangepast d.m.v. de method getSelectedRow()
	// deze method geeft de exacte geselecteerde rijnummer van de tabel en aan de de hand daarvan 
	//kunnen we de waarde van de juiste kolom vinden om die verder door te geven naar database   
	private void updateGegevens() {
		int selectedRowIndex = adressenTable.getSelectedRow();
		
		try {	
			int id = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 0).toString());
			String naam = adressenTable.getValueAt(selectedRowIndex, 1).toString();
			String voornaam = adressenTable.getValueAt(selectedRowIndex, 2).toString();
			String email = adressenTable.getValueAt(selectedRowIndex, 3).toString();
			String straat = adressenTable.getValueAt(selectedRowIndex, 4).toString();
			int huisnummer = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 5).toString());
			int postcode = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 6).toString());
			String stad = adressenTable.getValueAt(selectedRowIndex, 7).toString();

			DbKlant.updateKlant(id,naam, voornaam, email, straat, huisnummer, postcode, stad);
		} catch (Exception e) {			
			JOptionPane.showMessageDialog(null, "Er is een fout opgetrden!");			
		}
	}
	
	// Variables declaration

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jlabel7;
	private JLabel jlabel8;
	private JLabel jlabel9;
	private JLabel jlabel10;
	private JLabel jlabel11;
	private JLabel selectedPhoto;
	private JPanel jpanel2;
	private JPanel jpanel1;
	private JPanel AchtergrondPanl;
	private JPanel updatePanel;
	private JPanel facturatiePanel;
	private JPanel adrespanel;
	private JPanel checkVoorraadPanel;	
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;	
	private JScrollPane jScrollPane4;	
	private JComboBox<String> mCat;
	private JTextArea mBeschrijving;
	private JTextField mGerecht;
	private JTextField mFotoPath;
	private JTextField mPrijs;
	private JTextField mQty;
	private JTextField UpdateGerecht;
	private JTextField UpdateQty;
	private JTextField delGerecht;
	private JComboBox<String> VoorraadStatusCat;
	private JComboBox<String> delUpdateCat;
	private JButton updateButton;
	private JButton updateVoorraadButton;
	private JButton voegButton;
	private JButton adresButton;
	private JButton factuurButton;
	private JButton fotoSelect;
	private JButton verwijder1;
	private JButton verwijder2;
	private JButton updateGegevens;
	private JButton gaNaar;
	private JButton checkVoorraadButton;
	private JTable adressenTable;	
	private JTable checkVoorraadTable;	
	private JTable factuurtbl;
	
}
