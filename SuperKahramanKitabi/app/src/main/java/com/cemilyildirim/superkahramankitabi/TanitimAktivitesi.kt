package com.cemilyildirim.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cemilyildirim.superkahramankitabi.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {
    lateinit var binding: ActivityTanitimAktivitesiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        var adapterdenGelenIntent = intent
//        val secilenKahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman", SuperKahraman::class.java) //yeni sürümler için
//        val secilenKahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman") as SuperKahraman           // eski sürümler için
          val secilenKahraman = MySingleton.secilenSuperKahraman

        secilenKahraman?.let {
            binding.imageView.setImageResource(secilenKahraman.gorsel)
            binding.isimTextView.text = secilenKahraman.isim
            binding.meslekTextView.text = secilenKahraman.meslek }
    }
}