package com.udacity.gradle.builditbigger.backend;

import com.developer.albyroni.jocklib.Jock;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    //java jock teller library
    Jock jock= new Jock();
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "tellJock")
    public MyBean tellJock() {
        MyBean response = new MyBean();
        response.setData(jock.JockTeller());

        return response;
    }

}
