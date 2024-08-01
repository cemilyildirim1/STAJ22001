package com.cemilyildirim.randevuislemleri.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cemilyildirim.randevuislemleri.view.randevu.RandevuOlusturFragment
import com.cemilyildirim.randevuislemleri.view.randevu.RandevularimFragment

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2 // iki sekme var
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> RandevularimFragment()
            1-> RandevuOlusturFragment()
            else -> throw IllegalArgumentException("beklenmeyen pozisyon ${position}")
        }
    }

}