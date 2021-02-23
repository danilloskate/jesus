package com.mockaroo.domain;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockaroo.dto.RespuestaDto;
import com.mockaroo.exeptions.FailCommunicationException;
import com.mockaroo.service.IWsMockarooService;

@Service
public class WsMockarooService implements IWsMockarooService {

	@Autowired
	WsClientMockaroo ws;

	private static final Logger log = LoggerFactory.getLogger(WsMockarooService.class);

	@Override
	public RespuestaDto getInfoTypes(String key)
			throws ExecutionException, InterruptedException, FailCommunicationException {
		// TODO Auto-generated method stub

		RespuestaDto responseDto = new RespuestaDto();

		try {
			
			responseDto = ws.obtenerTypes(key);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("clase = WsSubscribersService, metodo = getInfoSubscriber ");
			throw new FailCommunicationException("Problemas de comunicación del servicio");

		}

		return responseDto;
	}

	@Override
	public Object getCSV(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
