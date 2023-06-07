package game;

import java.util.ArrayList;

public abstract class Oyuncu {
	public Oyuncu(int oyuncuID, String oyuncuAdi) { 
		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
	}
	public Oyuncu() { 
	}

	protected int oyuncuID;
	protected String oyuncuAdi;
	protected int skor;
	protected ArrayList<Nesne> nesneListesi = new ArrayList();

	public void KartlariOlustur() {
		// oyuncuların kartlarini random olarak olusturacak
		for (int i = 0; i < 5; i++) {
			int kartTipi = Oyun.rand.nextInt(3); // 0 ile 2 arasinda random bi deger uret
			switch (kartTipi) {
			case 0: {
				nesneListesi.add(new Tas(i));
				break;
			}
			case 1: {
				nesneListesi.add(new Kagit(i));
				break;
			}
			case 2: {
				nesneListesi.add(new Makas(i));
				break;
			}
			}
		}
	}
	
	public void SkorGoster() {
		// oyuncuların skorları gosterilecek.
	}
	public abstract Nesne nesneSec(); // alt siniflarda override edilmek zodunda olmasi icin abstract yapildi.
	public int getOyuncuID() {
		return oyuncuID;
	}
	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}
	public String getOyuncuAdi() {
		return oyuncuAdi;
	}
	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}
	public int getSkor() {
		return skor;
	}
	public void setSkor(int skor) {
		this.skor = skor;
	}
	public ArrayList<Nesne> getNesneListesi() {
		return nesneListesi;
	}
	public void AddNesne(Nesne nesne) {
		this.nesneListesi.add(nesne);
	}
	public void RemoveNesne(Nesne nesne) {
		this.nesneListesi.remove(nesne);
	}
	
}
