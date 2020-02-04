package src;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AdminSachbearbeiterLoeschenK {

	public void getSachbearbeiterNamen() {
		SachbearbeiterEK.druckeAlleNamen();
	}

	public SachbearbeiterEK gibSachbearbeiter(String name) {

		return SachbearbeiterEK.gib(name);
	}

	public void loescheSachbearbeiter(String name1) {
		
		
		SachbearbeiterEK name = SachbearbeiterEK.gib(name1);
		
		if(name1.equals("admin")) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin kann nicht gelöscht werden", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		}else {
		System.out.println(">> " + name.getBenutzerName() + " wurde gelöscht");
		name.delete();
		System.out.println("");
		SachbearbeiterEK.druckeAlleNamen();
		}
	}

}
