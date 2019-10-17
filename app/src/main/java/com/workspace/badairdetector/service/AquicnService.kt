package com.workspace.badairdetector.service

import com.workspace.badairdetector.models.Aqi
import retrofit2.Call
import retrofit2.http.GET

interface AquicnService {
    @GET("brazil/?token=23a6e37818c7c3a888add8d787e860b00d05018a")
    fun listarCidade() : Call<Aqi>
}