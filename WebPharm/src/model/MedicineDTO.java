package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import enums.MedicineType;

public class MedicineDTO {

	private long id;
	private String title = "";
	private MedicineType type;
	private GregorianCalendar dateOfManufact;
	private int term;
	private double price;
	private int count;
	 private String producerTitle;
	 
	 public String getProducerTitle() {
		return producerTitle;
	}

	public void setProducerTitle(String producerTitle) {
		this.producerTitle = producerTitle;
	}

	 
	//private int producerId;

	/*public int getProducerId() {
		return producerId;
	}

	public void setProducerId(int producer_id) {
		this.producerId = producer_id;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MedicineType getType() {
		return type;
	}

	public void setType(MedicineType type) {
		this.type = type;
	}

	public GregorianCalendar getDateOfManufact() {
		return dateOfManufact;
	}

	public void setDateOfManufact(GregorianCalendar dateOfManufact) {
		this.dateOfManufact = dateOfManufact;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDateOfManufactInString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(getDateOfManufact().getTime());
		return date;
	}

	@Override
	public String toString() {

		return "\nId: " + getId() + "; Title: " + getTitle() + "; type: "
				+ getType().name() + "; dateOfManufact: "
				+ getDateOfManufactInString() + "; term: " + getTerm()
				+ "; price: " + getPrice() + "; count: " + getCount()
				+ ", " + getProducerTitle();
	}
}
