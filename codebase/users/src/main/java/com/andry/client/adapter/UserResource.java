package com.andry.client.adapter;

import com.andry.client.application.model.UserQueryModel;
import com.andry.domain.application.model.UserBuilder;
import com.andry.domain.port.in.UserServicePort;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserServicePort userService;

    public UserResource(UserServicePort userService) {
        this.userService = userService;
    }

    @GET
    public Response getAll() {
        return Response.ok(this.userService.getAllUsers()).build();
    }

    @GET
    @Path("/email/{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        return Response.ok(this.userService.getUserByEmail(email)).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {
        return Response.ok(this.userService.getUserById(id)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createUser(@BeanParam UserQueryModel user) {
        final var createdUser = this.userService.addUser(new UserBuilder()
                .setLastName(user.getLastname())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstname())
                .createUser());
        return Response.created(URI.create("/users"))
                .entity(createdUser)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") String userId, @BeanParam UserQueryModel user) {
        final var modifiedUser = new UserBuilder()
                .setId(userId)
                .setLastName(user.getLastname())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstname())
                .createUser();
        return Response.ok(modifiedUser).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id") String userId) {
        this.userService.deleteUser(userId);
        return Response.noContent().build();
    }
}
