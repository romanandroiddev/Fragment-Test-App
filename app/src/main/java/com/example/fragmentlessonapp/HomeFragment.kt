package com.example.fragmentlessonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragmentlessonapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.tvCount.text = "Screen #${requireArguments().getInt(NUMBER_OF_SCREEN)}"


        binding.btnNext.setOnClickListener {
            (requireActivity() as MainActivity).setFragment(
                HomeFragment.newInstance((requireActivity() as MainActivity).getNumberOfScreen())
            )
        }

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
            Toast.makeText(requireContext(), "alsjdnajksd", Toast.LENGTH_SHORT).show()
        }


    }

    companion object {

        private const val NUMBER_OF_SCREEN = "number_of_screen"

        @JvmStatic
        fun newInstance(number: Int): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putInt(NUMBER_OF_SCREEN, number)
            fragment.arguments = bundle
            return fragment


        }
    }
}