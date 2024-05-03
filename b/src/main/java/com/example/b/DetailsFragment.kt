package com.example.b

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.b.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var fgDetBinding: FragmentDetailsBinding
    var universityId: Int? = null
    var universityName: String? = null
    var universityState: String? = null
    var universityCountry: String? = null
    var universityCountryCode: String? = null
    var universityWebPage: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fgDetBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return fgDetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: DetailsFragmentArgs by navArgs()
        universityId = args.universityId
        universityName = args.universityName
        universityState = args.universityState
        universityCountry = args.universityCountry
        universityCountryCode = args.universityCountryCode
        universityWebPage = args.webPage

        fgDetBinding.universityNameTv.text = universityName
        fgDetBinding.universityStateTv.text = universityState
        fgDetBinding.countryTv.text = universityCountry
        fgDetBinding.countryCodeTv.text = universityCountryCode
        fgDetBinding.webPageTv.text = universityWebPage

    }
}