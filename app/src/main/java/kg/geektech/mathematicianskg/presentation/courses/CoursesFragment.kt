package kg.geektech.mathematicianskg.presentation.courses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.data.local.SetData
import kg.geektech.mathematicianskg.databinding.FragmentCoursesBinding
import kg.geektech.mathematicianskg.presentation.adapters.CoursesAdapter

@AndroidEntryPoint
class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private val binding: FragmentCoursesBinding by viewBinding()
    private val viewModel: CoursesViewModel by viewModels()
    private val coursesAdapter by lazy { (CoursesAdapter()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }

    private fun initRv() {
        coursesAdapter.setData(SetData.setCourses())
        binding.rvCourses.adapter = coursesAdapter
    }
}