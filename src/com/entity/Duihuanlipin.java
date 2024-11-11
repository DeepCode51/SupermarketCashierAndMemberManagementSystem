package com.entity;

public class Duihuanlipin {
    private Integer id;
	private String lipinbianhao;
	private String lipinmingcheng;
	private String suoxujifen;
	private String xingming;
	private String shoujihao;
	private String jifen;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getLipinbianhao() {
        return lipinbianhao;
    }
    public void setLipinbianhao(String lipinbianhao) {
        this.lipinbianhao = lipinbianhao == null ? null : lipinbianhao.trim();
    }
	public String getLipinmingcheng() {
        return lipinmingcheng;
    }
    public void setLipinmingcheng(String lipinmingcheng) {
        this.lipinmingcheng = lipinmingcheng == null ? null : lipinmingcheng.trim();
    }
	public String getSuoxujifen() {
        return suoxujifen;
    }
    public void setSuoxujifen(String suoxujifen) {
        this.suoxujifen = suoxujifen == null ? null : suoxujifen.trim();
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
	public String getJifen() {
        return jifen;
    }
    public void setJifen(String jifen) {
        this.jifen = jifen == null ? null : jifen.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
