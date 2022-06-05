package com.example.movieappviewbindingandcache.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappviewbindingandcache.Class.MovieClass
import com.example.movieappviewbindingandcache.R

class MovieAdapter(
    var movieList: List<MovieClass>,
    var onMyItemClickListener: OnMyItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    inner class MyViewHolder(var item: View) : RecyclerView.ViewHolder(item) {

        fun onBind(movieClass: MovieClass, position: Int) {

            item.findViewById<TextView>(R.id.titleId).text = movieClass.title
            item.findViewById<TextView>(R.id.subtitleId).text = movieClass.subtitle
            item.findViewById<TextView>(R.id.dateId).text = movieClass.date

            item.setOnClickListener {
                onMyItemClickListener.itemClick(movieClass)
            }

            item.findViewById<Button>(R.id.editButton).setOnClickListener {
                onMyItemClickListener.itemClickChange(movieClass, position)
            }

            item.findViewById<Button>(R.id.deleteButton).setOnClickListener {
                onMyItemClickListener.itemClickDelete(movieClass, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val movieClass = movieList[position]
        holder.onBind(movieClass, position)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    interface OnMyItemClickListener {

        fun itemClick(movieClass: MovieClass)
        fun itemClickChange(movieClass: MovieClass, position: Int)
        fun itemClickDelete(movieClass: MovieClass, position: Int)

    }

}