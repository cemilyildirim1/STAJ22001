package com.cemilyildirim.randevuislemleri.modelFatura

data class Fatura(
    val legacyContractAccountNumber: String,
    val installationNumber: String,
    val documentNumber: String,
    val amount: String,
    val currency: String,
    val dueDate: String
)
