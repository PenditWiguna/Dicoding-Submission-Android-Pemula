package com.dicoding.mytugas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ListDestinasiAdapter(private val listDestinasi: ArrayList<Destinasi>) :
    RecyclerView.Adapter<ListDestinasiAdapter.ListViewHolder>() {

    private var listener: OnItemClickListener? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_destinasi, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name, description, detailDescription, photo) = listDestinasi[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "kamu kemilih" + listDestinasi[holder.adapterPosition].name,Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            onItemClick(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = listDestinasi.size

    interface OnItemClickListener {
        fun onItemClick(destinasi: Destinasi)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    private fun onItemClick(position: Int) {
        listener?.onItemClick(listDestinasi[position])
    }

}