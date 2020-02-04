package src;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "AdminSachbearbeiterEditierenAAS")
@RequestScoped
public class AdminSachbearbeiterEditierenAAS {

	private String benutzerName;
	private String passwort;
	private SachbearbeiterEK sachbearbeiter;

	private boolean admin;
	private boolean normal;
	private String berechtigung;

	private AdminSachbearbeiterEditierenK kontrolle = new AdminSachbearbeiterEditierenK();

	public String start() {

		
		benutzerName = SachbearbeiterS.benutzername;
		passwort = SachbearbeiterS.Passwort;

		admin = SachbearbeiterS.admin;
		normal = SachbearbeiterS.normal;

		System.out.println(benutzerName + passwort + admin + normal);
		sachbearbeiter = SachbearbeiterEK.gib(SachbearbeiterAuswahl.selectedSachbearbeiter);

		if (admin) {
			SachbearbeiterS.setDefault();
			SachbearbeiterAuswahl.neueListe();
			berechtigung = "admin";
			kontrolle.kontrolliereEingabe(benutzerName, passwort, berechtigung, sachbearbeiter.getBenutzerName());

		} else if (normal) {
			SachbearbeiterS.setDefault();
			SachbearbeiterAuswahl.neueListe();
			berechtigung = "normal";
			kontrolle.kontrolliereEingabe(benutzerName, passwort, berechtigung, sachbearbeiter.getBenutzerName());

		} else {
			SachbearbeiterS.setDefault();
			SachbearbeiterAuswahl.neueListe();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eingabe Fehlt", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		}
		
		
		SachbearbeiterS.setDefault();
		SachbearbeiterAuswahl.neueListe();

		return "/AdminAS.xhtml";

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

	public AdminSachbearbeiterEditierenK getKontrolle() {
		return kontrolle;
	}

	public void setKontrolle(AdminSachbearbeiterEditierenK kontrolle) {
		this.kontrolle = kontrolle;
	}

	public String zurueck() {
		SachbearbeiterS.setDefault();
		SachbearbeiterAuswahl.neueListe();
		return "AdminAS.xhtml";
	}

}
