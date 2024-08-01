package com.cemilyildirim.randevuislemleri.view.fatura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cemilyildirim.randevuislemleri.R
import com.cemilyildirim.randevuislemleri.adapter.FaturaAdapter
import com.cemilyildirim.randevuislemleri.databinding.FragmentFaturaListesiBinding
import com.cemilyildirim.randevuislemleri.repoPattern.VeriCekmeFatura
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FaturaListesiFragment : Fragment() {
    private var _binding: FragmentFaturaListesiBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var veriCekmeFatura : VeriCekmeFatura


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaturaListesiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.faturaRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch{
            val data = veriCekmeFatura.veriCekmeFatura()
            val listElements = data.list
            binding.faturaRecyclerView.adapter = FaturaAdapter(listElements)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}