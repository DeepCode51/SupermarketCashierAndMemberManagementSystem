package com.entity;

public class Lipinxinxi {
    private Integer id;
	private String lipintupian;
	private String lipinbianhao;
	private String lipinmingcheng;
	private String suoxujifen;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getLipintupian() {
        return lipintupian;
    }
    public void setLipintupian(String lipintupian) {
        this.lipintupian = lipintupian == null ? null : lipintupian.trim();
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
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
