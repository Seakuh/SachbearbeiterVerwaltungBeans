package src;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "SachbearbeiterS")
@RequestScoped
public class SachbearbeiterS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String benutzername;
	public static String Passwort;
	public static boolean admin;
	public static boolean normal;
	public static String akt;

	public static SachbearbeiterS instance;

	public String start() {
		System.out.println(benutzername);
		System.out.println(Passwort);
		System.out.println(admin);
		System.out.println(normal);
		return "";
	}

	public static SachbearbeiterS getInstance() {
		if (instance == null) {
			instance = new SachbearbeiterS();
		}
		System.out.println("Instance übergeben");
		System.out.println(instance.getBenutzername());
		System.out.println(instance.getPasswort());
		System.out.println(instance.isAdmin());
		System.out.println(instance.isNormal());

		return instance;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return Passwort;
	}

	public void setPasswort(String passwort) {
		this.Passwort = passwort;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		SachbearbeiterS.admin = admin;
	}

	public boolean isNormal() {
		return normal;
	}

	public void setNormal(boolean normal) {
		SachbearbeiterS.normal = normal;
	}

	public static String getBerechtigung() {
		if (normal) {
			return "normal";
		} else {
			return "admin";
		}
	}

	public static void setDefault() {
		benutzername = "";
		Passwort = "";
		admin = false;
		normal = false;

	}

	public static String getAkt() {
		akt = SachbearbeiterEK.gib(benutzername).gibStringfuertextArea(benutzername);
		return akt;
	}

	public static void setAkt(String akt) {
		SachbearbeiterS.akt = akt;
	}



}
