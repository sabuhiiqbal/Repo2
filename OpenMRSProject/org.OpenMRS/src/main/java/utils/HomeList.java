package utils;

public class HomeList {
	private String homeListName;
	private String homeListLink;

	public HomeList(String homeListName,String homeListLink) {
		this.homeListLink = homeListLink;
		this.homeListName = homeListName;
	}

	public String getHomeListName() {
		return homeListName;
	}
	public void setHomeListName(String homeListName) {
		this.homeListName = homeListName;
	}
	public String getHomeListLink() {
		return homeListLink;
	}
	public void setHomeListLink(String homeListLink) {
		this.homeListLink = homeListLink;
	}

}
