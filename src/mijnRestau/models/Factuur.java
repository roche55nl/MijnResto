package mijnRestau.models;

import java.math.BigDecimal;

public class Factuur {

    private int id;
    private String uname;
    private BigDecimal bedrag;
    private String date;

 
    
    public Factuur(int id, String uname, BigDecimal bedrag, String date) {
    	  this.id = id;
          this.uname = uname;
          this.bedrag = bedrag;
          this.date = date;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    public void setBedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
