package com.community.fo.mybatis.vo;

public class SampleVo {
	
	private String ST_NUM;
	private String ST_NM;
	private String ST_PO;
	private String ST_DP;
	private String ST_TEL;
	private String ST_BIR;
	private String St_ST;
	
	
	public String getST_NUM() {
		return ST_NUM;
	}
	public void setST_NUM(String sT_NUM) {
		ST_NUM = sT_NUM;
	}
	public String getST_NM() {
		return ST_NM;
	}
	public void setST_NM(String sT_NM) {
		ST_NM = sT_NM;
	}
	public String getST_PO() {
		return ST_PO;
	}
	public void setST_PO(String sT_PO) {
		ST_PO = sT_PO;
	}
	public String getST_DP() {
		return ST_DP;
	}
	public void setST_DP(String sT_DP) {
		ST_DP = sT_DP;
	}
	public String getST_TEL() {
		return ST_TEL;
	}
	public void setST_TEL(String sT_TEL) {
		ST_TEL = sT_TEL;
	}
	public String getST_BIR() {
		return ST_BIR;
	}
	public void setST_BIR(String sT_BIR) {
		ST_BIR = sT_BIR;
	}
	public String getSt_ST() {
		return St_ST;
	}
	public void setSt_ST(String st_ST) {
		St_ST = st_ST;
	}
	public SampleVo(String sT_NUM, String sT_NM, String sT_PO, String sT_DP, String sT_TEL, String sT_BIR, String st_ST) {
		super();
		ST_NUM = sT_NUM;
		ST_NM = sT_NM;
		ST_PO = sT_PO;
		ST_DP = sT_DP;
		ST_TEL = sT_TEL;
		ST_BIR = sT_BIR;
		St_ST = st_ST;
	}
	@Override
	public String toString() {
		return "SampleVo [ST_NUM=" + ST_NUM + ", ST_NM=" + ST_NM + ", ST_PO=" + ST_PO + ", ST_DP=" + ST_DP + ", ST_TEL="
				+ ST_TEL + ", ST_BIR=" + ST_BIR + ", St_ST=" + St_ST + "]";
	}
	
	
	
}
