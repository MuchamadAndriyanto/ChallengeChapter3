package com.example.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.databinding.FragmentHurufBinding

class HurufFragment : Fragment() {
    val list = ArrayList<ListHuruf>()
    lateinit var binding: FragmentHurufBinding
    lateinit var rchuruf : RecyclerView
    //latevar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHurufBinding.inflate(layoutInflater, container, false)
        rchuruf = binding.rcvHuruf
        rchuruf.setHasFixedSize(true)
        listHurufShow()
        binding.rcvHuruf.setOnClickListener {

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcvHuruf.setOnClickListener{
            findNavController().navigate(R.id.action_hurufFragment_to_detailFragment)
        }
    }

    private fun getListHuruf() : ArrayList<ListHuruf> {
        val dataNama = resources.getStringArray(R.array.huruf)
        val listAbjad = ArrayList<ListHuruf>()
        for (i in dataNama.indices) {
            val abjad = ListHuruf(dataNama[i])
            listAbjad.add(abjad)
        }
        return listAbjad
    }

    private fun listHurufShow() {
        rchuruf.layoutManager =LinearLayoutManager(context)
        var hurufAdapter = HurufAdapter(list)
        rchuruf.adapter = hurufAdapter
        list.clear()
        list.addAll(getListHuruf())
    }

}
