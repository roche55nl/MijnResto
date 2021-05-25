package mijnRestau.models;

public class Klant {
	private int id;
	private String naam;
	private String voornaam;
	private String email;
	private String straat;
	private String postCode;
	private String stad;
	private int huisnummer;
	
	public Klant(int id,String naam, String voornaam, String email, String straat, int huisnummer, String postCode, String stad
			) {
		super();
		this.id = id;
		this.naam = naam;
		this.voornaam = voornaam;
		this.email = email;
		this.straat = straat;
		this.postCode = postCode;
		this.stad = stad;
		this.huisnummer = huisnummer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

}
