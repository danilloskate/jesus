package com.mockaroo.controller;



import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockaroo.dto.RespuestaDto;
import com.mockaroo.service.IWsMockarooService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/")
public class WsMockarooController {
	@Autowired
	private IWsMockarooService service;
	
	
	@GetMapping(value = "/api/types")
	@ApiOperation(value ="Obtener informacion de mockaro", notes ="Retorna una estructura con informacion", response = RespuestaDto.class)
	@ApiResponses(value = {@ApiResponse(code = 200, response = RespuestaDto.class, message = "OK"), @ApiResponse(code = 404, response = RespuestaDto.class, message = "Not found")})
	public ResponseEntity<?> getInfoMockaroor(@RequestParam(required = true) String key) throws ExecutionException, InterruptedException {
			return ResponseEntity.ok(service.getInfoTypes(key));
	}
	
	@GetMapping(value = "/api/types")
	@ApiOperation(value ="Obtener informacion de csv", notes ="Retorna una estructura con informacion", response = RespuestaDto.class)
	@ApiResponses(value = {@ApiResponse(code = 200, response = RespuestaDto.class, message = "OK"), @ApiResponse(code = 404, response = RespuestaDto.class, message = "Not found")})
	public ResponseEntity<?> getCsv(@RequestParam(required = true) String key) throws ExecutionException, InterruptedException {
			return ResponseEntity.ok(service.getCSV(key));
	}

}
