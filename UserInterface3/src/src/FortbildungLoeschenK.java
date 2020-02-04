package src;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FortbildungLoeschenK {

	public void loescheFortbildung(String sachbearbeiter, Fortbildung fortbildung) {

		SachbearbeiterEK vorUb = SachbearbeiterEK.gib(sachbearbeiter);

		if (fortbildung.getVorraussetzung()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Nicht möglich: Fortbildung ist vorraussetzung für eine andere", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fortbildung wurde gelöscht", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			SachbearbeiterEK.loescheFortbildung(vorUb, fortbildung);
			SachbearbeiterAuswahl.neueListe();


			fc.addMessage(null, msg);
		}

	}

	
	public void loescheFortbildungfehlbuchung(String sachbearbeiter, Fortbildung fortbildung) {
		SachbearbeiterEK vorUb = SachbearbeiterEK.gib(sachbearbeiter);
		SachbearbeiterEK.loescheFortbildungFehlbuchung(vorUb, fortbildung);
		SachbearbeiterAuswahl.neueListe();
		SachbearbeiterEK.druckeAlleFortbildungenVonAktuellemSachbearbeiter(vorUb);
		
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fortbildung wurde gelöscht", null);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, msg);
	}

}
