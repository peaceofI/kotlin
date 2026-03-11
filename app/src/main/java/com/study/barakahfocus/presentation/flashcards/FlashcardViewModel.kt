
package com.study.barakahfocus.presentation.flashcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.barakahfocus.domain.model.Flashcard
import com.study.barakahfocus.domain.usecase.flashcards.GetFlashcardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val getFlashcardsUseCase: GetFlashcardsUseCase
) : ViewModel() {

    private val _flashcards = MutableLiveData<List<Flashcard>>()
    val flashcards: LiveData<List<Flashcard>> = _flashcards

    init {
        viewModelScope.launch {
            getFlashcardsUseCase().collect { list ->
                _flashcards.postValue(list)
            }
        }
    }
}
