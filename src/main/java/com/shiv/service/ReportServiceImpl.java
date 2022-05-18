package com.shiv.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.shiv.entity.EligibilityDetailsEntity;
import com.shiv.repository.EligDtlsRepository;
import com.shiv.request.SearchRequest;
import com.shiv.response.SearchResponse;
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EligDtlsRepository eligDtlsRepository;

	@Override
	public List<String> getPlanNames() {
		
		return eligDtlsRepository.getUniquePlans();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return eligDtlsRepository.getUniqueStatus();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest searchRequest) {
		List<EligibilityDetailsEntity> eligRecords=null; 
			if(searchRequest==null)
			{
				eligRecords = eligDtlsRepository.findAll();
			}
			else
			{
				String planName = searchRequest.getPlanName();
				String planStatus = searchRequest.getPlanStatus();
				LocalDate startDate = searchRequest.getStartDate();
				LocalDate endDate = searchRequest.getEndDate();
				EligibilityDetailsEntity entity=new EligibilityDetailsEntity();
				
				if(planName!=null && !planName.equals(""))
				{
					entity.setPlanName(planName);
				}
				if(planStatus!=null && !planStatus.equals(""))
				{
					entity.setPlanStatus(planStatus);
				}
			
				if(startDate!=null && endDate!=null)
				{
					entity.setStartDate(startDate);
					entity.setEndDate(endDate);
				}
				
				Example<EligibilityDetailsEntity> of = Example.of(entity);
				eligRecords= eligDtlsRepository.findAll(of);
				
			}
			
		List<SearchResponse> response = new ArrayList<>();
			for(EligibilityDetailsEntity eligRecord:eligRecords)
			{
				SearchResponse sr=new SearchResponse();
				BeanUtils.copyProperties(eligRecord, sr);
				response.add(sr);
				
		
	}
			return response;
			
			
	}
}
