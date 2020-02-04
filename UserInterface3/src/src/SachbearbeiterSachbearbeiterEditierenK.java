package src;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

public class SachbearbeiterSachbearbeiterEditierenK {

	public void kontrolliereEingabe(String bn, String pw, String berechtigung, String sachbearbeiter) {

		SachbearbeiterEK bearbeiten = SachbearbeiterEK.gib(sachbearbeiter);
		bearbeiten.setPasswort(pw);
		if (eingabeBenutzername(bn)) {
			bearbeiten.setBenutzername(bn);
			bearbeiten.setBerechtigung("normal");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Als Sachbearbeiter nur Berichtigungsvergabe Sachbearbeiter möglich \n "
					+ "Berechtigung Sachbearbeiter wurde" + bn + "vergeben", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eingabe Ungültig", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		}

		SachbearbeiterAuswahl.neueListe();
		SachbearbeiterS.setDefault();

	}

	public boolean eingabeBenutzername(String eing) {
		boolean b = Pattern.matches("[a-zA-Z_ß]+", eing);
		if (b) {
			return true;
		} else {
			return false;
		}

	}
}
