package kr.or.ddit.user.model;

public class JSPFileVo {
	
	private String fileid;
	private String postid;
	private String filepath;
	private String filename;
	
	
	public JSPFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public JSPFileVo(String postid, String filepath,
			String filename) {
		super();
	
		this.postid = postid;
		this.filepath = filepath;
		this.filename = filename;
	}
	
	
	@Override
	public String toString() {
		return "JSPFileVo [fileid=" + fileid + ", postid=" + postid
				+ ", filepath=" + filepath + ", filename=" + filename + "]";
	}
	public String getfileid() {
		return fileid;
	}
	public void setFidleid(String fidleid) {
		this.fileid = fidleid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
