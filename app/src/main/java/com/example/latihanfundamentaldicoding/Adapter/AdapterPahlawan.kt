package com.example.latihanfundamentaldicoding.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.latihanfundamentaldicoding.Model.Pahlawan
import com.example.latihanfundamentaldicoding.R

/**
 * Created by Indriyantongrh on 12/10/20.
 */
class AdapterPahlawan internal constructor(private val context: Context) : BaseAdapter() {
    internal var pahlawan = arrayListOf<Pahlawan>()
    override fun getCount(): Int {
        return pahlawan.size
    }

    override fun getItem(i: Int): Any {
        return pahlawan[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_pahlawan, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val palawanku = getItem(position) as Pahlawan
        viewHolder.bind(palawanku)
        return itemView

    }

    class ViewHolder(view: View) {
        private val tvName: TextView = view.findViewById(R.id.tvName)
        private val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsi)
        private val ivPahlawan: ImageView = view.findViewById(R.id.ivPahlawan)

        fun bind(palawanku: Pahlawan) {
            tvName.text =palawanku.name
            tvDeskripsi.text =palawanku.description
            ivPahlawan.setImageResource(palawanku.photo)

        }

    }
}