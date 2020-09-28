package com.services;

import com.pojo.Data;

public interface FRAService {

	public Data calculateGainLossLongBorrow(Data data);
	public Data calculateGainLossLongLend(Data data);
	public Data calculateUserInLongLend(Data data);
	public Data calculateUserInLongBorrow(Data data);
}
