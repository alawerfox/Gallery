package ru.kartyshova.gallery.main.presentation.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kartyshova.gallery.R
import ru.kartyshova.gallery.databinding.MainFragmentBinding

class GalleryFragment : Fragment(R.layout.main_fragment) {

    private var binding: MainFragmentBinding? = null

    private val galleryAdapter by lazy { GalleryAdapter() }

    private val navController: NavController by lazy { findNavController() }

    private val viewModel: GalleryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.also {
            binding = MainFragmentBinding.bind(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = galleryAdapter
        }

        viewModel.load()

        lifecycleScope.launchWhenStarted {
            viewModel.items
                .collect {
                    galleryAdapter.setItems(it)
                }
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}

