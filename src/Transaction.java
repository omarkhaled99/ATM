
public class Transaction {
	private String type;
	private double value;
	public Transaction() {
		type = "\0";
		value = 0.0;
	}
	public Transaction(String type,double value) {
		this.type = type;
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return type+"\n"+String.valueOf(value);
	}
	
}
