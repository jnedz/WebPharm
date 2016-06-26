package enums;

public enum PersonRole {

	WORKER(1), USER(2);
	
	private int code;
	
	private PersonRole(int code) {
		this.setCode(code);
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String toString(){
		return name();
	}
}
