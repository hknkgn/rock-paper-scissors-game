package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Oyun {
	final static int maxHamleSayisi = 10; // max hamle sayisi, degistirilemez(final) ve nesneden bagimsiz (static)
	
	static Scanner sc;
	static Random rand = new Random(); // random degerler olusturmak icin
	
	Oyuncu oyuncu1; 
	Oyuncu oyuncu2;
	int hamleSayisi; 
	int oyunModu; 
	
	public Oyun() {
		sc = new Scanner(System.in); 
		
		hamleSayisi = 0; 
		oyunModu = 0; 
	}

	
	public void OyunModuSec() // oyun modunu secerken kullaniliyor
	{
		System.out.println("MAIN MENU");
		System.out.println("Oyun modunu seciniz:");
		System.out.println("1- Kullanici vs. Bilgisayar");
		System.out.println("2- Bilgisayar vs. Bilgisayar");
		oyunModu = sc.nextInt(); // kullanicidan oyun modu girisini al
	}
	
	public void OyunculariOlustur()
	{
		switch (oyunModu) { 
		case 1: { 
			oyuncu1 = new Bilgisayar(1, "Bilgisayar-1");
			oyuncu2 = new Kullanici(2, "Kullanici");
			break;
		}
		case 2: { 
			oyuncu1 = new Bilgisayar(1, "Bilgisayar-1");
			oyuncu2 = new Bilgisayar(2, "Bilgisayar-2");
			break;
		}
		}
		
		oyuncu1.KartlariOlustur(); // iki oyuncunun da kartlarini olustur
		oyuncu2.KartlariOlustur();
	}
	
	public void Run()
	{
		OyunModuSec(); 
		OyunculariOlustur(); 

		sc.nextLine();
		
		while (true) { // oyun sona ermedigi surece
			hamleSayisi++; // hamle sayisini 1 arttir
			System.out.println("---------------------------------------------------------");
			System.out.println("------------------------ TUR: " + hamleSayisi + " -------------------------");
			System.out.println("---------------------------------------------------------");
			
			// oyunculardan nesne sec
			Nesne secilenNesne1 = oyuncu1.nesneSec();
			Nesne secilenNesne2 = oyuncu2.nesneSec();

			// oyuncularin sectikleri nesneleri ekrana yazdir
			System.out.println(oyuncu1.getOyuncuAdi() + " Secilen Kart: " + secilenNesne1.nesnePuaniGoster());
			System.out.println(oyuncu2.getOyuncuAdi() + " Secilen Kart: " + secilenNesne2.nesnePuaniGoster());
			
			// secilen kartlarin birbirlerine karsi etkilerini hesapla
			double etki1 = secilenNesne1.etkiHesapla(secilenNesne2);
			double etki2 = secilenNesne2.etkiHesapla(secilenNesne1);

			// hesaplanan etkileri ekrana yazdir
			System.out.println(oyuncu1.getOyuncuAdi() + " hesaplanan etki: " + etki1);
			System.out.println(oyuncu2.getOyuncuAdi() + " hesaplanan etki: " + etki2);
			
			// hesaplanan etkilere gore karsi taraftaki kartin durumunu guncelle
			secilenNesne1.durumGuncelle(etki2);
			secilenNesne2.durumGuncelle(etki1);
			
			// kartlarin birbirini yenmesi kosullari
			if (secilenNesne1.getDayaniklilik() <= 0) { // eger kart1 elenmisse
				oyuncu1.RemoveNesne(secilenNesne1); 
				System.out.println(oyuncu1.getOyuncuAdi() + "'in kartı elendi!");

				if (secilenNesne2.getDayaniklilik() <= 0) { 
					System.out.println(oyuncu2.getOyuncuAdi() + "'nin kartı da elendi!");
					oyuncu2.RemoveNesne(secilenNesne2); 
				}
				else { // eger sadece kart1 elenmisse
					secilenNesne2.setSeviye_puani(secilenNesne2.getSeviye_puani() + 20); // kart2 nin seviye puanini arttir
					
					if (secilenNesne2.getSeviye_puani() > 30) { // eger seviye puani yukselmisse
						
						Nesne yeniNesne = null; // yeni nesneyi tutmak icin degisken
						
						if (secilenNesne2 instanceof Kagit) { // eger eski kart Kagit ise
							yeniNesne = new OzelKagit(); // yeni kart OzelKagit olsun
						}
						else if (secilenNesne2 instanceof Tas) { // eger eski kart tas ise
							yeniNesne = new AgirTas(); // yeni kart AgirTas olsun
						}
						else if (secilenNesne2 instanceof Makas) { // eger eski kart makas ise
							yeniNesne = new UstaMakas(); // yeni kart UstaMakas olsun
						}
						
						yeniNesne.setID(secilenNesne2.getID()); 
						yeniNesne.setSecildi(true); 
						
						oyuncu2.RemoveNesne(secilenNesne2); 
						oyuncu2.AddNesne(yeniNesne); 
						
						System.out.println(oyuncu2.getOyuncuAdi() + "'nin kartı terfi etti!");
					}
				}
			}
			else if (secilenNesne2.getDayaniklilik() <= 0) { // eger kart2 elenmisse
				oyuncu2.RemoveNesne(secilenNesne2);
				System.out.println(oyuncu2.getOyuncuAdi() + "'nin kartı elendi!");

				if (secilenNesne1.getDayaniklilik() <= 0) { 
					System.out.println(oyuncu1.getOyuncuAdi() + "'in kartı da elendi!");
					oyuncu1.RemoveNesne(secilenNesne1); 
				}
				else {
					secilenNesne1.setSeviye_puani(secilenNesne1.getSeviye_puani() + 20); 
					
					if (secilenNesne1.getSeviye_puani() > 30) {
						
						Nesne yeniNesne = null; 
						
						if (secilenNesne1 instanceof Kagit) {
							yeniNesne = new OzelKagit(); 
						}
						else if (secilenNesne1 instanceof Tas) {
							yeniNesne = new AgirTas(); 
						}
						else if (secilenNesne1 instanceof Makas) { 
							yeniNesne = new UstaMakas(); 
						}
						
						yeniNesne.setID(secilenNesne1.getID()); 
						yeniNesne.setSecildi(true); 
						
						oyuncu1.RemoveNesne(secilenNesne1); 
						oyuncu1.AddNesne(yeniNesne); 
						
						System.out.println(oyuncu1.getOyuncuAdi() + "'in kartı terfi etti!"); 
					}
				}
			} else { // eger iki kartta da herhangi bir degisiklik olmadiysa
				System.out.println("Hicbir kart elenmedi, kartlarin son durumlari:");
				System.out.println(oyuncu1.getOyuncuAdi() + " Kart: " + secilenNesne1.nesnePuaniGoster());
				System.out.println(oyuncu2.getOyuncuAdi() + " Kart: " + secilenNesne2.nesnePuaniGoster());
			} 
			
			// eger kullanicilardan herhangi birinin karti kalmadiysa ve ya max hamle sayisina ulasildiysa
			if (oyuncu1.nesneListesi.size() == 0 || oyuncu2.nesneListesi.size() == 0 || hamleSayisi == maxHamleSayisi) {
				break;
			}
			
			// sonraki tura gecmek icin tusa basilmasini bekle
			System.out.println("---------------------------------------------------------");
			System.out.println("---------------------------------------------------------");
			System.out.println("Sonraki tura gecmek icin bir tusa tiklayin . . . ");
		    sc.nextLine();
		} // oyun bittiginde

		for (Nesne n : oyuncu1.getNesneListesi()) { // oyuncu1'in skorunu hesapla 
			oyuncu1.setSkor(oyuncu1.getSkor() + n.getDayaniklilik());
		}
		for (Nesne n : oyuncu2.getNesneListesi()) { 
			oyuncu2.setSkor(oyuncu2.getSkor() + n.getDayaniklilik());
		}
		
		System.out.println("---------------------------------------------------------");
		System.out.println("---------------------------------------------------------");
		System.out.println("OYUN BITTI");
		System.out.println("SKORLAR");
		System.out.println(oyuncu1.getOyuncuAdi() + ": " + oyuncu1.skor);
		System.out.println(oyuncu2.getOyuncuAdi() + ": " + oyuncu2.skor);
		if (oyuncu1.skor > oyuncu2.skor) {
			System.out.println(oyuncu1.getOyuncuAdi() + " kazandi!");
		}
		else if (oyuncu2.skor > oyuncu1.skor) {
			System.out.println(oyuncu2.getOyuncuAdi() + " kazandi!");
		}
		else {
			System.out.println("Berabere!");
		}
		
	}

}
