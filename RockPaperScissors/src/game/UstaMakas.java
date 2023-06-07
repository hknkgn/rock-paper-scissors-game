package game;

public class UstaMakas extends Makas{ // Makas sinifindan kalitim aliyor
	public UstaMakas(int keskinlik, int direnc) { 
		super(keskinlik);
		this.direnc = direnc;
	}
	protected int direnc = 2; // usta makaslar icin direnc degeri
	protected int hiz; // usta makaslar icin hiz degeri
	public UstaMakas() { 
		super();
	}
	public int getDirenc() {
		return direnc;
	}
	public void setDirenc(int direnc) {
		this.direnc = direnc;
	}
	
	public String nesnePuaniGoster() { 
		return "UstaMakas("+ID+") [direnc=" + direnc + ", hiz=" + hiz + ", keskinlik=" + keskinlik + ", dayaniklilik="
				+ dayaniklilik + ", seviye_puani=" + seviye_puani + "]";		
	}
	public double etkiHesapla(Nesne nesne) {
		// etki hesaplamasi
		if (nesne instanceof OzelKagit) // eger nesne OzelKagit ise
		{
			OzelKagit ozelNesne = (OzelKagit) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (keskinlik * direnc) / (ozelNesne.a * ozelNesne.getNufuz() * ozelNesne.getKalinlik());
		}
		if (nesne instanceof Kagit) // eger nesne Kagit ise
		{
			Kagit ozelNesne = (Kagit) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (keskinlik * direnc) / (ozelNesne.a * ozelNesne.getNufuz());
		}
		if (nesne instanceof AgirTas) // eger nesne AgirTas ise
		{
			AgirTas ozelNesne = (AgirTas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (keskinlik * direnc) / ((1-ozelNesne.a) * ozelNesne.getKatilik() * ozelNesne.getSicaklik());
		}
		if (nesne instanceof Tas) // eger nesne Tas ise
		{
			Tas ozelNesne = (Tas) nesne; // nesneyi casting yap ve hesaplamalari yap
			return (keskinlik * direnc) / ((1-ozelNesne.a) * ozelNesne.getKatilik());
		}
		
		return 1; 
	}
	public void durumGuncelle(double etki) {
		dayaniklilik -= etki; 
	}
}
