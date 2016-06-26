package utils;

import java.util.ArrayList;
import java.util.List;

import dao.ProducerDAO;
import model.Medicine;
import model.MedicineDTO;

public class DTOIntoMedicine {

	public static List<Medicine> convert(List<MedicineDTO> medicinesDTO){
		List<Medicine> medicines= new ArrayList<>();
		Medicine med = new Medicine();
		
		for (MedicineDTO medDTO : medicinesDTO) {
			med = new Medicine();
			med.setId(medDTO.getId());
			med.setTitle(medDTO.getTitle());
			med.setType(medDTO.getType());
			med.setDateOfManufact(medDTO.getDateOfManufact());
			med.setTerm(medDTO.getTerm());
			med.setPrice(medDTO.getPrice());
			med.setCount(medDTO.getCount());
			med.setProducer(ProducerDAO.getProducerByTitle(medDTO.getProducerTitle())); // ??? getProducerByTitle(String title) - Do we need this method???
			medicines.add(med);
		}
		return medicines;
	}
}
