package com.example.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.databinding.FragmentHurufBinding

class HurufFragment : Fragment(){
    val list = ArrayList<ListHuruf>()
    lateinit var binding: FragmentHurufBinding
    lateinit var rcvhuruf : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHurufBinding.inflate(layoutInflater, container, false)
        rcvhuruf = binding.rcvHuruf
        rcvhuruf.setHasFixedSize(true)
        listHurufShow()
        binding.rcvHuruf.setOnClickListener {

        }
        return binding.root
    }

    private fun getListHuruf() : ArrayList<ListHuruf> {
        val dataHuruf = resources.getStringArray(R.array.huruf)
        val listHuruf = ArrayList<ListHuruf>()
        for (i in dataHuruf.indices) {
            val abjad = ListHuruf(dataHuruf[i])
            listHuruf.add(abjad)
        }
        return listHuruf
    }

    private fun listHurufShow() {
        rcvhuruf.layoutManager = LinearLayoutManager(context)
        var hurufAdapter = HurufAdapter(list)
        rcvhuruf.adapter = hurufAdapter
        list.clear()
        list.addAll(getListHuruf())
    }

}