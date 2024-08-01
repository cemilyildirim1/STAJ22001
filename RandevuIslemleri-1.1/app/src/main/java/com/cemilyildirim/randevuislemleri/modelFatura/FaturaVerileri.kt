package com.cemilyildirim.randevuislemleri.modelFatura

data class FaturaVerileri(
    val totalPrice: String,
    val totalPriceCount: Long,
    val list: List<ListElement>,
    val invoices: List<Fatura>
)