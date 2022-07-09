package kg.geektech.mathematicianskg.presentation.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.domain.models.CoursesData
import kg.geektech.mathematicianskg.databinding.ItemCourseBinding
import java.util.*

class CoursesAdapter :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    private var courses = ArrayList<CoursesData>()
    var image: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(courses[position])
        holder.itemView.setOnClickListener {
            when (courses[position].name?.lowercase(Locale.getDefault())) {
                "sat math" -> {
                    val intentWhatsapp = Intent(Intent.ACTION_VIEW)
                    val url = "https://chat.whatsapp.com/HD2YJ9rQJGY3Ipq0beo45a"
                    intentWhatsapp.data = Uri.parse(url)
                    intentWhatsapp.setPackage("com.whatsapp")
                    startActivity(holder.itemView.context, intentWhatsapp, null)
                }
                "алгебра/геометрия 9-11" -> {
                    val intentWhatsapp = Intent(Intent.ACTION_VIEW)
                    val url = "https://chat.whatsapp.com/EyjpJHd3yEpEhnivXFnr42"
                    intentWhatsapp.data = Uri.parse(url)
                    intentWhatsapp.setPackage("com.whatsapp")
                    startActivity(holder.itemView.context, intentWhatsapp, null)
                }
                "алгебра/геометрия 5-8" -> {
                    val intentWhatsapp = Intent(Intent.ACTION_VIEW)
                    val url = "https://chat.whatsapp.com/LY9ki6q9eWOI8iTNTtQeXF"
                    intentWhatsapp.data = Uri.parse(url)
                    intentWhatsapp.setPackage("com.whatsapp")
                    startActivity(holder.itemView.context, intentWhatsapp, null)
                }
                "физика" -> {
                    val intentWhatsapp = Intent(Intent.ACTION_VIEW)
                    val url = "https://chat.whatsapp.com/DbDN3iMw9jdBUxWmwTzNXD"
                    intentWhatsapp.data = Uri.parse(url)
                    intentWhatsapp.setPackage("com.whatsapp")
                    startActivity(holder.itemView.context, intentWhatsapp, null)
                }
            }
        }
    }

    fun setData(arrData: List<CoursesData>) {
        courses = arrData as ArrayList<CoursesData>
    }

    inner class ViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(coursesData: CoursesData) {
            binding.tvName.text = courses[position].name
            binding.tvTeacher.text = courses[position].teacher
            binding.tvTime.text = courses[position].time
            binding.tvDescription.text = courses[position].description

            when (courses[position].name?.lowercase(Locale.getDefault())) {
                "sat math" -> {
                    image = R.drawable.img_math0
                }
                "алгебра/геометрия 9-11" -> {
                    image = R.drawable.img_math1
                }
                "алгебра/геометрия 5-8" -> {
                    image = R.drawable.img_math2
                }
                "физика" -> {
                    image = R.drawable.img_physics
                }
            }
            image?.let { binding.mentorImg.setBackgroundResource(it) }
        }
    }

    override fun getItemCount(): Int {
        return courses.size
    }
}