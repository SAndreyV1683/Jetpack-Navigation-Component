package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpacknavigationcomponent.databinding.FragmentFactBinding

class FactFragment: Fragment() {

    private lateinit var binding: FragmentFactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fact = requireArguments().getString(ARGS_FACT)
        binding.fact.text = fact
        val imageId = if (fact?.equals(getString(R.string.cat_fact)) == true) R.drawable.cat else R.drawable.hamster
        binding.imageButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_factFragment_to_imageFragment,
                ImageFragment.createArgs(imageId)
            )
        }
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    companion object {
        const val ARGS_FACT = "fact"
        fun createFact(fact: String): Bundle = bundleOf(ARGS_FACT to fact)
    }
}