package enums;

public enum Country {

	UKRAINE(1), ENGLAND(2), FRANCE(3), NOCOUNTRY (4);
	private int code;
	private Country(int code) {
		this.setCode(code);
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
