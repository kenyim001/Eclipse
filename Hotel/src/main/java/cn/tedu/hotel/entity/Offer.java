package cn.tedu.hotel.entity;

public class Offer {
	private String roomStyle;
	private String bedStyle;
	private double originalPrice;
	private String description;
	private String url;
	
	public Offer() {
		
	}

	public Offer(String roomStyle, String bedStyle, double originalPrice, String description, String url) {
		super();
		this.roomStyle = roomStyle;
		this.bedStyle = bedStyle;
		this.originalPrice = originalPrice;
		this.description = description;
		this.url = url;
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public String getBedStyle() {
		return bedStyle;
	}

	public void setBedStyle(String bedStyle) {
		this.bedStyle = bedStyle;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Offers [roomStyle=" + roomStyle + ", bedStyle=" + bedStyle + ", originalPrice=" + originalPrice
				+ ", description=" + description + ", url=" + url + "]";
	}
	
}
