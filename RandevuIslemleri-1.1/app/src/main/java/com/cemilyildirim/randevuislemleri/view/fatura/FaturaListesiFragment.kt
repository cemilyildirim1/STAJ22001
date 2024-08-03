package com.cemilyildirim.randevuislemleri.view.fatura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cemilyildirim.randevuislemleri.R
import com.cemilyildirim.randevuislemleri.adapter.FaturaAdapter
import com.cemilyildirim.randevuislemleri.databinding.FragmentFaturaListesiBinding
import com.cemilyildirim.randevuislemleri.modelFatura.FaturaVerileri
import com.cemilyildirim.randevuislemleri.repoPattern.VeriCekmeFatura
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FaturaListesiFragment : Fragment() {
    private var _binding: FragmentFaturaListesiBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var veriCekmeFatura: VeriCekmeFatura

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaturaListesiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.faturaRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            val data = veriCekmeFatura.veriCekmeFatura()
            val listElements = data.list
            binding.faturaRecyclerView.adapter = FaturaAdapter(
                listElements,
                { selectedItem ->
                    // RecyclerView öğesine tıklama işlemi
                },
                { selectedItem ->
                    val action = FaturaListesiFragmentDirections.actionFaturaListesiFragmentToFaturaDetayiFragment(
                        company = selectedItem.company,
                        address = selectedItem.address,
                        installationNumber = selectedItem.installationNumber,
                        contractAccountNumber = selectedItem.contractAccountNumber,
                        amount = selectedItem.amount
                    )
                    findNavController().navigate(action)
                }
            )
        }

        lifecycleScope.launch {
            val data = veriCekmeFatura.veriCekmeFatura()

            binding.odenmemisToplamBorc.text = toplamBorc(data)
            binding.odenmemisFatura.text = odenmemisFaturaSayisi(data)
        }
    }

    fun toplamBorc(x: FaturaVerileri): String {
        var borcSayisi = x.totalPriceCount.toInt() - 1
        var toplamBorc: Double = 0.0

        while (borcSayisi >= 0) {
            val borc = x.list[borcSayisi].amount.replace(".", "").replace(",", ".").toDouble()
            toplamBorc += borc
            borcSayisi -= 1
        }

        return String.format("%.2f ₺", toplamBorc)
    }

    fun odenmemisFaturaSayisi(x: FaturaVerileri): String {
        val borcSayisi = x.totalPriceCount.toInt()
        return "Tüm sözleşme hesaplarınıza ait %s adet ödenmemiş fatura bulunmaktadır.".format(borcSayisi)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
