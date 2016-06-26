package utils;

import java.util.ArrayList;
import java.util.List;

import dao.MedicineDAO;
import dao.ProducerDAO;
import model.Medicine;
import model.Producer;

public class TitlesDTO {
	

	public static List<String> titles () {
		List<String> titles = new ArrayList<>();
		for (Medicine m: MedicineDAO.getAll()) {
			if(titles.contains(m.getTitle())){
			}else{
			titles.add(m.getTitle());
			}
		}
		return titles;
	}
	
	public static List<String> producersTitles () {
		List<String> titles = new ArrayList<>();
		for (Producer p: ProducerDAO.getAll()) {
			if(!(titles.contains(p.getTitle()))){
				titles.add(p.getTitle());
			}
		}
		return titles;
	}
	

}
