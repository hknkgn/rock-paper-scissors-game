package game;

public class Makas extends Nesne { 
	public Makas(int ID) { 
		super();
		this.ID = ID;
	}

	protected int keskinlik = 2; // makaslar icin keskinlik degeri
	
	public Makas() {
		super();
	}

	public int getKeskinlik() {
		return keskinlik;
	}

	public void setKeskinlik(int keskinlik) {
		this.keskinlik = keskinlik;
	}

	
	public String nesnePuaniGoster() { 
		return "Makas("+ID+") [keskinlik=" + keskinlik + ", dayaniklilik=" + dayaniklilik + ", seviye_puani=" + seviye_puani
				+ "]";		
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof OzelKagit) // eger nesne OzelKagit ise
		{
			OzelKagit ozelNesne = (OzelKagit) nesne; 
			return (keskinlik) / (ozelNesne.a * ozelNesne.getNufuz() * ozelNesne.getKalinlik());
		}
		if (nesne instanceof Kagit)
		{
			Kagit ozelNesne = (Kagit) nesne; 
			return (keskinlik) / (ozelNesne.a * ozelNesne.getNufuz());
		}
		if (nesne instanceof AgirTas) // eger nesne AgirTas ise
		{
			AgirTas ozelNesne = (AgirTas) nesne; 
			return (keskinlik) / ((1-ozelNesne.a) * ozelNesne.getKatilik() * ozelNesne.getSicaklik());
		}
		if (nesne instanceof Tas)
		{
			Tas ozelNesne = (Tas) nesne; 
			return (keskinlik) / ((1-ozelNesne.a) * ozelNesne.getKatilik());
		}
		
		return 1; 
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki; // etki miktari kadar dayanikliligi azalt
		
	}
}
