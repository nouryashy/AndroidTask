package com.example.a.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a.R
import com.example.a.base.GeneralAdapter
import com.example.a.databinding.FragmentUniversityListBinding
import com.example.a.databinding.UniversityItemListBinding
import com.example.a.viewmodel.UniversityViewModel
import com.example.androidtask.state.Resource
import com.example.domain.university.model.University
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class UniversityListFragment : Fragment() {
    private lateinit var universityAdapter: GeneralAdapter<University, UniversityItemListBinding>
    private lateinit var fgBinding: FragmentUniversityListBinding
    private val viewModel: UniversityViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fgBinding = FragmentUniversityListBinding.inflate(inflater, container, false)
        return fgBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUniversityAdapter()
        fgBinding.universityRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = universityAdapter
        }
        viewModel.loadUniversities()
        observeUniversitiesState()
    }

    private fun setUpUniversityAdapter() {
        universityAdapter = GeneralAdapter(
            layoutInflater,
            UniversityItemListBinding::inflate
        ) { binding, university ->
            binding.universityNameTv.text = university.name
            binding.universityStateTv.text = university.country

            universityAdapter.setOnItemClickListener { university ->
                val id = university.id
                val universityName = university.name
                val universityState = university.state_province
                var universityCountry = university.country
                var universityCountryCode = university.alpha_two_code
                var universityWebPage: String? = null
                for (i in university.web_pages) {
                    universityWebPage = university.web_pages[0]
                }
                findNavController().navigate(R.id.action_universityListFragment_to_detailsFragment)
            }
        }

    }

    private fun observeUniversitiesState() {
        lifecycleScope.launch {
            viewModel.universities.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        val universities = result.data
                        fgBinding.apply {
                            universityProgressBar.visibility = View.GONE
                        }
                        universityAdapter.setItems(universities)
                    }

                    is Resource.Loading -> {
                        fgBinding.apply {
                            universityProgressBar.visibility = View.VISIBLE
                        }
                    }

                    is Resource.Error -> {
                        val error = result.exception
                        fgBinding.apply {
                            universityProgressBar.visibility = View.GONE
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}
