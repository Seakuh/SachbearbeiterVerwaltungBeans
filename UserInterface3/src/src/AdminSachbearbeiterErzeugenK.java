package src;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

public class AdminSachbearbeiterErzeugenK {
	
	

	public boolean vergeben(String neu) {
		String[] all = SachbearbeiterEK.gibAlleNamen();
		for (int i = 0; i < all.length; i++) {
			if (neu.equals(all[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean eingabeBenutzername(String eing) {
		boolean b = Pattern.matches("[a-zA-Z_ß]+", eing);
		if (b) {
			return true;
		} else {
			return false;
		}

	}

	public void trageNeuenNutzerein(String benutzername , String passwort, String berechtigung) {
		System.out.println("Neuen Benutzer eingeben " + benutzername + passwort + berechtigung);
		System.out.println(vergeben(benutzername));
		System.out.println(eingabeBenutzername(benutzername));
		if((!vergeben(benutzername)) && (eingabeBenutzername(benutzername) && (!passwort.equals("")))) {
			SachbearbeiterEK neu = new SachbearbeiterEK(benutzername,passwort,berechtigung);
			neu.add();
		}else {
			System.out.println("Falsche Eingabe oder bereits Vergeben");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falsche Eingabe oder bereits Vergeben", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		}
	}
}