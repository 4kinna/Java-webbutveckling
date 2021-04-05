package model;

public class WeatherBean {

	private String cityStr;
	private String countryStr;
	private String cloudsStr;
	private String lastupdateStr;
	private String tempStr;

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public String getLastupdateStr() {
		return lastupdateStr;
	}

	public String getTempStr() {
		return tempStr;
	}

	public void setCloudsStr(String XMLclouds) {
		this.cloudsStr = XMLclouds;
	}
	
	public void setLastupdateStr(String XMLlastupdate) {
		this.lastupdateStr = XMLlastupdate;
	}
	
	public void setTemp(String celsius) {
		this.tempStr = celsius;
	}

}