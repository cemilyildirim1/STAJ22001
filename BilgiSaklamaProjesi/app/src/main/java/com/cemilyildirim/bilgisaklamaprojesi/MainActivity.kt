package com.cemilyildirim.bilgisaklamaprojesi

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cemilyildirim.bilgisaklamaprojesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var alinanKullaniciAdi : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = this.getSharedPreferences("com.cemilyildirim.bilgisaklamaprojesi",
            Context.MODE_PRIVATE)

        alinanKullaniciAdi = sharedPreferences.getString("isim","")
        if (alinanKullaniciAdi ==""){

        }else{
            binding.textView.text = "Kaydedilen Kullanıcı (kayıt) :${alinanKullaniciAdi}"
        }
    }

    fun kaydet (view : View){
        val kullaniciIsmi = binding.editText.text.toString()
        if (kullaniciIsmi == ""){
            Toast.makeText(this,"İsminizi boş bırakmayınız ", Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.edit().putString("isim",kullaniciIsmi).apply()
            binding.textView.text = "Kaydedilen İsim : ${kullaniciIsmi}"
        }

    }
    fun sil(view: View){
        val kullaniciIsmi = binding.editText.text.toString()
        var isim = sharedPreferences.getString("isim","")
        if(kullaniciIsmi !=""){
            if (kullaniciIsmi ==isim){
                sharedPreferences.edit().remove("isim").apply()
                isim = sharedPreferences.getString("isim","")
                binding.textView.text = "Kaydedilen İsim ${isim}"
                Toast.makeText(this,"İsim başarıyla silindi !!!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Seçilen isim ile kaydedilen isim aynı değil !!!1", Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this,"Lütfen silinecek ismi boş bırakmayınız", Toast.LENGTH_LONG).show()
        }
    }
}