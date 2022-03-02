package com.example.datatransfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setFragmentResult("requestKey", bundleOf("data" to "Hello"))
        setFragmentResultListener("requestKey") { key, bundle ->
            val data = bundle.getString("data", "")
            Toast.makeText(requireContext(), data, Toast.LENGTH_LONG).show()
        }
        val binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.button.setOnClickListener{
           findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }


        return binding.root
    }
}