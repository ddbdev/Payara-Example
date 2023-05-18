package it.ddbdev.demo.controller;

import it.ddbdev.demo.Annotations.Interceptable;
import it.ddbdev.demo.dto.request.AccountRequest;
import it.ddbdev.demo.entity.Account;
import it.ddbdev.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/project")
public class AccountController {

    @Inject
    private UserService userService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Interceptable
    public Response addUser(AccountRequest request){

        if (!userService.findByUsername(request.getUsername()))
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .entity("Username already found. Try again.")
                    .build();

        Account account = new Account(request.getUsername(), request.getPassword());
        userService.save(account);

        return Response.ok("User Created").build();
    }

    @GET
    @Path("/all")
    @Interceptable
    public List<Account> get(){
        System.out.println("Method get invokeds");
        return userService.findAllAccount();
    }

    @GET
    @Path("/{id}")
    public Response getAccountById(@PathParam("id") Long id){
        return Response.ok(userService.findAccountById(id)).build();
    }
}
