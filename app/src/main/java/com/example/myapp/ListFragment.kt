package com.example.myapp

import ListFragmentViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapp.adapters.UserEntityListAdapter
import com.example.myapp.databinding.FragmentListBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UserEntityListAdapter()
        binding.entityList.adapter = adapter


        viewModel.list.observe(requireActivity()) {
            adapter.items = it
        }

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listFragment_to_editFragment)
        }
    }
}