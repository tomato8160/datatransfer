package com.example.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentFirstBinding
import com.example.datatransfer.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

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

        val binding = FragmentSecondBinding.inflate(layoutInflater)
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
        return binding.root
    }
}