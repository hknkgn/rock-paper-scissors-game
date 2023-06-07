package game;

import java.util.ArrayList;

public class Kullanici extends Oyuncu { 

	public Kullanici() { 
		super();
	}
	public Kullanici(int oyuncuID, String oyuncuAdi) {
		super(oyuncuID, oyuncuAdi);
	}
	public Nesne nesneSec() { 
		ArrayList<Nesne> secilebilenNesneListesi = new ArrayList();
		
		for (Nesne n : nesneListesi) { 
			if (n.isSecildi())
				continue; 
			secilebilenNesneListesi.add(n); 
		}
		
		if (secilebilenNesneListesi.size() == 0) { // eger secilebilen hicbir kart yoksa, tum kartlar bir defa secilmis demektir
			secilebilenNesneListesi = nesneListesi; 
			for (Nesne n : nesneListesi) {
				n.setSecildi(false);
			}
		}
		
		// kullanicidan alinacak secimi tutmak icin degisken
		int secim = -1;
		
		// kullanicidan gecerli bi secim alana kadar
		while(secim <= 0 || secim > secilebilenNesneListesi.size()) {
			System.out.println("Kart seciniz:");
			for (int i = 0; i < secilebilenNesneListesi.size(); i++) {
				System.out.println(String.format("%d - %s", i+1, secilebilenNesneListesi.get(i).nesnePuaniGoster()));
			}
			System.out.println("Istediginiz kart numarasini giriniz:");
			secim = Oyun.sc.nextInt();
		}
		
		// secilen nesneyi al
		Nesne nesne = secilebilenNesneListesi.get(secim-1);
		nesne.setSecildi(true); // secildi olarak isaretle
		
		return nesne;
	}
}
