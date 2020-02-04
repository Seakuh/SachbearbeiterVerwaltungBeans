package src;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AdminSachbearbeiterLoeschenAAS {

	AdminSachbearbeiterLoeschenK kontrolle = new AdminSachbearbeiterLoeschenK();

	public String start() {

		kontrolle.loescheSachbearbeiter(SachbearbeiterAuswahl.selectedSachbearbeiter);
		SachbearbeiterAuswahl.neueListe();
		return "/AdminAS.xhtml";
	}
}
