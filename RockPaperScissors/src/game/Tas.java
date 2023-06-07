package game;

public class Tas extends Nesne { 
	public Tas(int ID) { 
		super();
		this.ID = ID;
	}
	
	public Tas() { 
		super();
	}

	protected int katilik = 2; // Taslarin katilik degeri

	public int getKatilik() {
		return katilik;
	}

	public void setKatilik(int katilik) {
		this.katilik = katilik;
	}
	
	public String nesnePuaniGoster() { 
		return "Tas("+ID+") [katilik=" + katilik + ", dayaniklilik=" + dayaniklilik + ", seviye_puani=" + seviye_puani + "]";
		
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof UstaMakas) // eger nesne UstaMakas ise
		{
			UstaMakas ozelNesne = (UstaMakas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (katilik) / (ozelNesne.a * ozelNesne.getKeskinlik() * ozelNesne.getDirenc());
		}
		if (nesne instanceof Makas) // eger nesne Makas ise
		{
			Makas ozelNesne = (Makas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (katilik) / (ozelNesne.a * ozelNesne.getKeskinlik());
		}
		if (nesne instanceof OzelKagit) // eger nesne OzelKagit ise
		{
			OzelKagit ozelNesne = (OzelKagit) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (katilik) / ((1-ozelNesne.a) * ozelNesne.getNufuz() * ozelNesne.getKalinlik());
		}
		if (nesne instanceof Kagit) // eger nesne Kagit ise
		{
			Kagit ozelNesne = (Kagit) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (katilik) / ((1-ozelNesne.a) * ozelNesne.getNufuz());
		}
		
		return 1; 
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki;
	}


}
