
package com.study.barakahfocus.presentation.routine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.barakahfocus.domain.model.Routine
import com.study.barakahfocus.domain.usecase.routines.GetRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase
) : ViewModel() {

    private val _routines = MutableLiveData<List<Routine>>()
    val routines: LiveData<List<Routine>> = _routines

    init {
        viewModelScope.launch {
            getRoutinesUseCase().collect { list ->
                _routines.postValue(list)
            }
        }
    }
}
