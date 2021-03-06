package value;

public class InfoBean {
	
		private String name;
		private String interest;
		private String score;
		private int pageSize;
		
		@Override
		public String toString() {
			return "InfoBean [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize
					+ "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getInterest() {
			return interest;
		}
		public void setInterest(String interest) {
			this.interest = interest;
		}
		public String getScore() {
			return score;
		}
		public void setScore(String score) {
			this.score = score;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
}
