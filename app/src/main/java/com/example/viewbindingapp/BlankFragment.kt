package com.example.viewbindingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbindingapp.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentBlankBinding.inflate(inflater, container, false)

        binding.printBtn.setOnClickListener {
            if (binding.edTitle.text.toString().isEmpty()){
                binding.edTitle.error = "Required"
            }else if (binding.edDesc.text.toString().isEmpty()){
                binding.edDesc.error = "Required"
            }else{
                binding.titleTxt.text = binding.edTitle.text.toString()
                binding.descTxt.text = binding.edDesc.text.toString()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}