package com.cemilyildirim.randevuislemleri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cemilyildirim.randevuislemleri.modelFatura.ListElement
import com.cemilyildirim.randevuislemleri.databinding.FaturaBilgileriRecyclerRowBinding

class FaturaAdapter(private val listElements: List<ListElement>) : RecyclerView.Adapter<FaturaAdapter.FaturaViewHolder>() {

    class FaturaViewHolder(val binding: FaturaBilgileriRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listElement: ListElement) {
            binding.faturaBasligi.text = listElement.company
            binding.adresBilgisi.text = listElement.address
            binding.tesisatNumarasi.text = listElement.installationNumber
            binding.sozlesmeHesapNumarasi.text = listElement.contractAccountNumber
            binding.guncelBorc.text = "${listElement.amount} ₺"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaturaViewHolder {
        val binding = FaturaBilgileriRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FaturaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FaturaViewHolder, position: Int) {
        holder.bind(listElements[position])
    }

    override fun getItemCount(): Int {
        return listElements.size
    }
}
