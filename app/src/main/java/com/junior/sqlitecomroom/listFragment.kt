package com.junior.sqlitecomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.junior.sqlitecomroom.adapter.UserAdapter
import com.junior.sqlitecomroom.databinding.FragmentListBinding

class listFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter = UserAdapter()
        binding.recycleUser.layoutManager = LinearLayoutManager(context)
        binding.recycleUser.adapter = adapter
        binding.recycleUser.setHasFixedSize(true)

        mainViewModel.selectUsers.observe(viewLifecycleOwner){
            response -> adapter.setList(response)
        }

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return binding.root
    }

}