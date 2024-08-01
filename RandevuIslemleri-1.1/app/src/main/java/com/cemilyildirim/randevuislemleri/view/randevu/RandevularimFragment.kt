package com.cemilyildirim.randevuislemleri.view.randevu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cemilyildirim.randevuislemleri.databinding.FragmentRandevularimBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandevularimFragment : Fragment() {
    private var _binding: FragmentRandevularimBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandevularimBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}