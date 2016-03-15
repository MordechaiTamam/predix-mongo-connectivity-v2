package com.ge.predix.solsvc.training.alarmservice;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class HospitalAlarmService {
	private static final Log logger = LogFactory.getLog(HospitalAlarmService.class);

	@RequestMapping(value = "/connectToMongo",method = RequestMethod.GET)
	public List<String> connect(@RequestParam("host") String host,@RequestParam("port") Integer port) throws UnknownHostException {
		MongoClient retVal = new MongoClient(host, port);
		List<String> databaseNames = retVal.getDatabaseNames();
		logger.info("retVal.getDatabaseNames: "+ databaseNames);
		return databaseNames;
	}

	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public String sendGetHttpRequest(@RequestParam("uri")String uri){
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response=template.getForEntity(uri,String.class);
		logger.info(response.getBody());
		return response.getBody();
	}
}
