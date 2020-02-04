package src;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean

public class SachbearbeiterSachbearbeiterEditierenAAS {
	private String benutzerName;
	private String passwort;
	private SachbearbeiterEK sachbearbeiter;

	private boolean admin;
	private boolean normal;
	private String berechtigung;

	private SachbearbeiterSachbearbeiterEditierenK kontrolle = new SachbearbeiterSachbearbeiterEditierenK();

	public void start() {
		benutzerName = SachbearbeiterS.benutzername;
		passwort = SachbearbeiterS.Passwort;

		admin = SachbearbeiterS.admin;
		normal = SachbearbeiterS.normal;

		System.out.println(benutzerName + passwort + admin + normal);
		sachbearbeiter = SachbearbeiterEK.gib(SachbearbeiterAuswahl.selectedSachbearbeiter);

		if (admin) {
			berechtigung = "admin";
			kontrolle.kontrolliereEingabe(benutzerName, passwort, berechtigung, sachbearbeiter.getBenutzerName());

		} else if (normal) {
			berechtigung = "normal";
			kontrolle.kontrolliereEingabe(benutzerName, passwort, berechtigung, sachbearbeiter.getBenutzerName());

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eingabe Fehlt", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		}

	}

	public String getBenutzerName() {
		return benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public SachbearbeiterEK getSachbearbeiter() {
		return sachbearbeiter;
	}

	public void setSachbearbeiter(SachbearbeiterEK sachbearbeiter) {
		this.sachbearbeiter = sachbearbeiter;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isNormal() {
		return normal;
	}

	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	public String getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(String berechtigung) {
		this.berechtigung = berechtigung;
	}

	public String zurueck() {
		SachbearbeiterS.setDefault();
		SachbearbeiterAuswahl.neueListe();
		return "/SachbearbeiterAS.xhtml";
	}

}
