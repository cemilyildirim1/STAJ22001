package com.cemilyildirim.randevuislemleri.view.randevu

import android.annotation.SuppressLint
import com.cemilyildirim.randevuislemleri.R
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.cemilyildirim.randevuislemleri.adapter.ViewPagerAdapter
import com.cemilyildirim.randevuislemleri.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binding'i başlat
        binding = ActivityMainBinding.inflate(layoutInflater)
        // View'i set et
        setContentView(binding.root)
        enableEdgeToEdge()
        // ViewCompat ile pencere kenarlıklarını ayarla
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        setupViewPagerAndTabs()
    }

    private fun setupViewPagerAndTabs(){
        val viewPager : ViewPager2 = binding.viewPager
        val tabLayout : TabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Randevularım"
                1 -> "Randevu Oluştur"
                else -> null
            }
        }.attach()
    }
}
