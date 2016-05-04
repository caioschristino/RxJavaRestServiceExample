package com.example.caios.rxjavarestserviceexample.Service;

import com.example.caios.rxjavarestserviceexample.Model.FamousPeople;
import com.example.caios.rxjavarestserviceexample.Model.FamousPeopleResponse;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by caios on 5/4/16.
 */
public interface FamousPeopleService {
    String SERVICE_ENDPOINT = "http://mocky.io";

    @GET("/v2/{mockHost}")
    Observable<FamousPeopleResponse> getUser(@Path("mockHost") String host);
}
