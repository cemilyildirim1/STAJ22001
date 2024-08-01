package com.cemilyildirim.randevuislemleri.repoPattern

import com.cemilyildirim.randevuislemleri.modelFatura.FaturaVerileri
import com.cemilyildirim.randevuislemleri.view.service.DataAPIFatura
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VeriCekmeFatura @Inject constructor(
    private val dataAPIFatura : DataAPIFatura
) {
    suspend fun veriCekmeFatura(): FaturaVerileri{
        return withContext(Dispatchers.IO){
            dataAPIFatura.getDataFatura()
        }
    }
}