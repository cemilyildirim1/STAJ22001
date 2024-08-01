package com.cemilyildirim.randevuislemleri.view.randevu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cemilyildirim.randevuislemleri.adapter.RandevuAdapter
import com.cemilyildirim.randevuislemleri.databinding.FragmentRandevuOlusturBinding
import com.cemilyildirim.randevuislemleri.repoPattern.VeriCekme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RandevuOlusturFragment : Fragment() {
    private var _binding: FragmentRandevuOlusturBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var veriCekme: VeriCekme


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandevuOlusturBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randevuOlusturRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch{
            val data = veriCekme.veriCekme()
            val resultObject = data.result.resultObject
            binding.randevuOlusturRecyclerView.adapter = RandevuAdapter(resultObject)

        }


        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}