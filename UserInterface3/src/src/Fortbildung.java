package src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Fortbildung {

	private String titel;
	private Fortbildung[] vorraussetzung = new Fortbildung[2];
	private static HashSet<Fortbildung> fortbildungen = new HashSet<Fortbildung>();
	private boolean istvorraussetzung = false;

	Fortbildung() {

	}

	Fortbildung(String titel, Fortbildung vorraussetzung, boolean istvor) {
		this.titel = titel;
		this.vorraussetzung[0] = vorraussetzung;
		fortbildungen.add(this);
		istvorraussetzung = istvor;

	}

	Fortbildung(String titel, boolean istvor) {
		this.titel = titel;
		fortbildungen.add(this);
		istvorraussetzung = istvor;

	}

	Fortbildung(String titel, Fortbildung vorraussetzung, Fortbildung vorraussetzung2) {
		this.titel = titel;
		this.vorraussetzung[0] = vorraussetzung;
		this.vorraussetzung[1] = vorraussetzung2;
		fortbildungen.add(this);

	}
	
	
	static {
		// Fortbildungen Hinzufügen
		Fortbildung Mathematik_1 = new Fortbildung("Mathematik_1", true);
		Fortbildung Mathematik_2 = new Fortbildung("Mathematik_2", Mathematik_1, true);
		Fortbildung Allgemeine_Betriebswirtschaftslehre = new Fortbildung("Allg._BWL", true);
		Fortbildung Kostenrechnung = new Fortbildung("K-rechnung", Mathematik_2, Allgemeine_Betriebswirtschaftslehre);
		
		fortbildungen.add(Mathematik_1);
		fortbildungen.add(Mathematik_2);
		fortbildungen.add(Allgemeine_Betriebswirtschaftslehre);
		fortbildungen.add(Kostenrechnung);

	}

	public String getTitel() {
		return this.titel;
	}

	public static void druckeAlleFortbildungen() {
		System.out.println("-------Fortbildungen-------");
		Iterator it = fortbildungen.iterator();
		while (it.hasNext()) {
			System.out.println(((Fortbildung) (it.next())).titel);
		}
		System.out.println("---------------------------");
	}

	public static Fortbildung gib(String name) {
		int k = 3;
		for (int i = 0; i < 3; i++) {
			for (Fortbildung f : fortbildungen) {
				if (f.titel.equals(name)) {
					return f;
				}
			}
			k = k - i;
			System.out.println("Keine Fortbildung Namens " + name);
			System.out.println("Anzahl Versuche: " + k);
			System.out.println("Geben Sie eine der folgenden Fortbildungen ein:");
			Fortbildung.druckeAlleFortbildungen();
			Scanner fortb = new Scanner(System.in);
			String fort = fortb.nextLine();
			name = fort;
		}
		return null;
	}

	public String[] getVorraussetzung(Fortbildung pruf) {
		String[] namen = new String[2];
		namen[0] = "";
		namen[1] = "";
		if ((pruf.vorraussetzung[0] == null) && (pruf.vorraussetzung[1] == null)) {
			System.out.println("Keine Voraussetzung");
			return namen;
		}
		for (int i = 0; i < 2; i++) {
			namen[i] = pruf.vorraussetzung[0].titel;
			if (pruf.vorraussetzung[1] == null) {
				return namen;
			} else {
				namen[1] = pruf.vorraussetzung[1].titel;
			}
			// System.out.println("Vorraussetzung: " + namen[i] +
			// pruf.vorraussetzung[i].titel);

		}
		return namen;
	}

	public static boolean hatVorraussetzungen(Fortbildung pruf) {
		if ((pruf.vorraussetzung[0] == null) && (pruf.vorraussetzung[1] == null)) {
			return false;
		}
		return true;
	}

	public boolean getVorraussetzung() {
		return this.istvorraussetzung;
	}

	public static String[] gibAlleFortbildungen() {
		String[] allNames = new String[fortbildungen.size()];
		int it = 0;
		for (Fortbildung all : fortbildungen) {
			allNames[it] = all.getTitel();
			it++;
		}
		return allNames;

	}

	public static boolean kanngeloeschtWerden(SachbearbeiterEK sachB, Fortbildung fort) {
		return true;
	}

}