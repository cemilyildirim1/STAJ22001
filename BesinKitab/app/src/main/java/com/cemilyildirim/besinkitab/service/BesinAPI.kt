package com.cemilyildirim.besinkitab.service

import com.cemilyildirim.besinkitab.model.Besin
import retrofit2.http.GET

interface BesinAPI {

    //BASE URL -> https://raw.githubusercontent.com/
    //END POINT -> atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    suspend fun getBesin() : List<Besin>
}