
package com.study.barakahfocus.presentation.flashcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.study.barakahfocus.databinding.FragmentFlashcardListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlashcardListFragment : Fragment() {

    private var _binding: FragmentFlashcardListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FlashcardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlashcardListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Observe flashcards
        viewModel.flashcards.observe(viewLifecycleOwner) { list ->
            // TODO: update adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
