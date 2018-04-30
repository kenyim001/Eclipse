package entity;

public class Dt {
	private int id;
	private String dtName;
	private String loc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDtName() {
		return dtName;
	}
	public void setDtName(String dtName) {
		this.dtName = dtName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dt [id=" + id + ", dtName=" + dtName + ", loc=" + loc + "]";
	}
	
	
	
	
	
}
