package src;

import java.io.IOException;

import java.io.Serializable;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//



@ManagedBean(name = "loginAS")
@SessionScoped
public class LoginAS extends SachbearbeiterK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String benutzerName;
	private String passwort;

	private boolean admin;
	private boolean sachbearbeiter;

	private static LoginAS instance;
	private LoginK kontrolle = new LoginK();

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isSachbearbeiter() {
		return sachbearbeiter;
	}

	public void setSachbearbeiter(boolean sachbearbeiter) {
		this.sachbearbeiter = sachbearbeiter;
	}

	public static LoginAS getInstance() {
		if (instance == null) {
			instance = new LoginAS();
		}
		return instance;
	}

	public String start() throws IOException {
		
		String nextpage = null;
		String bn = SachbearbeiterS.benutzername;
		String pw = SachbearbeiterS.Passwort;
		boolean ad = SachbearbeiterS.admin;
		boolean sa = SachbearbeiterS.normal;

		System.out.println(bn);
		System.out.println(pw);
		System.out.println(sa + "   " + ad);

		if (bn.equals("") || pw.equals("")) {
			System.out.println("Fehlende Eingabe");

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eingabe Fehlt", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			

		} else if ((!ad) && (!sa)) {
			System.out.println("Keine Berechtigung");

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung Fehlt", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		} else {

			nextpage = kontrolle.kontrolleEingabe(bn, pw);
			SachbearbeiterS.setDefault();


		}
		return nextpage;

	}

}
