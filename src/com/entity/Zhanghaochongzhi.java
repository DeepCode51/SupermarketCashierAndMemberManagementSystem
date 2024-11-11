package com.entity;

public class Zhanghaochongzhi {
    private Integer id;
	private String xingming;
	private String shoujihao;
	private String yue;
	private String chongzhijine;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }
	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao == null ? null : shoujihao.trim();
    }
	public String getYue() {
        return yue;
    }
    public void setYue(String yue) {
        this.yue = yue == null ? null : yue.trim();
    }
	public String getChongzhijine() {
        return chongzhijine;
    }
    public void setChongzhijine(String chongzhijine) {
        this.chongzhijine = chongzhijine == null ? null : chongzhijine.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
