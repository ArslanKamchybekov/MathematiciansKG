package kg.geektech.mathematicianskg.presentation.about_us

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.data.local.SetData
import kg.geektech.mathematicianskg.databinding.FragmentAboutUsBinding
import kg.geektech.mathematicianskg.presentation.adapters.MentorsAdapter

@AndroidEntryPoint
class AboutUsFragment : Fragment(R.layout.fragment_about_us) {

    private val binding: FragmentAboutUsBinding by viewBinding()
    private val viewModel: AboutUsViewModel by viewModels()
    private val mentorsAdapter by lazy { (MentorsAdapter()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }

    private fun initRv() {
        mentorsAdapter.setData(SetData.setMentors())
        binding.rvMentors.adapter = mentorsAdapter
    }
}