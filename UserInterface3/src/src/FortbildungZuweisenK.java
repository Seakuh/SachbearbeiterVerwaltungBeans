package src;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FortbildungZuweisenK {

	public void start(String sachbearbeiter, String fortbildung, String status) {

		SachbearbeiterEK zuweisung = SachbearbeiterEK.gib(sachbearbeiter);
		Fortbildung fortB = Fortbildung.gib(fortbildung);

		boolean belegt = SachbearbeiterEK.fortbildungBelegt(zuweisung, fortB);
		boolean hatvorraussetzung = Fortbildung.hatVorraussetzungen(fortB);
		boolean vorraussetzungenErfüllt = SachbearbeiterEK.pruefeVorraussetzung(zuweisung, fortB);

		System.out.println(belegt);
		System.out.println(hatvorraussetzung);
		System.out.println(vorraussetzungenErfüllt);

		if (status.equals("bestanden") && (!belegt)) {
			zuweisung.bucheFortbildung(fortB);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fortbildung muss erst belegt werden",
					null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		} else if (!belegt && !hatvorraussetzung) {

			zuweisung.bucheFortbildung(fortB);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fortbildung wurde zugewiesen", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			System.out.println(
					">>Fortbildung: " + fortB.getTitel() + " wurde " + zuweisung.getBenutzerName() + " zugewiesen");
			SachbearbeiterEK.druckeFortbildungenStatus(zuweisung);
		} else if (!belegt && vorraussetzungenErfüllt) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wurde zugewiesen", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		} else if (belegt) {
			zuweisung.setStatus(zuweisung, fortB, "bestanden");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Geändert", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nicht möglich", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

		}

	}

}
