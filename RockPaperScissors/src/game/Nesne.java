package game;

// abstract sinif, yani dogrudan nesne uretilemez
abstract class Nesne {
	public Nesne() // parametresiz constructor
	{
		this.dayaniklilik = 20;
		this.seviye_puani = 0;
	}
	public Nesne(int dayaniklilik) { // 1 parametreli constructor
		this.dayaniklilik = dayaniklilik;
	}
	public Nesne(int dayaniklilik, int seviye_puani) { // 2 parametreli constructor
		this.dayaniklilik = dayaniklilik;
		this.seviye_puani = seviye_puani;
	}
	protected int ID; // kartin numarasi
	protected int dayaniklilik; // kartin dayanikliligi
	protected float a = 0.2f; // a degeri, sabit
	protected int seviye_puani; // kartin seviye puani
	protected boolean secildi = false; // kartin onceki ellerde secilip secilmedigi, secildiginde true olacak
	public int getDayaniklilik() {
		return dayaniklilik;
	}
	public void setDayaniklilik(int dayaniklilik) {
		this.dayaniklilik = dayaniklilik;
	}
	public int getSeviye_puani() {
		return seviye_puani;
	}
	public void setSeviye_puani(int seviye_puani) {
		this.seviye_puani = seviye_puani;
	}
	public String nesnePuaniGoster() {
		return "Nesne [dayaniklilik=" + dayaniklilik + ", seviye_puani=" + seviye_puani + "]";
	}
	// bu methodlar alt siniflarda ezilmek zoruinda birakildigi icin abstract yapildi
	public abstract double etkiHesapla(Nesne nesne); // Nesnelerin rakip nesneye karsı atak etkisini hesaplamak icin
	public abstract void durumGuncelle(double etki);
	// Nesnelerin karsılıklı atakları sonucunda etki degerleri kadar dayanıklılık degerlerinin
	// azaltılması ve seviye puanı guncellemeleri icin
	
	public boolean isSecildi() {
		return secildi;
	}
	public void setSecildi(boolean secildi) {
		this.secildi = secildi;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
