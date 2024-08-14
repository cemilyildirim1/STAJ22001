package com.cemilyildirim.androidalertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cemilyildirim.androidalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

        //context
        //Aktivite context , app context

        Toast.makeText(this,"Hoşgeldiniz", Toast.LENGTH_LONG).show()

        /*binding.button.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(v: View?) {
                print("buttona tıklandı")
            }
        })*/

    }
    fun kaydet(view : View){
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Kayıt et")
        alert.setMessage("Kayıt etmek istediğinize emin misiniz ?")


//        alert.setPositiveButton("Evet",object : DialogInterface.OnClickListener{
//            override fun onClick(dialog: DialogInterface?, which: Int) {
//                Toast.makeText(this@MainActivity,"Kayıt Edildi", Toast.LENGTH_LONG).show()
//            }
//        })
//
//        alert.setNegativeButton("Hayır",){dialog , which ->
//            Toast.makeText(this,"Kayıt iptal edildi", Toast.LENGTH_LONG).show()
//        }

        alert.show()

    }
}