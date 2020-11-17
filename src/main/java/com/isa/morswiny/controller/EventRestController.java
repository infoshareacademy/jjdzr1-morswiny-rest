package com.isa.morswiny.controller;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventDbLoadService;
import org.apache.http.client.fluent.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/load")
@Consumes(MediaType.APPLICATION_JSON)
public class EventRestController {


    private static final String REST_URL
            = "https://planerkulturalny.pl/api/rest/events.json";

    private Client client = ClientBuilder.newClient();

    @GET
    public Response getJsonEvents() {
        return client
                .target(REST_URL)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }


//
//    public String connect () throws IOException {
//
//        String str= Request.Get("https://planerkulturalny.pl/api/rest/events.json")
//                .connectTimeout(1000)
//                .socketTimeout(1000)
//                .execute().returnContent().asString();
//
//        System.out.println(str);
//
//        return str;
//    }

}
