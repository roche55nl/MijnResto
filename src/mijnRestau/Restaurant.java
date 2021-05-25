package mijnRestau;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import mijnRestau.Database.DrankDB;
import mijnRestau.Database.FactuurDb;
import mijnRestau.Database.GerechtenDb;
import mijnRestau.Database.KinderMenuDb;
import mijnRestau.Database.ZoekenDb;
import mijnRestau.models.ProductLijst;

@SuppressWarnings("serial")
public class Restaurant extends JFrame {

	static Object[] data = new Object[4];
	public BigDecimal totaal = BigDecimal.ZERO;
	DecimalFormat df = new DecimalFormat("0.00 €");
	static boolean signInStatus = false;

	public Restaurant() {
		initComponents();
		setTitle("BestelApp");
		lbl.setIcon(new ImageIcon(getClass().getResource("/background/achtergrond-restaurant4.jpg")));
		setVisible(true);
		setResizable(true);
	}

	// initComponents
	private void initComponents() {

		AchtergrondPanel = new JPanel();
		jpanel1 = new JPanel();
		jpanel2 = new JPanel();
		hoofdPanel = new JPanel();
		zoekPanel = new JPanel();
		drankPanel = new JPanel();
		gerechtenPanel = new JPanel();
		cartPanel = new JPanel();
		kidsPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		rekeningLbl = new JLabel();
		lbl = new JLabel();
		zoekTble = new JTable();
		gerechtenTable = new JTable();
		cartItemTable = new JTable();
		drankTable = new JTable();
		kidsTable = new JTable();
		zoekBar = new JTextField();
		gerehtenButton = new JButton();
		accountButton = new JButton();
		logOutButton = new JButton();
		karButton = new JButton();
		drankenButton = new JButton();
		kidsButton = new JButton();
		bestelButton = new JButton();
		jButton_Delete_Row = new JButton();
		zoekButton = new JButton();
		jScrollPane3 = new JScrollPane();
		jScrollPane5 = new JScrollPane();
		jScrollPane2 = new JScrollPane();
		jScrollPane1 = new JScrollPane();
		jScrollPane4 = new JScrollPane();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new Font("castellar", Font.PLAIN, 35));
		jLabel1.setText("BestelApplicatie");
		jLabel1.setForeground(Color.white);
		jLabel2.setIcon(new ImageIcon(getClass().getResource("/icons/afgemeld.png")));
		
