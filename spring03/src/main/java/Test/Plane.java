package Test;

public class Plane {
	public Engine getEg() {
		return eg;
	}
	public void setEg(Engine eg) {
		this.eg = eg;
	}
	private Engine eg;
		public Plane(){
			System.out.println("plane()");
		}
		@Override
		public String toString() {
			return "Plane [eg=" + eg + "]";
		}
	
		
}
