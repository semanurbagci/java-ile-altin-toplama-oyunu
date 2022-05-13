package oyun;

public class oyuncu {
	private String name;
	int baslangicAltin,harcananAltin,toplananAltin,kasadakiAltin;
	int hedefBedeli,hamleBedeli;
	int toplamAdim; 
	int index_i,index_j,hedef_i,hedef_j;
	private boolean hedef;
	
	public oyuncu(String name, int baslangicAltin, int hedefBedeli, int hamleBedeli, int index_i, int index_j) {
		this.name = name;
		this.baslangicAltin = baslangicAltin;
		this.kasadakiAltin=baslangicAltin;
		this.hedefBedeli = hedefBedeli;
		this.hamleBedeli = hamleBedeli;
		this.toplamAdim=0;
		this.index_i = index_i;
		this.index_j = index_j;
		this.hedef = false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBaslangicAltin() {
		return baslangicAltin;
	}
	public void setBaslangicAltin(int baslangicAltin) {
		this.baslangicAltin = baslangicAltin;
	}
	public int getHedefBedeli() {
		return hedefBedeli;
	}
	public void setHedefBedeli(int hedefBedeli) {
		this.hedefBedeli = hedefBedeli;
	}
	public int getHamleBedeli() {
		return hamleBedeli;
	}
	public void setHamleBedeli(int hamleBedeli) {
		this.hamleBedeli = hamleBedeli;
	}
	public int getToplamAdim() {
		return toplamAdim;
	}
	public void setToplamAdim(int toplamAdim) {
		this.toplamAdim = toplamAdim;
	}
	public int getHarcananAltin() {
		return harcananAltin;
	}
	public void setHarcananAltin(int harcananAltin) {
		this.harcananAltin = harcananAltin;
	}
	public int getToplananAltin() {
		return toplananAltin;
	}
	public void setToplananAltin(int toplananAltin) {
		this.toplananAltin = toplananAltin;
	}
	public int getKasadakiAltin() {
		return kasadakiAltin;
	}
	public void setKasadakiAltin(int kasadakiAltin) {
		this.kasadakiAltin = kasadakiAltin;
	}
	public boolean isHedef() {
		return hedef;
	}
	public void setHedef(boolean hedef) {
		this.hedef = hedef;
	}
	public int getIndex_i() {
		return index_i;
	}
	public void setIndex_i(int index_i) {
		this.index_i = index_i;
	}
	public int getIndex_j() {
		return index_j;
	}
	public void setIndex_j(int index_j) {
		this.index_j = index_j;
	}
	public int getHedef_i() {
		return hedef_i;
	}
	public void setHedef_i(int hedef_i) {
		this.hedef_i = hedef_i;
	}
	public int getHedef_j() {
		return hedef_j;
	}
	public void setHedef_j(int hedef_j) {
		this.hedef_j = hedef_j;
	}
}
