package kg.geektech.mathematicianskg.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.databinding.FragmentHomeBinding
import kg.geektech.mathematicianskg.presentation.adapters.NewsAdapter

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()
    private val newsAdapter by lazy { (NewsAdapter()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNews()
    }

    private fun initNews() {
        viewModel.news.observe(viewLifecycleOwner){
            newsAdapter.setList(it.articles)
        }
        binding.rvTechnology.adapter = newsAdapter
        binding.rvScience.adapter = newsAdapter
    }
}