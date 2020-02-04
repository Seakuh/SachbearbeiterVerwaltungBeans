package src;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "AdminSachbearbeiterErzeugenAAS")
@SessionScoped

public class AdminSachbearbeiterErzeugenAAS {

	AdminSachbearbeiterErzeugenK kontrolle = new AdminSachbearbeiterErzeugenK();

	public String start() {
		System.out.println("In SachbearbeiterErzeugen");
		System.out.println(SachbearbeiterS.benutzername + SachbearbeiterS.Passwort + SachbearbeiterS.admin + SachbearbeiterS.normal);
		
		if(SachbearbeiterS.getBerechtigung()==null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eingabe Fehlt", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			return "";
		}
		
		kontrolle.trageNeuenNutzerein(SachbearbeiterS.benutzername,SachbearbeiterS.Passwort, SachbearbeiterS.getBerechtigung());
		SachbearbeiterAuswahl.neueListe();
		SachbearbeiterS.setDefault();

		SachbearbeiterEK.druckeAlleNamen();
		
		return "abbruch";
		
	}

}