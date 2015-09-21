package com.pridet.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pridet.ElasticSearch.ElasticSearchUtil;
import com.pridet.bo.BaseBO;
import com.pridet.bo.SearchBO;
import com.pridet.services.IServices;

@Service("SearchServices")
public class SearchServices implements IServices{
	
	public List<SearchBO> search(String query){
		
		SearchBO searchBO = new SearchBO();
		searchBO.setQueryString(query);
		ElasticSearchUtil esu = new ElasticSearchUtil();
		return esu.fullTextSearch(searchBO);
	}

	@Override
	public BaseBO saveBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> saveBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO updateBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> updateBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO deleteBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> deleteBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO getBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> getBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

}
