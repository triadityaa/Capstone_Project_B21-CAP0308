package com.jetpackprosubs.capstone.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jetpackprosubs.capstone.data.Provinsi
import com.jetpackprosubs.capstone.databinding.HolderProvinsiBinding

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
    private var listProv = ArrayList<Provinsi>()

    fun setMovie(provinsi: List<Provinsi>){
        if(provinsi == null) return
        this.listProv.clear()
        this.listProv.addAll(provinsi)
    }

    class DetailViewHolder(private val binding: HolderProvinsiBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(provinsi: Provinsi){
            with(binding){
                nama.text = provinsi.nama
                total.text = StringBuilder("Total Kasus Kekerasan : "+provinsi.total)
                perempuan.text = StringBuilder("Korban Perempuan : "+provinsi.perempuan)
                barPerempuan.max = provinsi.total
                barPerempuan.progress = provinsi.perempuan
                anak.text = StringBuilder("Korban Anak-Anak : "+provinsi.anak)
                barAnak.max = provinsi.total
                barAnak.progress = provinsi.anak
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val holderProvinsiBinding =HolderProvinsiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailViewHolder(holderProvinsiBinding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val provinsi = listProv[position]
        holder.bind(provinsi)
    }

    override fun getItemCount(): Int = listProv.size
}