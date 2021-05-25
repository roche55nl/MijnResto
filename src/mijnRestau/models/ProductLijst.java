package mijnRestau.models;

import java.math.BigDecimal;

public class ProductLijst {
    private String gerecht;
    private BigDecimal prijs;
    private int qty;
    private String beschrijving;
    private String mimage;
  
    public ProductLijst(String gerecht, BigDecimal prijs, int qty, String beschrijving , String image) {
        this.gerecht = gerecht;
        this.prijs = prijs;
        this.qty = qty;
        this.beschrijving = beschrijving;
        this.mimage = image;
    }

	public String getGerecht() {
		return gerecht;
	}

	public void setGerecht(String gerecht) {
		this.gerecht = gerecht;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public String getMimage() {
		  //return new ImageIcon(new ImageIcon(mimage).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		return mimage;
	}

	public void setMimage(String mimage) {
		this.mimage = mimage;
	}

   


    
}
