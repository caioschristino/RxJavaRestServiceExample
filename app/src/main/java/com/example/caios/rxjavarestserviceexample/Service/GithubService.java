package com.example.caios.rxjavarestserviceexample.Service;


import com.example.caios.rxjavarestserviceexample.Model.Github;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
/**
 * Created by caios on 5/3/16.
 */

public interface GithubService {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<Github> getUser(@Path("login") String login);
}