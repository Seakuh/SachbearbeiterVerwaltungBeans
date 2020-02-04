package src;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class FortbildungZuweisenAAS {

	public boolean bestanden = false;
	public boolean belegt = false;
	public String benutzername;
	public String fortbildung;
	FortbildungZuweisenK kontrolle = new FortbildungZuweisenK();
	public static String nextpage = "";

	public boolean isBestanden() {
		return bestanden;
	}

	public void setBestanden(boolean bestanden) {
		this.bestanden = bestanden;
	}

	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}

	public FortbildungZuweisenK getKontrolle() {
		return kontrolle;
	}

	public void setKontrolle(FortbildungZuweisenK kontrolle) {
		this.kontrolle = kontrolle;
	}

	public String start() {

		fortbildung = FortbildungAuswaehlenComboBox.fortbildung;
		benutzername = SachbearbeiterAuswahl.selectedSachbearbeiter;

		System.out.println(fortbildung + benutzername + belegt + bestanden);

		if ((bestanden && belegt) || (!bestanden && !belegt)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ungültige Auswahl", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		} else if (bestanden) {

			kontrolle.start(benutzername, fortbildung, "bestanden");

		} else if (belegt) {
			kontrolle.start(benutzername, fortbildung, "belegt");
		}

		FortbildungAuswaehlenComboBox.neueListe();

		return "";

	}

	public String oeffnenAdmin() {
		nextpage = "AdminAS.xhtml?faces-redirect=true";
		return "/FortbildungZuweisenAAS.xhtml?faces-redirect=true";
	}

	public String oeffnenSachbearbeiter() {
		nextpage = "SachbearbeiterAS.xhtml?faces-redirect=true";
		return "/FortbildungZuweisenAAS.xhtml?faces-redirect=true";
	}
	
	public String zurueck() {
		return nextpage;
	}

}
