package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExampleBean {
	private List<String> interset;
	private Set<String> city;
	private Map<String,Double> score;
	private Properties db;
	
	public ExampleBean(){
		System.out.println("ExampleBean()");
	}

	public List<String> getInterset() {
		return interset;
	}

	public void setInterset(List<String> interset) {
		this.interset = interset;
	}

	public Set<String> getCity() {
		return city;
	}

	public void setCity(Set<String> city) {
		this.city = city;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public void setScore(Map<String, Double> score) {
		this.score = score;
	}

	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		this.db = db;
	}

	@Override
	public String toString() {
		return "ExampleBean [interset=" + interset + ", city=" + city + ", score=" + score + ", db=" + db + "]";
	}
	
	
}
