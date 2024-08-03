package com.cemilyildirim.randevuislemleri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cemilyildirim.randevuislemleri.databinding.FaturaBilgileriRecyclerRowBinding
import com.cemilyildirim.randevuislemleri.modelFatura.ListElement

class FaturaAdapter(
    private val listElements: List<ListElement>,
    private val onItemClicked: (ListElement) -> Unit,
    private val onButtonClicked: (ListElement) -> Unit
) : RecyclerView.Adapter<FaturaAdapter.FaturaViewHolder>() {

    inner class FaturaViewHolder(val binding: FaturaBilgileriRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listElement: ListElement) {
            binding.faturaBasligi.text = listElement.company
            binding.adresBilgisi.text = listElement.address
            binding.tesisatNumarasi.text = listElement.installationNumber
            binding.sozlesmeHesapNumarasi.text = listElement.contractAccountNumber
            binding.guncelBorc.text = "${listElement.amount} ₺"

            // Tıklama olayını ayarlama
            binding.root.setOnClickListener {
                onItemClicked(listElement)
            }

            // Buton tıklama olayını ayarlama
            binding.buttonGoruntule.setOnClickListener {
                onButtonClicked(listElement)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaturaViewHolder {
        val binding = FaturaBilgileriRecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FaturaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FaturaViewHolder, position: Int) {
        holder.bind(listElements[position])
    }

    override fun getItemCount(): Int {
        return listElements.size
    }
}
