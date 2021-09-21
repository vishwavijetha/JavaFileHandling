package filehandling;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

// POJO Class
public class CarPOJO {

	private String company;
	private String name;
	private String variant;
	private String color;
	private int makeYear;
	private int onRoadPrice;
	private String[] dealers;

	@Beanc(properties = "company, name, variant, color, makeYear, onRoadPrice, dealers")
	public CarPOJO(String company, String name, String variant, String color, int makeYear, int onRoadPrice,
			String[] dealers) {
		this.company = company;
		this.name = name;
		this.variant = variant;
		this.color = color;
		this.makeYear = makeYear;
		this.onRoadPrice = onRoadPrice;
		this.dealers = dealers;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public int getOnRoadPrice() {
		return onRoadPrice;
	}

	public void setOnRoadPrice(int onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

	public String[] getDealers() {
		return dealers;
	}

	public void setDealers(String[] dealers) {
		this.dealers = dealers;
	}

	@Override
	public String toString() {
		return "CarPOJO [company=" + company + ", name=" + name + ", variant=" + variant + ", color=" + color
				+ ", makeYear=" + makeYear + ", onRoadPrice=" + onRoadPrice + ", dealers=" + Arrays.toString(dealers)
				+ "]";
	}
}
