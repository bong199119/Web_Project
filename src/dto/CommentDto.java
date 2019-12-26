package dto;

public class CommentDto {
	private String id;
	private String comm;
	public CommentDto(String id, String comm) {
		super();
		this.id = id;
		this.comm = comm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
