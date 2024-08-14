package com.cemilyildirim.fragmentvenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.cemilyildirim.fragmentvenavigation.databinding.FragmentBirinciBinding

class BirinciFragment : Fragment() {

    private var _binding: FragmentBirinciBinding    ? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBirinciBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextText.setText("deneme")
        binding.button.setOnClickListener{
            sonraki(it)
        }
        Toast.makeText(requireContext(),"Hoşgeldiniz", Toast.LENGTH_LONG).show()


    }

    fun sonraki(view: View){
        val isim = binding.editTextText.text.toString()
        val action = BirinciFragmentDirections.actionBirinciFragmentToIkinciFragment(isim)
        Navigation.findNavController(view).navigate(action)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}