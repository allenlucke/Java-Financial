package main.java.com.Allen.Financial.services;

import javax.ws.rs.Path;

import javax.ws.rs.POST;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.Allen.Financial.bean.Income;
import main.java.com.Allen.Financial.bean.JsonConverter;
import main.java.com.Allen.Financial.dao.CallPostIncomeDAO;
//import jdk.internal.org.xml.sax.SAXException;

@Path( "/AddIncome" )
public class AddIncome {

	public static final String CLASS_NAME = AddIncome.class.getSimpleName();
	
	//REST service to add income
	@POST
	@Path("services/AddIncome")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postIncome(@Context HttpServletRequest request) throws ServletException, IOException, NamingException, 
			SQLException, JsonMappingException /*SAXException*/{
		
	    
		final String methodName = "postIncome()";
		
		//Checks to ensure request is valid JSON
		if( !request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON)) {
			return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).build();
		}
		
		String requestBdyJson;
		
		String responseJSON;

//		List <Income> response;
		
		try {
			//Creates request body out of request input stream
			requestBdyJson = JsonConverter.toString(request.getInputStream(), "UTF-8");
			
			//Maps JSON object to java Income POJO
			ObjectMapper mapper = new ObjectMapper();
			Income requestPojo = mapper.readValue(requestBdyJson, Income.class);
			
			//Calls to POST method sending Income POJO
			CallPostIncomeDAO dao = new CallPostIncomeDAO(); 
			//Returns resultList from callPostIncome
			List<Income> resultList = dao.callPostIncome(requestPojo);
			

			responseJSON = mapper.writeValueAsString(resultList);
		}
		catch( Exception e ) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		
		return Response.status( Response.Status.OK ).entity(responseJSON).build();
	}
	
}
