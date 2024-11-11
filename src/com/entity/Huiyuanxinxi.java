package com.entity;

public class Huiyuanxinxi {
    private Integer id;
	private String shoujihao;
	private String mima;
	private String xingming;
	private String xingbie;
	private String shenfenzheng;
	private String zhaopian;
	private String jifen;
	private String yue;
	private String beizhu;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao == null ? null : shoujihao.trim();
    }
	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }
	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }
	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng == null ? null : shenfenzheng.trim();
    }
	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian == null ? null : zhaopian.trim();
    }
	public String getJifen() {
        return jifen;
    }
    public void setJifen(String jifen) {
        this.jifen = jifen == null ? null : jifen.trim();
    }
	public String getYue() {
        return yue;
    }
    public void setYue(String yue) {
        this.yue = yue == null ? null : yue.trim();
    }
	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
