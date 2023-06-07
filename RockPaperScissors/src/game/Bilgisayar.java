package game;

import java.util.ArrayList;
import java.util.Random;

public class Bilgisayar extends Oyuncu { 

	public Bilgisayar() { 
		super();
	}
	public Bilgisayar(int oyuncuID, String oyuncuAdi) { 
		super(oyuncuID, oyuncuAdi);
	}
	public Nesne nesneSec() { 
		ArrayList<Nesne> secilebilenNesneListesi = new ArrayList();
		
		for (Nesne n : nesneListesi) { 
			if (n.isSecildi())
				continue; 
			secilebilenNesneListesi.add(n); 
		}
		
		if (secilebilenNesneListesi.size() == 0) { 
			secilebilenNesneListesi = nesneListesi;
			for (Nesne n : nesneListesi) { 
				n.setSecildi(false);
			}
		}
		
		Nesne randomNesne = secilebilenNesneListesi.get(Oyun.rand.nextInt(secilebilenNesneListesi.size()));
		randomNesne.setSecildi(true); 
		return randomNesne; 
	}
}
