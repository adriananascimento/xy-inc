package com.br.zup.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import com.br.zup.dto.ModelDTO;
import com.br.zup.service.ModelService;

/**
 * Controller of model.
 * @author adriana.nascimento
 *
 */
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class ModelController {

	@Inject
	private ModelService modelService;

	@GET
	@Path("/models")
	public String listModels() throws Exception {
		return "teste";
	}

	/**
	 * REST to add a new Model
	 * @param modelDTO
	 * @return Response OK or BAD_REQUEST
	 * @throws Exception
	 */
	@POST
	@Path("/addNewModel")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewModel(ModelDTO modelDTO) throws Exception {
		try {
			modelService.addModel(modelDTO);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	/**
	 * REST to return all objects of model
	 * @param model
	 * @return Response OK or BAD_REQUEST with List<Object>
	 */
	@Path("/{model}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllObjs(@PathParam("model") String model) {
		try {
			List<Object> result = modelService.getAllObjs(model);
			return Response.status(Response.Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * REST to return a object of model
	 * @param model
	 * @param id
	 * @return Response OK or BAD_REQUEST with Object
	 */
	@Path("/{model}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjById(@PathParam("model") String model, @PathParam("id") String id) {
		try {
			Object result = modelService.getObjById(model, id);
			return Response.status(Response.Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * REST to add a object to model
	 * @param model
	 * @param json
	 * @return Response OK or BAD_REQUEST
	 */
	@Path("/{model}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addObj(@PathParam("model") String model, JSONObject json) {
		try {
			modelService.addObj(model, json);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * REST to update a object of model
	 * @param model
	 * @param id
	 * @param json
	 * @return Response OK or BAD_REQUEST
	 */
	@Path("/{model}/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateObj(@PathParam("model") String model, @PathParam("id") String id, JSONObject json) {
		try {
			modelService.updateObj(model, id, json);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * REST to remove a object of model
	 * @param model
	 * @param id
	 * @return Response OK or BAD_REQUEST
	 */
	@DELETE
	@Path("/{model}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeObj(@PathParam("model") String model, @PathParam("id") String id ) {
		try {
			modelService.removeObj(model, id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
