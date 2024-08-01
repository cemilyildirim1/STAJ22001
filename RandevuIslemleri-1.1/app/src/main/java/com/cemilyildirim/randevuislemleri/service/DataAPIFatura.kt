package com.cemilyildirim.randevuislemleri.view.service

import com.cemilyildirim.randevuislemleri.modelFatura.FaturaVerileri
import retrofit2.http.GET


interface DataAPIFatura {

    //BASE URL -> https://raw.githubusercontent.com/
    //END POİNT -> bydevelopertr/versionproject/master/invoice.json

    @GET("bydevelopertr/versionproject/master/invoice.json")
    suspend fun getDataFatura() : FaturaVerileri

}
