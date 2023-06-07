package game;

public class AgirTas extends Tas {
	public AgirTas(int sicaklik) {
		super();
		this.sicaklik = sicaklik;
	}
	
	public AgirTas() { 
		super();
	}

	protected int sicaklik = 2; 

	public int getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(int sicaklik) {
		this.sicaklik = sicaklik;
	}
	
	public String nesnePuaniGoster() {
		return "AgirTas("+ID+") [sicaklik=" + sicaklik + ", dayaniklilik=" + dayaniklilik + ", seviye_puani=" + seviye_puani
				+ "]";
		
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof UstaMakas)
		{
			UstaMakas ozelNesne = (UstaMakas) nesne;
			return (katilik * sicaklik) / (ozelNesne.a * ozelNesne.getKeskinlik() * ozelNesne.getDirenc());
		}
		if (nesne instanceof Makas)
		{
			Makas ozelNesne = (Makas) nesne;
			return (katilik * sicaklik) / (ozelNesne.a * ozelNesne.getKeskinlik());
		}
		if (nesne instanceof OzelKagit)
		{
			OzelKagit ozelNesne = (OzelKagit) nesne;
			return (katilik * sicaklik) / ((1-ozelNesne.a) * ozelNesne.getNufuz() * ozelNesne.getKalinlik());
		}
		if (nesne instanceof Kagit)
		{
			Kagit ozelNesne = (Kagit) nesne;
			return (katilik * sicaklik) / ((1-ozelNesne.a) * ozelNesne.getNufuz());
		}
		
		return 1;
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki; // etki miktari kadar dayanikliligi azalt
	}


}
