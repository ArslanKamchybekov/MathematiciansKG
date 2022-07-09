package kg.geektech.mathematicianskg.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.databinding.ItemScienceBinding
import kg.geektech.mathematicianskg.databinding.ItemTechBinding
import kg.geektech.mathematicianskg.domain.models.MainModel
import kg.geektech.mathematicianskg.presentation.callbacks.DiffCallback
import kg.geektech.mathematicianskg.presentation.callbacks.Models

open class NewsAdapter : ListAdapter<Models, RecyclerView.ViewHolder>(DiffCallback()) {

    private var list = mutableListOf<Any>()
    var onItemClickListener: ((Any) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_science -> ScienceViewHolder(
                ItemScienceBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_tech -> TechViewHolder(
                ItemTechBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Unknown view type...")
        }
    }

    fun setList(list: List<Models>) {
        this.list.addAll(list)
        submitList(list)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = getItem(position)
        when (holder) {
            is ScienceViewHolder -> {
                val news = model as MainModel
                holder.onBind(news)
                holder.scienceLayout.setOnClickListener { onItemClickListener?.invoke(news) }
            }
            is TechViewHolder -> {
                val news = model as MainModel
                holder.onBind(news)
                holder.techLayout.setOnClickListener { onItemClickListener?.invoke(news) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {

            is MainModel -> R.layout.item_science

            is MainModel -> R.layout.item_tech

            else -> throw IllegalArgumentException("Unknown view type...")
        }
    }
}

class ScienceViewHolder(private val binding: ItemScienceBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val scienceLayout = binding.scienceLayout
    fun onBind(mainModel: MainModel) {
        binding.tvAuthor.text = mainModel.author
        binding.tvContent.text = mainModel.description
        binding.tvHeading.text = mainModel.title
        Glide.with(itemView).load(mainModel.urlToImage[position])
            .centerCrop().into(binding.ivNews)
    }
}

class TechViewHolder(private val binding: ItemTechBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val techLayout = binding.techLayout
    fun onBind(mainModel: MainModel) {
        binding.tvAuthor.text = mainModel.author
        binding.tvContent.text = mainModel.description
        binding.tvHeading.text = mainModel.title
        Glide.with(itemView).load(mainModel.urlToImage[position])
            .centerCrop().into(binding.ivNews)
    }
}
