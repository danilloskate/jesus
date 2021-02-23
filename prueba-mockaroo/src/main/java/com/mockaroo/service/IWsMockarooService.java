package com.mockaroo.service;



import java.util.concurrent.ExecutionException;

import com.mockaroo.dto.RespuestaDto;
import com.mockaroo.exeptions.FailCommunicationException;



public interface IWsMockarooService {
	
	public RespuestaDto getInfoTypes(String key) throws ExecutionException, InterruptedException,FailCommunicationException;

	public Object getCSV(String key); 

}
