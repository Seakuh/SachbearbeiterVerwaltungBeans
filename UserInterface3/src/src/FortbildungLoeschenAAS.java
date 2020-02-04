package src;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class FortbildungLoeschenAAS {

	public String benutzername;
	public String fortbildung;
	FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();
	public static String nextpage = "";
	
	public String start() {

		fortbildung = FortbildungAuswaehlenComboBox.fortbildung;
		benutzername = SachbearbeiterAuswahl.selectedSachbearbeiter;
		
		kontrolle.loescheFortbildung(benutzername, Fortbildung.gib(fortbildung));
			
	

		return "";
	}

	public String checkstatus() {
		fortbildung = FortbildungAuswaehlenComboBox.fortbildung;
		benutzername = SachbearbeiterAuswahl.selectedSachbearbeiter;

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Status: "
						+ SachbearbeiterEK.getStatus(SachbearbeiterEK.gib(benutzername), Fortbildung.gib(fortbildung)),
				null);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, msg);

		return "";

	}
	
	public String fehlbuchung() {
		fortbildung = FortbildungAuswaehlenComboBox.fortbildung;
		benutzername = SachbearbeiterAuswahl.selectedSachbearbeiter;
		
		kontrolle.loescheFortbildungfehlbuchung(benutzername, Fortbildung.gib(fortbildung));
		
		
		return "";
	}
	
	public String oeffnenAdmin() {
		nextpage = "AdminAS.xhtml?faces-redirect=true";
		return "/FortbildungLoeschenAAS.xhtml?faces-redirect=true";
	}

	public String oeffnenSachbearbeiter() {
		nextpage = "SachbearbeiterAS.xhtml?faces-redirect=true";
		return "/FortbildungLoeschenAAS.xhtml?faces-redirect=true";
	}
	
	public String zurueck() {
		return nextpage;
	}


}
