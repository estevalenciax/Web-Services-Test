package com.ev.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ev.myapplication.databinding.FragmentListBinding
import com.ev.myapplication.ui.CategoryAdapter

class ListFragment : Fragment(), CategoryAdapter.OnItemClick {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelCategories by activityViewModels()

    private val itemList = mutableListOf<String>()
    private val adapter = CategoryAdapter(itemList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        viewModel.getCategories()
        setUpRecyclerView()
    }

    private fun initObservers() {
        viewModel.categoriList.observe(viewLifecycleOwner) {
            itemList.clear()
            itemList.addAll(it)
            adapter.notifyDataSetChanged()
        }

    }
    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(category: String) {
        Log.d("Category selected", category)
    }
}