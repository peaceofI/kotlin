
package com.study.barakahfocus.presentation.prayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.study.barakahfocus.databinding.FragmentPrayersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrayerFragment : Fragment() {

    private var _binding: FragmentPrayersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PrayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: display prayer times
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
