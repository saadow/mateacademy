package lesson14_rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import lesson12.HumanResource;
import lesson12.MateGroup;
import lesson12.Person;

@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService {
	private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
			.collect(Collectors.toMap(MateGroup::getId, Function.identity()));

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMateGroup(@PathParam("groupId") int groupId) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			return Response.status(Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudents(@PathParam("groupId") int groupId, Person person) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getStudents().addAll(Arrays.asList(person));
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@DELETE
	@Path("/students/{surname}")
	public Response deleteStudent(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getStudents().removeIf(f -> f.getSurname().equals(surname));
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students/{surname}")
	public Response updateStudent(@PathParam("groupId") int groupId, @PathParam("surname") String surname,
			@QueryParam("newname") String newname) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getStudents().stream().filter((f -> f.getSurname().equals(surname))).collect(Collectors.toList())
					.forEach(f -> f.setName(newname));
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/hrs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addHR(@PathParam("groupId") int groupId, HumanResource hr) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getHumanResources().add(hr);
			return Response.status(Status.OK).entity(mateGroups.get(groupId).getHumanResources())
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@DELETE
	@Path("/hrs/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteHR(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getHumanResources().removeIf(f -> f.getSurname().equals(surname));
			return Response.status(Status.OK).entity(mateGroups.get(groupId).getHumanResources())
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/hrs/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStartWorkYearHR(@PathParam("groupId") int groupId, @PathParam("surname") String surname,
			@QueryParam("newStartWorkYear") int newStartWorkYear) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getHumanResources().stream().filter((f -> f.getSurname().equals(surname)))
					.collect(Collectors.toList()).forEach(f -> f.setStartWorkYear(newStartWorkYear));
			return Response.status(Status.OK).entity(mateGroups.get(groupId).getHumanResources())
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@GET
	@Path("/hrs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAllHRs(@PathParam("groupId") int groupId) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			return Response.status(Status.OK).entity(mateGroups.get(groupId).getHumanResources())
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@GET
	@Path("/hrs/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showSingleHR(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			return Response.status(Status.OK)
					.entity(mateGroups.get(groupId).getHumanResources().stream()
							.filter(hr -> hr.getSurname().equals(surname)).collect(Collectors.toList()))
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
