package src;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginK {
	public String kontrolleEingabe(String benutzername, String passwort) {

		System.out.println("in LoginK :)");
		System.out.println(benutzername + "   " + passwort);

		String[] allNames = SachbearbeiterEK.gibAlleNamen();
		for (int i = 0; i < SachbearbeiterEK.gibAnzahl(); i++) {
			if (benutzername.equals(allNames[i])) {
				SachbearbeiterEK kopie = SachbearbeiterEK.gib(allNames[i]);
				System.out.println(kopie.getPasswort());
				if (kopie.getPasswort().equals(passwort)) {
					System.out.println("Eingabe Korrekt");
					if (kopie.getBerechtigung().equals("admin")) {
						if (SachbearbeiterS.admin) {
							return "/AdminAS.xhtml";
						} else if (SachbearbeiterS.normal) {
							return "/SachbearbeiterAS.xhtml";
						} else {
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falsche Eingabe", null);
							FacesContext fc = FacesContext.getCurrentInstance();
							fc.addMessage(null, msg);
							System.out.println("Falsches Passwort");
						}
					}
					if (kopie.getBerechtigung().equals("normal")) {
						return "/SachbearbeiterAS.xhtml";
					}
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falsche Eingabe", null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					System.out.println("Falsches Passwort");
				}
			}
		}
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ungültige Eingabe", null);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, msg);
		return "Login.xhtml";
	}

}