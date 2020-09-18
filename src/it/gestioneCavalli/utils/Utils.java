package it.gestioneCavalli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.gestioneCavalli.model.Animale;

public class Utils {

	public static final String[] ANIMALI = { "CAVALLO", "CAPRETTA", "ALPACA", "ASINO", "MULO", "CERVO", "MAREMMANA" };

	public static boolean isNotBlank(String s) {
		if (s == null) {
			return false;
		}
		String[] c = s.split(" ");
		if (c.length == 0 || c[0].equals("") || s.equals("")) {
			return false;
		}
		return true;
	}

	public static Double parsePrezzo(String prezzo) {
		Double result = 0.0;
		try {
			result = Double.parseDouble(prezzo);
		} catch (Exception e) {
			System.out.println("prezzo non valido");
		}
		return result;
	}

	public static String getStringDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static Date parseDate(String date) {
		Date result = null;
		try {
			String[] dateArray = date.split("-");
			int dayInt = Integer.parseInt(dateArray[2]);
			dayInt++;
			date = dateArray[0] + "-" + dateArray[1] + "-" + dayInt;
			result = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (Exception e) {
			System.out.println("data non valida");
		}
		return result;
	}

	public static boolean getBooleanfromString(String input) {
		if (input == null || input.equals("false") || input.equals("")) {
			return false;
		}
		return true;
	}

	public static String incrementDate(String date, int monthInput, int yearInput) {
		String result = "";
		try {
			String[] arrayDate = date.split("-");
			int day = Integer.parseInt(arrayDate[2]);
			int month = Integer.parseInt(arrayDate[1]);
			int year = Integer.parseInt(arrayDate[0]);
			month += monthInput;
			year += yearInput;

			if (month > 12) {
				month = month - 12;
				year += 1;
			}

			result = year + "-" + month + "-" + day;
		} catch (Exception e) {
			result = date;
		}
		return result;
	}

	public static String getLink(String nome, boolean foto) {
		String link = nome;
		if (foto) {
			link += ".jpg";
		} else {
			link += ".pdf";
		}
		System.out.println(link);
		return link;
	}

	public static String getLinkPDF(String nome) {
		String link = Utils.removeSpaceUpperCase(nome);
		link += ".pdf";
		System.out.println(link);
		return link;
	}

	public static String removeSpaceUpperCase(String txt) {
		String[] arrayTxt = txt.split(" ");
		String result = "";
		for (String s : arrayTxt) {
			result += s.toUpperCase();
		}
		return result;
	}

	public static Animale setPerTipo(Animale animale) {

		if (!"CAVALLO".equals(animale.getTipo())) {
			animale = Utils.svuotaPerNonCavalli(animale);
		} else if (!"F".equals(animale.getSesso())) {
			animale = Utils.svuotaPerCavalliMaschi(animale);
		}

		return animale;
	}

	public static Animale svuotaPerNonCavalli(Animale animale) {
		animale.setSesso(null);
		animale.setDaCorsa(false);
		animale.setRescue(false);
		animale.setPuledro(false);
		animale = Utils.svuotaPerCavalliMaschi(animale);
		return animale;
	}

	public static Animale svuotaPerCavalliMaschi(Animale animale) {
		animale.setFatrice(false);
		return animale;
	}

}
