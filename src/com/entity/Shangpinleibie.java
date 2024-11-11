package com.entity;

public class Shangpinleibie {
    private Integer id;
	private String leibie;
	private String shuoming;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getShuoming() {
        return shuoming;
    }
    public void setShuoming(String shuoming) {
        this.shuoming = shuoming == null ? null : shuoming.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
