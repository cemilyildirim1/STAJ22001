package com.cemilyildirim.randevuislemleri.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cemilyildirim.randevuislemleri.model.ResultObject
import com.cemilyildirim.randevuislemleri.databinding.RandevuIslemleriVerileriRecyclerRowBinding
import com.cemilyildirim.randevuislemleri.view.fatura.MainActivityFatura


class RandevuAdapter(val randevuList: List<ResultObject>): RecyclerView.Adapter<RandevuAdapter.RandevuViewHolder>() {
    class RandevuViewHolder(val binding: RandevuIslemleriVerileriRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(resultObject: ResultObject){
            binding.isim.text = resultObject.value
            //resim yüklemek için glide
            Glide.with(binding.root.context)
                .load(resultObject.image)
                .into(binding.imageView)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandevuViewHolder {
        val binding = RandevuIslemleriVerileriRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandevuViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RandevuViewHolder, position: Int) {
        holder.bind(randevuList[position])
        if (holder.binding.isim.text == "Abonelik"){
            holder.itemView.setOnClickListener(){
                val intent = Intent(holder.binding.isim.context , MainActivityFatura::class.java)
                holder.itemView.context.startActivity(intent)
            }
        }else{
            holder.itemView.setOnClickListener(null)
        }

    }

    override fun getItemCount(): Int {
        return randevuList.size
    }

}