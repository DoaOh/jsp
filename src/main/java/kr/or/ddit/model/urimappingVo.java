package kr.or.ddit.model;

public class urimappingVo {
	
	private String uri;
	private String classname;
	
	public urimappingVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public urimappingVo(String uri, String classname) {
		super();
		this.uri = uri;
		this.classname = classname;
	}
	
	@Override
	public String toString() {
		return "urimappingVo [uri=" + uri + ", classname=" + classname + "]";
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getClassname() {
		return classname;
	}
	
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	

}
