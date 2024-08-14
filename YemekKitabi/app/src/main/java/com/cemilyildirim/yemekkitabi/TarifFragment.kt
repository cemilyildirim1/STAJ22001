package com.cemilyildirim.yemekkitabi
    
import android.Manifest
    import android.content.Intent
    import android.content.pm.PackageManager
    import android.graphics.Bitmap
    import android.graphics.ImageDecoder
    import android.net.Uri
    import android.os.Build
    import android.os.Bundle
    import android.provider.MediaStore
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Toast
    import androidx.activity.result.ActivityResultLauncher
    import androidx.activity.result.contract.ActivityResultContracts
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.app.ActivityCompat
    import androidx.core.content.ContextCompat
    import androidx.fragment.app.Fragment
    import com.cemilyildirim.yemekkitabi.databinding.FragmentTarifBinding
    import com.google.android.material.snackbar.Snackbar
    import kotlin.let


class TarifFragment : Fragment() {
        private var _binding: FragmentTarifBinding? = null
        private val binding get() = _binding!!
        private lateinit var permissionLauncher: ActivityResultLauncher<String>
        private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
        private var secilenGorsel: Uri?=null
        private var secilenBitmap: Bitmap?=null
    
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            registerLauncher()
        }
    
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentTarifBinding.inflate(inflater, container, false)
            val view = binding.root
            return view
        }
    
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.kaydetButton.setOnClickListener(){kaydet(it)}
            binding.silButton.setOnClickListener(){sil(it)}
            binding.imageView.setOnClickListener(){gorselSec(it)}
    
            arguments?.let {
                val bilgi = TarifFragmentArgs.fromBundle(it).bilgi
    
                if (bilgi == "yeni"){
                    //yeni bilgi eklenecek
                    binding.silButton.isEnabled = false
                    binding.kaydetButton.isEnabled = true
                    binding.isimText.setText("")
                    binding.tarifText.setText("")
                }else{
                    //eski tarif gösterilecek
                    binding.silButton.isEnabled = true
                    binding.kaydetButton.isEnabled = false
                }
            }
    
        }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
        fun kaydet(view: View){
            val isim = binding.isimText.text.toString()
            val malzeme = binding.tarifText.text.toString()

    
        }
        fun sil(view: View){
    
        }
        fun gorselSec(view: View){
    
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_MEDIA_IMAGES)){
                        //snackbar göstermemiz lazım , kullanıcıdan neden izin istediğimizi bir kez daha söylememiz lazım
                        Snackbar.make(view,"Galeriye uaşıp görsel seçmemiz lazım!", Snackbar.LENGTH_INDEFINITE).setAction(
                            "İzin ver",
                            View.OnClickListener{
                                //izin isteyeceğiz
                                permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
                            }
                        ).show()
                    }else{
                        //izin isteyeceğiz
                        permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
    
                    }
                }else{
                    //izin verilmiş , galeriye girebilir
                    val intentToGallery =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                }
    
            }else{
                if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)){
                        //snackbar göstermemiz lazım , kullanıcıdan neden izin istediğimizi bir kez daha söylememiz lazım
                        Snackbar.make(view,"Galeriye uaşıp görsel seçmemiz lazım!", Snackbar.LENGTH_INDEFINITE).setAction(
                            "İzin ver",
                            View.OnClickListener{
                                //izin isteyeceğiz
                                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                            }
                        ).show()
                    }else{
                        //izin isteyeceğiz
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    
                    }
                }else{
                    //izin verilmiş , galeriye girebilir
                    val intentToGallery =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                }
    
            }
    
    
    
        }
        private fun registerLauncher(){
    
            activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
                if(result.resultCode == AppCompatActivity.RESULT_OK){
                    val intentFromResult = result.data
                    if(intentFromResult != null){
                        secilenGorsel = intentFromResult.data
    
                        try {
                            if(Build.VERSION.SDK_INT >= 28){
                                val source = ImageDecoder.createSource(requireActivity().contentResolver,secilenGorsel!!)
                                secilenBitmap = ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(secilenBitmap)
                            }else{
                                secilenBitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver,secilenGorsel)
                                binding.imageView.setImageBitmap(secilenBitmap)
                            }
                        }catch (e: Exception){
                            print(e.localizedMessage)
                        }
    
                    }
                }
            }
            permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ result->
                if(result == false){
                        //izin verildi
                        //galeriye girebiliriz
                        val intentToGallery =
                            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                        activityResultLauncher.launch(intentToGallery)
                }else{
                //izin verilmedi
                Toast.makeText(requireContext(),"İzin verilmedi!", Toast.LENGTH_LONG).show()
                }
            }
    
        }
    
    }