package com.shiv.service;

import java.util.List;

import com.shiv.request.SearchRequest;
import com.shiv.response.SearchResponse;

public interface ReportService {

	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<SearchResponse> searchPlans(SearchRequest searchRequest);
	
	/*
	 * public void exportExcel(List<>)
	 * 
	 */
	
}
