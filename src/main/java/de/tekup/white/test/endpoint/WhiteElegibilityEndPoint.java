package de.tekup.white.test.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.white.test.service.WhiteElegibilityService;

@Endpoint
public class WhiteElegibilityEndPoint {

public final static String nameSpace  ="http://www.tekup.de/soap/models/whitetest";
@Autowired
private WhiteElegibilityService service;
@PayloadRoot(namespace = nameSpace , localPart = "StudentRequest")
@ResponsePayload
public WhiteTestResponse checkWhiteTest (@RequestPayload StudentRequest studentRequest) throws DatatypeConfigurationException {
	//call service 
	//return service.getStudentStatus(studentRequest);
	//return null ;
	return  service.getStudentStatus2(studentRequest);
}
}
