package kg.geektech.mathematicianskg.presentation.callbacks

import androidx.recyclerview.widget.DiffUtil
import kg.geektech.mathematicianskg.domain.models.MainModel

interface Models {
    override fun equals(other: Any?): Boolean
}

class DiffCallback : DiffUtil.ItemCallback<Models>() {
    override fun areItemsTheSame(oldItem: Models, newItem: Models): Boolean {
        return when {
            oldItem is MainModel && newItem is MainModel -> {
                oldItem.id == newItem.id
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: Models, newItem: Models): Boolean {
        return when {
            oldItem is MainModel && newItem is MainModel -> {
                oldItem == newItem
            }
            else -> false
        }
    }

}