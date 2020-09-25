package com.pojo;

public class result_fx {
	private String result;
	private double fx_p_l;
	private String choice;
	
	public result_fx(String result, double fx_p_l, String choice) {
		super();
		this.result = result;
		this.fx_p_l = fx_p_l;
		this.choice = choice;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public double getFx_p_l() {
		return fx_p_l;
	}
	public void setFx_p_l(double fx_p_l) {
		this.fx_p_l = fx_p_l;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
	
}
