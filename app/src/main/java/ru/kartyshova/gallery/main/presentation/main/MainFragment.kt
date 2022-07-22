package ru.kartyshova.gallery.main.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ru.kartyshova.gallery.R
import ru.kartyshova.gallery.databinding.NavigationLayoutBinding

class MainFragment:Fragment(R.layout.navigation_layout) {

    private var binding:NavigationLayoutBinding? = null

    private val navController: NavController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigation?.setupWithNavController(navController)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.also {
           binding = NavigationLayoutBinding.bind(it)
        }
    }
}