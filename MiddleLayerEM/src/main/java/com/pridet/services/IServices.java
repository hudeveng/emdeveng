package com.pridet.services;

import java.util.List;

import com.pridet.bo.BaseBO;

public interface IServices {

	public BaseBO saveBeanDetails(BaseBO basebo);

	public List<BaseBO> saveBeanDetails(List<BaseBO> basebo);

	public BaseBO updateBeanDetails(BaseBO basebo);

	public List<BaseBO> updateBeanDetails(List<BaseBO> basebo);

	public BaseBO deleteBeanDetails(BaseBO basebo);

	public List<BaseBO> deleteBeanDetails(List<BaseBO> basebo);

	public BaseBO getBeanDetails(BaseBO basebo);

	public List<BaseBO> getBeanDetails(List<BaseBO> basebo);
	
}
