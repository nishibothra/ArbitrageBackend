package com.starter.services;

import com.starter.pojo.FRAData;

public interface FRAService {

	public FRAData calculateGainLossLongBorrow(FRAData data);
	public FRAData calculateGainLossLongLend(FRAData data);
	public FRAData calculateUserInLongLend(FRAData data);
	public FRAData calculateUserInLongBorrow(FRAData data);
}
