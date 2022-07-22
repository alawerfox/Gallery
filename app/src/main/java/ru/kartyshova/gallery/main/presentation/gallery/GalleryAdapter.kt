package ru.kartyshova.gallery.main.presentation.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kartyshova.gallery.databinding.MainFragmentBinding
import ru.kartyshova.gallery.main.domain.model.GalleryItem
import ru.kartyshova.gallery.main.viewModel.GalleryImages

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private var gallery: List<GalleryItem> = emptyList()

    fun setItems(values: List<GalleryItem>) {
        gallery = values
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gallery = gallery[position]
        holder.bind(gallery)

    }

    override fun getItemCount(): Int = gallery.size

    class ViewHolder(private val binding: ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gallery: GalleryItem) {

        }
    }
}



