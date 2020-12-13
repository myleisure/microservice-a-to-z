package com.andry.client.adapter;

import com.andry.client.application.model.UserQueryModel;
import com.andry.common.model.User;
import com.andry.common.model.UserBuilder;
import com.andry.domain.application.exception.UserNotFoundException;
import com.andry.domain.port.in.UserServicePort;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResourceAdapter {

    private final UserServicePort userService;

    public UserResourceAdapter(UserServicePort userService) {
        this.userService = userService;
    }

    @GET
    public List<User> getAll() {
        return this.userService.getAllUsers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@BeanParam UserQueryModel userQueryModel) throws URISyntaxException {
        final var newUser = this.userService.add(new UserBuilder()
                .setEmail(userQueryModel.getEmail())
                .setFirstName(userQueryModel.getFirstName())
                .setLastName(userQueryModel.getLastName())
                .createUser());
        return Response.created(new URI("/users")).entity(newUser).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) throws UserNotFoundException {
        this.userService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
