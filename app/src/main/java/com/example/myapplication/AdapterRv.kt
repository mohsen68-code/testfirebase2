package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRv(val product: List<product>): RecyclerView.Adapter<HeroProduct>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroProduct {

        return HeroProduct(LayoutInflater.from(parent.context).inflate(R.layout.lay_custom_rv,parent,false))

    }

    override fun onBindViewHolder(holder: HeroProduct, position: Int) {

        holder.bindHero(product[position])
    }

    override fun getItemCount(): Int{
    return product.size
    }


}

class HeroProduct(view:View):RecyclerView.ViewHolder(view) {

    private val txtname=view.findViewById<TextView>(R.id.txt_name)
    private val img=view.findViewById<ImageView>(R.id.img)
    fun bindHero(product: product) {
        txtname.setText(product.name)
        img.setImageResource(product.img)
    }

}
