package game;

public class Kagit extends Nesne { 
	public Kagit(int ID) { 
		super();
		this.ID = ID;
	}
	protected int nufuz = 2; // kagitlar icin nufuz degeri
	public Kagit() { 
		super();
	}
	public int getNufuz() {
		return nufuz;
	}
	public void setNufuz(int nufuz) {
		this.nufuz = nufuz;
	}
	
	public String nesnePuaniGoster() { // override edilen nesnePuaniGoster fonksiyonu
		return "Kagit("+ID+") [nufuz=" + nufuz + ", dayaniklilik=" + dayaniklilik + ", seviye_puani=" + seviye_puani + "]";
		
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof AgirTas) // eger nesne AgirTas ise
		{
			AgirTas ozelNesne = (AgirTas) nesne; 
			return (nufuz) / (ozelNesne.a * ozelNesne.getKatilik() * ozelNesne.getSicaklik());
		}
		if (nesne instanceof Tas) // eger nesne Tas ise
		{
			Tas ozelNesne = (Tas) nesne;
			return (nufuz) / (ozelNesne.a * ozelNesne.getKatilik());
		}
		if (nesne instanceof UstaMakas) // eger nesne UstaMakas ise
		{
			UstaMakas ozelNesne = (UstaMakas) nesne; 
			return (nufuz) / ((1-ozelNesne.a) * ozelNesne.getKeskinlik() * ozelNesne.getDirenc());
		}
		if (nesne instanceof Makas) // eger nesne Makas ise
		{
			Makas ozelNesne = (Makas) nesne; 
			return (nufuz) / ((1-ozelNesne.a) * ozelNesne.getKeskinlik());
		}
		
		return 1; // eger nesne hicbiri degilse
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki;
	}
}
