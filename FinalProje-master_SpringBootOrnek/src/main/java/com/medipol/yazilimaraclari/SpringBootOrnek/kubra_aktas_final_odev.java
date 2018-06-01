package com.medipol.yazilimaraclari.SpringBootOrnek;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class kubra_aktas_final_odev {

	private List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();

	public kubra_aktas_final_odev() {
		
	}
	
	public kubra_aktas_final_odev(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}
	
	class Ogrenci {
		String ad, soyad;
		public String getAd() { return ad;}
		public String getSoyad() { return soyad;}
	}

	
	@RequestMapping("/ogrenci/listele")
	public List<Ogrenci> ogrenciListele() {
		return ogrenciler;
	}

	
	@RequestMapping(value="/ogrenci/olustur",method = RequestMethod.GET)
	public synchronized Ogrenci ogrenciOlustur(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	
	@RequestMapping(
			value="/ogrenci/olustur/post", 
			method = RequestMethod.POST 
	)
	public synchronized Ogrenci ogrenciOlusturPost(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	protected Ogrenci ogrenciEkle(List<Ogrenci> liste, String ad, String soyad) {
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.ad=ad;
		ogrenci.soyad=soyad;
		liste.add(ogrenci);
		return ogrenci;
	}
}
