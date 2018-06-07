package com.udacity.gradle.builditbigger.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.backend.MyBean;
import javax.inject.Named;

import pl.mrodkiewicz.jokegenerator.JokeMain;


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


    @ApiMethod(name = "getJoke")
    public MyBean getJoke(){
        MyBean response = new MyBean();
        JokeMain jokeMain = new JokeMain();
        response.setData(jokeMain.getJoke());
        return response;
    }

}