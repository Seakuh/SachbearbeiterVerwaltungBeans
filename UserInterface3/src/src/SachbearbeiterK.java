package src;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class SachbearbeiterK {

	public SachbearbeiterEK eingabeKontrolle(String bN, String pw) {
		SachbearbeiterEK falscheEingabe = new SachbearbeiterEK("Falsche Eingabe", "Falsche Eingabe", "Falsche Eingabe");

		String[] allNames = SachbearbeiterEK.gibAlleNamen();
		for (int i = 0; i < SachbearbeiterEK.gibAnzahl(); i++) {
			if (bN.equals(allNames[i])) {
				SachbearbeiterEK kopie = SachbearbeiterEK.gib(allNames[i]);
				if (kopie.getPasswort().equals(pw)) {
					return kopie;
				} else {
					System.out.println("Falsches Passwort");
				}
			}

		}

		return falscheEingabe;
	}

	public SachbearbeiterEK gibSachbearbeiter(String name) {
		return SachbearbeiterEK.getSachbearbeiter(name);
	}

	public void setStatusFortbildung(String a, String berechtigung) {
		SachbearbeiterEK b = SachbearbeiterEK.gib(a);
		if (b.hatFortbuldungen(b)) {
			System.out.println("Welche Fortbildung soll verändert werden?");
			SachbearbeiterEK.druckeAlleFortbildungenVonAktuellemSachbearbeiter(b);

			Scanner auswahl = new Scanner(System.in);
			String c = auswahl.nextLine();
			Fortbildung fort = Fortbildung.gib(c);
			System.out.println("Welchen Status soll die Fortbildung bekommen?");
			System.out.println("1: Bestanden");
			System.out.println("2: Belegt");
			Scanner aw = new Scanner(System.in);
			int d = aw.nextInt();
			if (d == 1) {
				b.setStatus(b, fort, "Bestanden");
				b.druckeAlleFortbildungenVonAktuellemSachbearbeiter(b);

			} else if (d == 2) {
				b.setStatus(b, fort, "Belegt");
				b.druckeAlleFortbildungenVonAktuellemSachbearbeiter(b);
			} else {
				System.out.println("Falsche Auswahl");
			}
		} else {
			System.out.println(">> Der Sachbearbeiter besucht keine Fortbildunegn");
		}
	}

	public static void setBerechtigung(String name) {

	}

	public static void fortbildungzuordnen(String sachbearbeiter, String fortbildung, String status) {

		System.out.println("In Forbildugzuorden");
		if (sachbearbeiter == null || fortbildung == null) {
			JOptionPane.showMessageDialog(null, "Es muss ein Sachbearbeiter und Fortbildung ausgewählt sein", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			SachbearbeiterEK zuweisung = SachbearbeiterEK.gib(sachbearbeiter);
			Fortbildung fortB = Fortbildung.gib(fortbildung);

			boolean belegt = SachbearbeiterEK.fortbildungBelegt(zuweisung, fortB);
			boolean hatvorraussetzung = Fortbildung.hatVorraussetzungen(fortB);
			boolean vorraussetzungenErfüllt = SachbearbeiterEK.pruefeVorraussetzung(zuweisung, fortB);

			System.out.println(belegt);
			System.out.println(hatvorraussetzung);
			System.out.println(vorraussetzungenErfüllt);

			if (!belegt && !hatvorraussetzung) {

				zuweisung.bucheFortbildung(fortB);
				JOptionPane.showMessageDialog(null, "Fortbildung zugewiesen", "Zuweisung",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println(
						">>Fortbildung: " + fortB.getTitel() + " wurde " + zuweisung.getBenutzerName() + " zugewiesen");
				SachbearbeiterEK.druckeFortbildungenStatus(zuweisung);
			} else if (!belegt && vorraussetzungenErfüllt) {
				System.out.println(">>Darf Teilnehmen");
				zuweisung.bucheFortbildung(fortB);
				System.out.println(
						">>Fortbildung: " + fortB.getTitel() + " wurde " + zuweisung.getBenutzerName() + " zugewiesen");
			} else if (belegt) {
				zuweisung.setStatus(zuweisung, fortB, "Bestanden");
				JOptionPane.showMessageDialog(null, "Fortbildung Status geändert", "Zuweisung",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Nicht möglich");
				JOptionPane.showMessageDialog(null, "Nicht Möglich", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

	}

}