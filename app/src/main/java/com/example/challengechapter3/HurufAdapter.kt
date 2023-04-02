package com.example.challengechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.databinding.ItemHurufBinding

class HurufAdapter (private  var listHuruf: ArrayList<ListHuruf>) :
    RecyclerView.Adapter<HurufAdapter.ViewHolder>(){
    class ViewHolder (var binding : ItemHurufBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ItemHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHuruf = listHuruf[position].huruf
        holder.binding.txtHuruf.text = viewHuruf
//
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Huruf", viewHuruf)
            Navigation.findNavController(it).navigate(R.id.action_hurufFragment_to_detailFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return listHuruf.size
    }
}