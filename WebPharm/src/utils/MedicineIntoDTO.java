package utils;

import java.util.ArrayList;
import java.util.List;

import model.Medicine;
import model.MedicineDTO;

public class MedicineIntoDTO {

	public static List<MedicineDTO> convert(List<Medicine> medicines){
	List<MedicineDTO> medicinesDTO= new ArrayList<>();
	MedicineDTO medDTO = new MedicineDTO();
	
	for (Medicine med : medicines) {
		medDTO = new MedicineDTO();
		medDTO.setId(med.getId());
		medDTO.setTitle(med.getTitle());
		medDTO.setType(med.getType());
		medDTO.setDateOfManufact(med.getDateOfManufact());
		medDTO.setTerm(med.getTerm());
		medDTO.setPrice(med.getPrice());
		medDTO.setCount(med.getCount());
		medDTO.setProducerTitle(med.getProducer().getTitle());
		medicinesDTO.add(medDTO);
	}
	return medicinesDTO;
}
}