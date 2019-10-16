package com.example.hp.nonstop.api;

import com.example.hp.nonstop.Model.Example;
import com.example.hp.nonstop.Model.SubPath;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
@GET("paths")
    Call<List<Example>> getExample();


}
