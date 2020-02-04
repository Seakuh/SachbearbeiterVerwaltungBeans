package src;

import java.util.HashSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@RequestScoped
public class SachbearbeiterAuswahl {

	String gebuchteFortbildungen = SachbearbeiterEK.gib(SachbearbeiterAuswahl.selectedSachbearbeiter)
			.gibStringfuertextArea(selectedSachbearbeiter);

	public static HashSet<String> sachbearbeiterCollectionString = new HashSet<>();

	public static String selectedSachbearbeiter = "admin";

	static {
		for (String s : SachbearbeiterEK.gibAlleNamen()) {
			sachbearbeiterCollectionString.add(s);
		}
	}
	

	public String getGebuchteFortbildungen() {
		return gebuchteFortbildungen;
	}

	public HashSet<String> getSachbearbeiterCollectionString() {
		return sachbearbeiterCollectionString;
	}

	public static void setSachbearbeiterCollectionString(HashSet<String> sachbearbeiterCollectionString) {
		SachbearbeiterAuswahl.sachbearbeiterCollectionString = sachbearbeiterCollectionString;
	}

	public String getSachbearbeiter() {
		return selectedSachbearbeiter;
	}

	public void setSachbearbeiter(String sachbearbeiter) {
		selectedSachbearbeiter = sachbearbeiter;
	}

	public static void neueListe() {
		System.out.println(SachbearbeiterEK.gibAlleNamen());
		sachbearbeiterCollectionString.clear();
		for (String s : SachbearbeiterEK.gibAlleNamen()) {
			sachbearbeiterCollectionString.add(s);
		}

	}

	public void valueChangeMethod(ValueChangeEvent e) {
		// assign new value to country
		String hallo = e.getNewValue().toString();
		setGebuchteFortbildungen(hallo);
	}

	public void setGebuchteFortbildungen(String gebuchteFortbildungen) {
		this.gebuchteFortbildungen = SachbearbeiterEK.gib(SachbearbeiterAuswahl.selectedSachbearbeiter)
				.gibStringfuertextArea(selectedSachbearbeiter);
	}

}