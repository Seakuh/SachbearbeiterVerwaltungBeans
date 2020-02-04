package src;

import java.util.HashSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class FortbildungAuswaehlenComboBox {
	public static HashSet<String> fortbildungCollectionString = new HashSet<>();
	public static String fortbildung = "------------";

	static {
		for (String f : Fortbildung.gibAlleFortbildungen()) {
			fortbildungCollectionString.add(f);
		}
	}

	public HashSet<String> getFortbildungCollectionString() {
		return fortbildungCollectionString;
	}

	public void setFortbildung(String fortbildung) {
		FortbildungAuswaehlenComboBox.fortbildung = fortbildung;
	}
	
	public String getFortbildung() {
		return fortbildung;
	}
	

	public static void neueListe() {
		fortbildungCollectionString.clear();
		for (String s : Fortbildung.gibAlleFortbildungen()) {
			fortbildungCollectionString.add(s);
		}

	}

}
