package com.cemilyildirim.randevuislemleri.view.fatura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cemilyildirim.randevuislemleri.databinding.FragmentFaturaDetayiBinding

class FaturaDetayiFragment : Fragment() {
    private var _binding: FragmentFaturaDetayiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaturaDetayiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Verileri al
        val args = FaturaDetayiFragmentArgs.fromBundle(requireArguments())
        binding.faturaBasligi.text = args.company
        binding.adresBilgisi.text = args.address
        binding.tesisatNumarasi.text = args.installationNumber
        binding.sozlesmeHesapNumarasi.text = args.contractAccountNumber
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
