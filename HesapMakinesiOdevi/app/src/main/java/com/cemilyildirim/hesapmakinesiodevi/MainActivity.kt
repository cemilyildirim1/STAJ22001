package com.cemilyildirim.hesapmakinesiodevi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cemilyildirim.hesapmakinesiodevi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


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
    }
    fun topla (view : View){
        val birinciDeger  = binding.editText1.text.toString()
        val ikinciDeger   = binding.editText2.text.toString()
        if(birinciDeger == "" || ikinciDeger == ""){
            Toast.makeText(this,"Lütfen boşlukları doldurunuz!", Toast.LENGTH_LONG).show()
        }else{
            val birinciDegerF = birinciDeger.toFloat()
            val ikinciDegerF  = ikinciDeger.toFloat()
            val sonuc : Float = birinciDegerF+ikinciDegerF
            binding.textView.text = "Sonuc ${sonuc}"
        }

    }

    fun cikart (view : View){
        val birinciDeger  = binding.editText1.text.toString()
        val ikinciDeger   = binding.editText2.text.toString()
        if(birinciDeger == "" || ikinciDeger == ""){
            Toast.makeText(this,"Lütfen boşlukları doldurunuz!", Toast.LENGTH_LONG).show()
        }else{
            val birinciDegerF = birinciDeger.toFloat()
            val ikinciDegerF  = ikinciDeger.toFloat()
            val sonuc : Float = birinciDegerF - ikinciDegerF
            binding.textView.text = "Sonuc ${sonuc}"
        }

    }

    fun carp (view : View){
        val birinciDeger  = binding.editText1.text.toString()
        val ikinciDeger   = binding.editText2.text.toString()
        if(birinciDeger == "" || ikinciDeger == ""){
            Toast.makeText(this,"Lütfen boşlukları doldurunuz!", Toast.LENGTH_LONG).show()
        }else{
            val birinciDegerF = birinciDeger.toFloat()
            val ikinciDegerF  = ikinciDeger.toFloat()
            val sonuc : Float = birinciDegerF*ikinciDegerF
            binding.textView.text = "Sonuc ${sonuc}"
        }

    }

    fun bol (view : View){
        val birinciDeger  = binding.editText1.text.toString()
        val ikinciDeger   = binding.editText2.text.toString()
        if(birinciDeger == "" || ikinciDeger == ""){
            Toast.makeText(this,"Lütfen boşlukları doldurunuz!", Toast.LENGTH_LONG).show()
        }else{
            val birinciDegerF = birinciDeger.toFloat()
            val ikinciDegerF  = ikinciDeger.toFloat()
            val sonuc : Float = birinciDegerF/ikinciDegerF
            binding.textView.text = "Sonuc ${sonuc}"
        }

    }


}