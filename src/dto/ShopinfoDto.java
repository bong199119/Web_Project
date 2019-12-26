package dto;

public class ShopinfoDto {
	private String sname;
	private String opertime;
	private String loc;
	private String menu;
	private String thumb;
	private String phone;
	public ShopinfoDto(String sname, String opertime, String loc, String menu, String thumb, String phone) {
		super();
		this.sname = sname;
		this.opertime = opertime;
		this.loc = loc;
		this.menu = menu;
		this.thumb = thumb;
		this.phone = phone;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getOpertime() {
		return opertime;
	}
	public void setOpertime(String opertime) {
		this.opertime = opertime;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ShopinfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