		//zoekButton add action listener
		zoekButton.setIcon(new ImageIcon(getClass().getResource("/icons/zoek1.png")));
		zoekButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		zoekButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				zoekButtonActionPerformed(evt);
			}
		});
		//layout aanmaken jpanel1 (zoekbutton naamlabel, ...)
		jpanel1.setBackground(new Color(107, 194, 245));
		GroupLayout jpanel1Layout = new GroupLayout(jpanel1);
		jpanel1.setLayout(jpanel1Layout);
		jpanel1Layout.setHorizontalGroup(jpanel1Layout.createParallelGroup()
				.addGroup(jpanel1Layout.createSequentialGroup().addComponent(jLabel2, 51, 51, 51)
						.addComponent(jLabel5, 300, 300, 300).addGap(300).addComponent(jLabel1, 400, 400, 400)
						.addComponent(zoekBar, 213, 213, 213).addComponent(zoekButton, 38, 38, 38)));
		jpanel1Layout.setVerticalGroup(jpanel1Layout.createParallelGroup().addComponent(jLabel2, 50, 50, 50)
				.addComponent(jLabel1, 35, 35, 35).addComponent(jLabel5, 30, 30, 30).addComponent(zoekBar, 33, 33, 33)
				.addComponent(zoekButton, 34, 34, 34));
		AchtergrondPanel.add(jpanel1);
		gerehtenButton.setText("Gerechten");
		gerehtenButton.setBackground(Color.gray);
		gerehtenButton.setForeground(Color.WHITE);
		gerehtenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gerehtenButtonActionPerformed(evt);
			}
		});

		// AccountButton actionperformed
		accountButton.setIcon(new ImageIcon(getClass().getResource("/icons/connect.png")));
		accountButton.setBackground(Color.LIGHT_GRAY);
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				accountButtonActionPerformed(evt);
			}
		});

		// logoutButton actionperformed
		logOutButton.setText("Afmelden");
		logOutButton.setForeground(Color.white);
		logOutButton.setBackground(Color.GRAY);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				logOutButtonActionPerformed(evt);
			}
		});

		// karButtonActionPerformed
		karButton.setText("  Cart");
		karButton.setBackground(Color.GRAY);
		karButton.setForeground(Color.white);
		karButton.setIcon(new ImageIcon(getClass().getResource("/icons/cart.png")));
		karButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				karButtonActionPerformed(evt);
			}
		});

		// drankenButtonActionPerformed
		drankenButton.setText("Dranken");
		drankenButton.setBackground(Color.GRAY);
		drankenButton.setForeground(Color.white);
		drankenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				drankenButtonActionPerformed(evt);
			}
		});

		// kidsButtonActionPerformed
		kidsButton.setText("Kinderen");
		kidsButton.setBackground(Color.GRAY);
		kidsButton.setForeground(Color.white);
		kidsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				kidsButtonActionPerformed(evt);
			}
		});

		// jpanel 2 layout de buttons om een gerecht, drank of kindermenu te tonen +
		// inlog, uitlog buttons en cartbutton
		GroupLayout jpanel2Layout = new GroupLayout(jpanel2);
		jpanel2.setBackground(new Color(107, 194, 245));
		jpanel2.setLayout(jpanel2Layout);
		jpanel2Layout.setHorizontalGroup(jpanel2Layout.createParallelGroup().addComponent(gerehtenButton, 100, 100, 100)
				.addComponent(drankenButton, 100, 100, 100).addComponent(kidsButton, 100, 100, 100)
				.addComponent(karButton, 100, 100, 100).addComponent(logOutButton, 100, 100, 100)
				.addComponent(accountButton, 100, 100, 100));
		jpanel2Layout.setVerticalGroup(jpanel2Layout.createSequentialGroup().addComponent(accountButton, 50, 50, 50)
				.addGap(50, 50, 50).addComponent(logOutButton, 50, 50, 50).addGap(50, 50, 50)
				.addComponent(gerehtenButton, 50, 50, 50).addComponent(drankenButton, 50, 50, 50)
				.addComponent(kidsButton, 50, 50, 50).addGap(245, 245, 245).addComponent(karButton, 50, 50, 50));
		AchtergrondPanel.add(jpanel2);
		AchtergrondPanel.setBackground(new Color(233, 226, 205));
		hoofdPanel.setLayout(new CardLayout());
		hoofdPanel.add(lbl);

		// zoekTable aanmaken
		zoekTble.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Gerecht", "Prijs in €", "Voorraad", "Beschrijving", "Foto" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { String.class, Double.class, Integer.class, String.class, Icon.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		zoekTble.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				zoekTbleMouseClicked(evt);
			}
		});
		jScrollPane5.setViewportView(zoekTble);

		// layout aanmeken voor zoekPanel
		GroupLayout zoekPanelLayout = new GroupLayout(zoekPanel);
		zoekPanel.setBorder(BorderFactory.createTitledBorder("zoekPanel"));
		zoekPanel.setLayout(zoekPanelLayout);
		zoekPanelLayout
				.setHorizontalGroup(zoekPanelLayout.createParallelGroup().addComponent(jScrollPane5, 1290, 1290, 1290));
		zoekPanelLayout
				.setVerticalGroup(zoekPanelLayout.createParallelGroup().addComponent(jScrollPane5, 590, 590, 590));
		hoofdPanel.add(zoekPanel);

		// grechtentabel aanmaken
		gerechtenTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Gerecht", "Prijs in €", "Stock", "Beschrijving", "Foto" }) {
			Class[] types = new Class[] { String.class, Double.class, Integer.class, String.class, Icon.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});

		gerechtenTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				gerechtenTableMouseClicked(evt);
			}
		});
		jScrollPane3.setViewportView(gerechtenTable);

		// layout aanmaken voor gerechtenPanel
		GroupLayout gerechtenPanelLayout = new GroupLayout(gerechtenPanel);
		gerechtenPanel.setLayout(gerechtenPanelLayout);
		gerechtenPanelLayout.setHorizontalGroup(
				gerechtenPanelLayout.createParallelGroup().addComponent(jScrollPane3, 1200, 1200, 1200));
		gerechtenPanelLayout
				.setVerticalGroup(gerechtenPanelLayout.createParallelGroup().addComponent(jScrollPane3, 590, 590, 590));
		hoofdPanel.add(gerechtenPanel);

		// hiermee wordt een tabel aangemaakt waar enkel de naam, prijs en hoeveelheid
		// van de bestelde item wordt getoond
		cartItemTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Gerecht", "Prijs in €", "Hoeveelheid" }));
		cartItemTable.setEnabled(true);
		jScrollPane2.setViewportView(cartItemTable);
		
		// bestelButton van de cartPanel add action listener	
		bestelButton.setIcon(new ImageIcon(getClass().getResource("/icons/ic_menu_send.png")));
		bestelButton.setText("       Bestel");
		bestelButton.setBackground(Color.gray);
		bestelButton.setForeground(Color.white);
		bestelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bestelButtonActionPerformed(evt);
			}
		});

		jLabel4.setText("Totaal rekening:");
		jLabel5.setText("");
		
		// kartbutton add action listener		
		karButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				karButtonActionPerformed(evt);
			}
		});

		// knop om een rij te verwijderen van de cartatble
		jButton_Delete_Row.setText("Verwijderen");
		jButton_Delete_Row.setForeground(Color.white);
		jButton_Delete_Row.setBackground(Color.gray);
		jButton_Delete_Row.setIcon(new ImageIcon(getClass().getResource("/icons/delete.png")));
		jButton_Delete_Row.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonDeleteRowActionPerformed(evt);
			}

			private void jButtonDeleteRowActionPerformed(ActionEvent evt) {
				DefaultTableModel model = (DefaultTableModel) cartItemTable.getModel();
				int SelectedRowIndex = cartItemTable.getSelectedRow();
				model.removeRow(SelectedRowIndex);
				// haalt de geselecteerde rij-index op
				try {
					model.setRowCount(0);
					totaal = BigDecimal.ZERO;
					ProductInformatie.cartItem.remove(SelectedRowIndex);
					for (int i = 0; i < ProductInformatie.cartItem.size(); i++) {
						data[0] = ProductInformatie.cartItem.get(i).getGerecht();
						data[1] = ProductInformatie.cartItem.get(i).getPrijs();
						data[2] = ProductInformatie.cartItem.get(i).getQty();
						model.addRow(data);
						cartItemTable.setRowHeight(20);
						BigDecimal str = new BigDecimal(cartItemTable.getValueAt(i, 1) + "");
						totaal = totaal.add(str);
					}
					rekeningLbl.setText(String.valueOf(df.format(totaal)));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		// cartPanel layout aanmaken
		cartPanel.setBackground(new Color(233, 226, 205));
		GroupLayout cartPanelLayout = new GroupLayout(cartPanel);
		cartPanel.setLayout(cartPanelLayout);
		cartPanelLayout.setHorizontalGroup(cartPanelLayout.createParallelGroup().addComponent(jScrollPane2)
				.addGroup(cartPanelLayout.createParallelGroup().addComponent(jLabel4)
						.addComponent(rekeningLbl, 142, 142, 142).addComponent(jButton_Delete_Row, 160, 160, 160)
						.addComponent(bestelButton, 160, 160, 160)));
		cartPanelLayout
				.setVerticalGroup(cartPanelLayout.createSequentialGroup().addComponent(jScrollPane2, 355, 355, 355)
						.addGroup(cartPanelLayout.createSequentialGroup().addComponent(jLabel4, 66, 66, 66)
								.addComponent(rekeningLbl, 66, 66, 66).addComponent(jButton_Delete_Row, 50, 50, 50)
								.addGap(10, 10, 10).addComponent(bestelButton, 50, 50, 50)));

		hoofdPanel.add(cartPanel);
		drankTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Drank", "Prijs in €", "Voorraad", "Kenmerk", "Foto" }) {

			Class[] types = new Class[] { String.class, Double.class, Integer.class, String.class, Icon.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});

		drankTable.getTableHeader().setReorderingAllowed(false);
		drankTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				drankTableMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(drankTable);

		// Drankenpanellayout aanmaken
		GroupLayout drankPanelLayout = new GroupLayout(drankPanel);
		drankPanel.setLayout(drankPanelLayout);
		drankPanelLayout.setHorizontalGroup(
				drankPanelLayout.createParallelGroup().addComponent(jScrollPane1, 1200, 1200, 1200));
		drankPanelLayout
				.setVerticalGroup(drankPanelLayout.createParallelGroup().addComponent(jScrollPane1, 590, 590, 590));
		hoofdPanel.add(drankPanel);

		// kinderen tabel
		kidsTable.setFont(new Font("Roboto", 0, 14));
		kidsTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Gerecht", "Prijs in €", "Voorraad", "Beschrijving", "Foto" }) {

			Class[] types = new Class[] { String.class, Double.class, Integer.class, String.class, Icon.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});

		kidsTable.getTableHeader().setReorderingAllowed(false);
		kidsTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				kidsTableMouseClicked(evt);
			}
		});
		jScrollPane4.setViewportView(kidsTable);

		GroupLayout kidsPanelLayout = new GroupLayout(kidsPanel);
		kidsPanel.setLayout(kidsPanelLayout);
		kidsPanelLayout
				.setHorizontalGroup(kidsPanelLayout.createParallelGroup().addComponent(jScrollPane4, 1200, 1200, 1200));
		kidsPanelLayout
				.setVerticalGroup(kidsPanelLayout.createParallelGroup().addComponent(jScrollPane4, 590, 590, 590));
		hoofdPanel.add(kidsPanel);
		AchtergrondPanel.add(hoofdPanel);

		// getContentPane() layout
		getContentPane().setBackground(new Color(107, 194, 245));
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(jpanel2).addComponent(AchtergrondPanel, 1300, 1300, 1300)));
		layout.setVerticalGroup(
				layout.createParallelGroup().addComponent(jpanel2).addComponent(AchtergrondPanel, 665, 665, 665));
		pack();
	}

	// gerehtenButton klikken
	private void gerehtenButtonActionPerformed(ActionEvent evt) {
		hoofdPanel.removeAll();
		hoofdPanel.add(gerechtenPanel);
		hoofdPanel.repaint();
		hoofdPanel.revalidate();
		JTableHeader header = gerechtenTable.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setBackground(Color.ORANGE);
		header.setFont(new Font("Forte", Font.ITALIC, 26));
		ProductInformatie.KiezCategorie = "gerechten";
		ArrayList<ProductLijst> list = GerechtenDb.MaakTabel();
		Object rowData[] = new Object[5];

		DefaultTableModel model = (DefaultTableModel) gerechtenTable.getModel();

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		gerechtenTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		gerechtenTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		gerechtenTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		gerechtenTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		model.setRowCount(0); // Tabel leegmaken

		for (int i = 0; i < list.size(); i++) {
			rowData[0] = list.get(i).getGerecht();
			// rowData[1] = String.format("%.2f",list.get(i).getPrijs());
			rowData[1] = list.get(i).getPrijs();
			rowData[2] = list.get(i).getQty();
			rowData[3] = list.get(i).getBeschrijving();
			String temp = list.get(i).getMimage();
			File f = new File(temp);
			ImageIcon ii = new ImageIcon(f.getAbsolutePath());
			Image resizedImage = ii.getImage();
			ii = new ImageIcon(resizedImage.getScaledInstance(260, 260, 260));
			rowData[4] = ii;
			model.addRow(rowData);
			gerechtenTable.setRowHeight(150);
			gerechtenTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		}
	}

	// hiermee wordt er bepaald wat er moet gebeuren bij het aanklikken van de
	// accountButton
	private void accountButtonActionPerformed(ActionEvent evt) {
		if (LogInPanel.signInStatus == false) {
			LogInPanel lp = new LogInPanel();
			lp.setVisible(true);
			this.setVisible(false);
		} else {
			jLabel5.setText("U bent aangemeld als: " + LogInPanel.inlogger);
			System.out.println("U bent aangemeld als: " + LogInPanel.inlogger);
		}
	}

