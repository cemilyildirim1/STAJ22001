package com.cemilyildirim.kullaniciarayuzu
import com.cemilyildirim.kullaniciarayuzu.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

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

        /*binding.textView.text = "Deneme değiştirme (textView-1)"
        binding.button.setOnClickListener(){
            binding.textView.text = "Butona tıklandı !"
        }*/

        /*val image = findViewById<ImageView>(R.id.imageView)
        image.setImageResource(R.drawable.istanbul2)
        val benimTextim = findViewById<TextView>(R.id.textView)
        benimTextim.text = "Merhaba Kotlin Deneme"
        */


    }
    fun kaydet(view :View){
        binding.textView.text = "Kayıt Edildi !"
    }
    fun iptal(view : View){
        binding.textView.text = "İptal Edildi !"
    }
}