package com.example.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    val list = ArrayList<ListKata>()
    lateinit var binding: FragmentDetailBinding
    lateinit var rcvkata : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        val argumen= this.arguments
        val data = argumen?.get("Huruf")

        binding.txtStart.text = "Word That Start With $data"
        rcvkata = binding.rcvKata
        rcvkata.setHasFixedSize(true)
        listKataShow()

        return binding.root
    }

    private fun getKata() : ArrayList<ListKata> {
        val argument = this.arguments
        val data = argument?.get("Huruf")

        val kata = resources.getStringArray(R.array.detail)

        val listKata = ArrayList<ListKata> ()
        for (i in kata.indices) {
            val kataPertama = kata[i].take(1)
            if(kataPertama == data) {
                val kata = ListKata(kata[i])
                listKata.add(kata)
            }
        }
        return listKata
    }

    private fun listKataShow() {
        rcvkata.layoutManager = LinearLayoutManager(context)
        val listAdapter = KataAdapter(list)
        rcvkata.adapter = listAdapter
        list.clear()
        list.addAll(getKata())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gambar = binding.imgBack
        val kembali = HurufFragment()
        gambar.setOnClickListener {
            setCurrentFragment(kembali)
        }
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }

}