// hierdoor wordt een totaalprijs van de bestelde items berekend als het op de knop karButton wordt gedrukt
	private void karButtonActionPerformed(ActionEvent evt) {

		hoofdPanel.removeAll();
		hoofdPanel.add(cartPanel);
		hoofdPanel.repaint();
		hoofdPanel.revalidate();
		DefaultTableModel model = (DefaultTableModel) cartItemTable.getModel();
		JTableHeader header = cartItemTable.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setBackground(Color.ORANGE);
		header.setFont(new Font("Forte", Font.ITALIC, 26));
		model.setRowCount(0);
		totaal = BigDecimal.ZERO;

		for (int i = 0; i < ProductInformatie.cartItem.size(); i++) {
			data[0] = ProductInformatie.cartItem.get(i).getGerecht();
			data[1] = ProductInformatie.cartItem.get(i).getPrijs();
			data[2] = ProductInformatie.cartItem.get(i).getQty();
			model.addRow(data);
			cartItemTable.setRowHeight(20);
			BigDecimal str = new BigDecimal(cartItemTable.getValueAt(i, 1) + "");
			totaal = totaal.add(str);
		}
		rekeningLbl.setText(String.valueOf(df.format(totaal)));
	}

	// het aanklikken van de button dranken om naar drankenpanel te gaan
	private void drankenButtonActionPerformed(ActionEvent evt) {
		hoofdPanel.removeAll();
		hoofdPanel.add(drankPanel);
		hoofdPanel.repaint();
		hoofdPanel.revalidate();
		ProductInformatie.KiezCategorie = "drank";
		JTableHeader header = drankTable.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setBackground(Color.ORANGE);
		header.setFont(new Font("Forte", Font.ITALIC, 26));
		ArrayList<ProductLijst> list = DrankDB.MaakTabel();
		Object rowData[] = new Object[5];
		DefaultTableModel model = (DefaultTableModel) drankTable.getModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		drankTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		drankTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		drankTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		drankTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		model.setRowCount(0); // drankTable leegmaken
		for (int i = 0; i < list.size(); i++) {
			rowData[0] = list.get(i).getGerecht();
			rowData[1] = list.get(i).getPrijs();
			rowData[2] = list.get(i).getQty();
			rowData[3] = list.get(i).getBeschrijving();
			String temp = list.get(i).getMimage();
			File f = new File(temp);
			ImageIcon ii = new ImageIcon(f.getAbsolutePath());
			Image resizedImage = ii.getImage();
			ii = new ImageIcon(resizedImage.getScaledInstance(160, 160, 160));
			rowData[4] = ii;
			model.addRow(rowData);
			drankTable.setRowHeight(150);
			drankTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		}
	}

	// het aanklikken van de button kids om naar kidspanel te laten verschijnen
	private void kidsButtonActionPerformed(ActionEvent evt) {
		hoofdPanel.removeAll();
		hoofdPanel.add(kidsPanel);
		hoofdPanel.repaint();
		hoofdPanel.revalidate();
		ProductInformatie.KiezCategorie = "kids";
		JTableHeader header = kidsTable.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setBackground(Color.ORANGE);
		header.setFont(new Font("Forte", Font.ITALIC, 26));
		ArrayList<ProductLijst> list = KinderMenuDb.MaakTabel();
		Object rowData[] = new Object[5];
		DefaultTableModel model = (DefaultTableModel) kidsTable.getModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		kidsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		kidsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		kidsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		kidsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		model.setRowCount(0); // drankTable leegmaken

		for (int i = 0; i < list.size(); i++) {
			rowData[0] = list.get(i).getGerecht();
			rowData[1] = list.get(i).getPrijs();
			rowData[2] = list.get(i).getQty();
			rowData[3] = list.get(i).getBeschrijving();
			String temp = list.get(i).getMimage();
			File f = new File(temp);
			ImageIcon ii = new ImageIcon(f.getAbsolutePath());
			Image resizedImage = ii.getImage();
			ii = new ImageIcon(resizedImage.getScaledInstance(250, 250, 250));
			rowData[4] = ii;
			model.addRow(rowData);
			kidsTable.setRowHeight(100);
			kidsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		}
	}

	// bestelButton aanklikken om de hele bestelling door te geven (naar database)
	private void bestelButtonActionPerformed(ActionEvent evt) {

		if (!LogInPanel.signInStatus) {
			LogInPanel lp = new LogInPanel();
			lp.setVisible(true);
			lp.waarschuwlbl.setText("Gelieve eerst in te loggen.");
			this.setVisible(false);
		} else {
			Date date = new Date();
			FactuurDb.voegToeFactuurDB(LogInPanel.inlogger, totaal, date.toString());
			DefaultTableModel dt = (DefaultTableModel) Restaurant.cartItemTable.getModel();
			dt.setRowCount(0);
			rekeningLbl.setText("0,00 €");
			ProductInformatie.cartItem.clear();
		}
	}

	// hiermee kan de gebruiker zich uitloggen. Eerst wordt er gechekct of het een
	// "admin" is dan wordt het programma afgesloten ter beschermening van de admin
	// anders wordt er enkel uitgelogd en kan een andere gebruiker ook zicht
	// aanmelden
	private void logOutButtonActionPerformed(ActionEvent evt) {

		if ((LogInPanel.signInStatus == false) || LogInPanel.inlogger.equals("admin")) {
			System.exit(0);
		} else {
			LogInPanel.signInStatus = false;
			jLabel2.setIcon(new ImageIcon(getClass().getResource("/icons/afgemeld.png")));
			jLabel5.setText("U bent afgemeld!");
			LogInPanel.inlogger = "";
		}
	}

	// een product selecteren bij het aanklikken en op een productinformatie panel.
	// Hierdoor wordt een instance "ProductInformatie" opgeroepen
	// en wordt de informatie van de aangeklikt rij daarop weergegeven door de
	// functie getSelectedRow() en telkens op de juiste plaats (label, veld ..)
	// gezet door bv setText of setIcon te gebruiken

	// 1) de gerechtentabel aanklikken
	private void gerechtenTableMouseClicked(MouseEvent evt) {
		ProductInformatie pi = new ProductInformatie();
		pi.setVisible(true);

		int selectedRow = gerechtenTable.getSelectedRow();
		TableModel tm = gerechtenTable.getModel();
		String gerecht = tm.getValueAt(selectedRow, 0).toString();
		String prijs = tm.getValueAt(selectedRow, 1).toString();
		String voorraad = tm.getValueAt(selectedRow, 2).toString();
		String beschrijving = tm.getValueAt(selectedRow, 3).toString();
		ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);
		pi.lblInfoNaam.setText(gerecht);
		pi.lblInfoPrijs.setText(prijs);
		pi.lblInfoVoorraad.setText(voorraad);
		pi.lblInfoBeschrijf.setText(beschrijving);
		pi.lblFoto.setIcon(img);
	}

	// 2) de dranktabel aanklikken
	private void drankTableMouseClicked(MouseEvent evt) {
		ProductInformatie pi = new ProductInformatie();
		pi.setVisible(true);
		int selectedRow = drankTable.getSelectedRow();
		TableModel tm = drankTable.getModel();

		String gerecht = tm.getValueAt(selectedRow, 0).toString();
		String prijs = tm.getValueAt(selectedRow, 1).toString();
		String voorraad = tm.getValueAt(selectedRow, 2).toString();
		String beschrijving = tm.getValueAt(selectedRow, 3).toString();
		ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);

		pi.lblInfoNaam.setText(gerecht);
		pi.lblInfoPrijs.setText(prijs);
		pi.lblInfoVoorraad.setText(voorraad);
		pi.lblInfoBeschrijf.setText(beschrijving);
		pi.lblFoto.setIcon(img);
	}

	// 3)de kidstabel button aanklikken
	private void kidsTableMouseClicked(MouseEvent evt) {
		ProductInformatie pi = new ProductInformatie();
		pi.setVisible(true);

		int selectedRow = kidsTable.getSelectedRow();
		TableModel tm = kidsTable.getModel();
		String gerecht = tm.getValueAt(selectedRow, 0).toString();
		String prijs = tm.getValueAt(selectedRow, 1).toString();
		String voorraad = tm.getValueAt(selectedRow, 2).toString();
		String beschrijving = tm.getValueAt(selectedRow, 3).toString();
		ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);
		pi.lblInfoNaam.setText(gerecht);
		pi.lblInfoPrijs.setText(prijs);
		pi.lblInfoVoorraad.setText(voorraad);
		pi.lblInfoBeschrijf.setText(beschrijving);
		pi.lblFoto.setIcon(img);
	}

	// zoekenButton om item op te halen
	private void zoekButtonActionPerformed(ActionEvent evt) {
		ZoekenDb.gerechten = 0;
		ZoekenDb.drank = 0;
		ZoekenDb.kids = 0;
		ArrayList<ProductLijst> list = ZoekenDb.zoekProduct(zoekBar.getText());
		Object rowData[] = new Object[6];
		int i, j, k;
		if (zoekBar.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Zoekveld is leeg!");
		else if (ZoekenDb.gerechten == 0 && ZoekenDb.drank == 0 && ZoekenDb.kids == 0) {
			zoekBar.setText("");
			JOptionPane.showMessageDialog(null, "Sorry! Product Bestaat niet!");
		} else {
			hoofdPanel.removeAll();
			hoofdPanel.add(zoekPanel);
			hoofdPanel.repaint();
			hoofdPanel.revalidate();
			DefaultTableModel model = (DefaultTableModel) zoekTble.getModel();
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.LEADING);
			zoekTble.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			zoekTble.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			zoekTble.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			zoekTble.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

			model.setRowCount(0);
			for (i = 0; i < ZoekenDb.gerechten; i++) {
				rowData[0] = list.get(i).getGerecht();
				rowData[1] = list.get(i).getPrijs();
				rowData[2] = list.get(i).getQty();
				rowData[3] = list.get(i).getBeschrijving();
				String temp = list.get(i).getMimage();
				File f = new File(temp);
				ImageIcon ii = new ImageIcon(f.getAbsolutePath());
				Image resizedImage = ii.getImage();
				ii = new ImageIcon(resizedImage.getScaledInstance(160, 160, 160));
				rowData[4] = ii;
				model.addRow(rowData);
				zoekTble.setRowHeight(150);
				zoekTble.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
			for (k = i; k < ZoekenDb.drank + ZoekenDb.gerechten; k++) {
				rowData[0] = list.get(k).getGerecht();
				rowData[1] = list.get(k).getPrijs();
				rowData[2] = list.get(k).getQty();
				rowData[3] = list.get(k).getBeschrijving();
				String temp = list.get(i).getMimage();
				File f = new File(temp);
				ImageIcon ii = new ImageIcon(f.getAbsolutePath());
				Image resizedImage = ii.getImage();
				ii = new ImageIcon(resizedImage.getScaledInstance(160, 160, 160));
				rowData[4] = ii;
				model.addRow(rowData);
				zoekTble.setRowHeight(150);
				zoekTble.getColumnModel().getColumn(4).setPreferredWidth(150);

			}
			System.out.println();
			for (j = k; j < ZoekenDb.drank + ZoekenDb.gerechten + ZoekenDb.kids; j++) {
				rowData[0] = list.get(j).getGerecht();
				rowData[1] = list.get(j).getPrijs();
				rowData[2] = list.get(j).getQty();
				rowData[3] = list.get(j).getBeschrijving();
				String temp = list.get(i).getMimage();
				File f = new File(temp);
				ImageIcon ii = new ImageIcon(f.getAbsolutePath());
				Image resizedImage = ii.getImage();
				ii = new ImageIcon(resizedImage.getScaledInstance(160, 160, 160));
				rowData[4] = ii;
				model.addRow(rowData);
				zoekTble.setRowHeight(150);
				zoekTble.getColumnModel().getColumn(4).setPreferredWidth(150);
			}
		}
	}

	// bij het klikken op een item in zoektabel kunnen we dat item selecteren en
	// indien gewenst doorgeven door de knop "voeg toe aan bestelling".
	private void zoekTbleMouseClicked(MouseEvent evt) {
		ProductInformatie pi = new ProductInformatie();
		int rowIndex = zoekTble.getSelectedRow();
		if (ZoekenDb.gerechten != 0 && rowIndex < ZoekenDb.gerechten)
			ProductInformatie.KiezCategorie = "gerechten";
		else if (ZoekenDb.drank != 0 && rowIndex >= ZoekenDb.gerechten
				&& rowIndex < ZoekenDb.gerechten + ZoekenDb.drank)
			ProductInformatie.KiezCategorie = "drank";
		else
			ProductInformatie.KiezCategorie = "kids";
		pi.setVisible(true);
		pi.pack();
		int selectedRow = zoekTble.getSelectedRow();
		TableModel tm = zoekTble.getModel();
		String gerecht = tm.getValueAt(selectedRow, 0).toString();
		String prijs = tm.getValueAt(selectedRow, 1).toString();
		String voorraad = tm.getValueAt(selectedRow, 2).toString();
		String beschrijving = tm.getValueAt(selectedRow, 3).toString();
		ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);

		pi.lblInfoNaam.setText(gerecht);
		pi.lblInfoPrijs.setText(prijs);
		pi.lblInfoVoorraad.setText(voorraad);
		pi.lblInfoBeschrijf.setText(beschrijving);
		pi.lblFoto.setIcon(img);
	}

	public static void main(String args[]) throws Exception {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()
					);
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Maak en toon het formulier
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Restaurant().setVisible(true);

			}
		});
	}

	// Variables declaration
	private JButton accountButton;
	private JButton logOutButton;
	private JButton bestelButton;
	private JButton jButton_Delete_Row;
	private JButton karButton;
	private JButton gerehtenButton;
	private JButton kidsButton;
	private JButton drankenButton;
	private JButton zoekButton;
	public static JTable cartItemTable;
	private JTable gerechtenTable;
	private JTable zoekTble;
	private JLabel jLabel1;
	static JLabel jLabel2;
	private JLabel jLabel4;
	static JLabel jLabel5;
	private JLabel rekeningLbl;
	private JLabel lbl;
	private JPanel jpanel1;
	private JPanel jpanel2;
	private JPanel hoofdPanel;
	private JPanel gerechtenPanel;
	private JPanel cartPanel;
	private JPanel AchtergrondPanel;
	private JPanel drankPanel;
	private JPanel zoekPanel;
	private JPanel kidsPanel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JTable kidsTable;
	private JTable drankTable;
	private JTextField zoekBar;
}