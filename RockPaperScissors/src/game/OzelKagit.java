package game;

public class OzelKagit extends Kagit { 
	public OzelKagit(int nufuz, int kalinlik) { 
		super(nufuz);
		this.kalinlik = kalinlik;
	}
	protected int kalinlik = 2;
	public OzelKagit() { 
		super();
	}
	public int getKalinlik() {
		return kalinlik;
	}
	public void setKalinlik(int kalinlik) {
		this.kalinlik = kalinlik;
	}

	
	public String nesnePuaniGoster() {
		return "OzelKagit("+ID+") [kalinlik=" + kalinlik + ", nufuz=" + nufuz + ", dayaniklilik=" + dayaniklilik
				+ ", seviye_puani=" + seviye_puani + "]";
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof AgirTas) // eger nesne UstaMakas ise
		{
			AgirTas ozelNesne = (AgirTas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (nufuz * kalinlik) / (ozelNesne.a * ozelNesne.getKatilik() * ozelNesne.getSicaklik());
		}
		if (nesne instanceof Tas) // eger nesne UstaMakas ise
		{
			Tas ozelNesne = (Tas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (nufuz * kalinlik) / (ozelNesne.a * ozelNesne.getKatilik());
		}
		if (nesne instanceof UstaMakas) // eger nesne UstaMakas ise
		{
			UstaMakas ozelNesne = (UstaMakas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (nufuz * kalinlik) / ((1-ozelNesne.a) * ozelNesne.getKeskinlik() * ozelNesne.getDirenc());
		}
		if (nesne instanceof Makas) // eger nesne UstaMakas ise
		{
			Makas ozelNesne = (Makas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (nufuz * kalinlik) / ((1-ozelNesne.a) * ozelNesne.getKeskinlik());
		}
		
		return 1; 
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki; 
	}
}
