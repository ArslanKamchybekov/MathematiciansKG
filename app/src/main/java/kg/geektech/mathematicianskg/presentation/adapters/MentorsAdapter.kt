package kg.geektech.mathematicianskg.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.domain.models.MentorsData
import kg.geektech.mathematicianskg.databinding.ItemMentorBinding
import java.util.*
import kotlin.collections.ArrayList

class MentorsAdapter :
    RecyclerView.Adapter<MentorsAdapter.ViewHolder>() {

    private var mentors = ArrayList<MentorsData>()
    var image: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMentorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mentors[position])
        holder.itemView.setOnClickListener {

        }
    }

    fun setData(arrData: List<MentorsData>) {
        mentors = arrData as ArrayList<MentorsData>
    }

    inner class ViewHolder(private val binding: ItemMentorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(mentorsData: MentorsData) {

            binding.tvName.text = mentors[position].name
            binding.tvSchool.text = mentors[position].school
            binding.tvDescription.text = mentors[position].description

            when (mentors[position].name?.lowercase(Locale.getDefault())) {
                "темирлан" -> {
                    image = R.drawable.img_temirlan
                }
                "арслан" -> {
                    image = R.drawable.img_arslan
                }
                "марат" -> {
                    image = R.drawable.img_marat
                }
                "самат" -> {
                    image = R.drawable.img_samat
                }
                "алияр" -> {
                    image = R.drawable.img_aliyar
                }
                "наристе" -> {
                    image = R.drawable.img_nariste
                }
            }
            image?.let { binding.mentorImg.setBackgroundResource(it) }
        }
    }

    override fun getItemCount(): Int {
        return mentors.size
    }
}