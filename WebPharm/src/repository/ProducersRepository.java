package repository;

import dao.ProducerDAO;
import model.Producer;

public class ProducersRepository {
	
	public static void completeProducersTable(){
		Producer producer = new Producer();
		
		producer.setTitle("Prod");
		producer.setCountry(enums.Country.FRANCE);
		ProducerDAO.add(producer);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("Pr");
		producer.setCountry(enums.Country.ENGLAND);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("SSS");
		producer.setCountry(enums.Country.UKRAINE);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("Shara");
		producer.setCountry(enums.Country.FRANCE);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("Eng");
		producer.setCountry(enums.Country.ENGLAND);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("Ukr");
		producer.setCountry(enums.Country.UKRAINE);
		ProducerDAO.add(producer);
		
		producer = new Producer();
		producer.setTitle("Prod");
		producer.setCountry(enums.Country.UKRAINE);
		ProducerDAO.add(producer);
	}
}
