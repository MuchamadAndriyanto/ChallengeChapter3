package com.example.challengechapter3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3.databinding.ItemHurufBinding

class KataAdapter  (private val listKata : ArrayList<ListKata>) :
    RecyclerView.Adapter<KataAdapter.ViewHolder>(){
    class ViewHolder (var binding: ItemHurufBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataAdapter.ViewHolder {
        val binding = ItemHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KataAdapter.ViewHolder, position: Int) {
        val viewKata = listKata[position].kata
        holder.binding.txtHuruf.text = viewKata
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity

                val web = Intent(Intent.ACTION_VIEW)
                web.data = Uri.parse("https://www.google.com/search?q= $viewKata")
                transaction.startActivity(web)
            }

        })
    }

    override fun getItemCount(): Int {
        return listKata.size
    }
}

