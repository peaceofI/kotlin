
package com.study.barakahfocus.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.barakahfocus.domain.usecase.GetTodayStudyTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getTodayStudyTimeUseCase: GetTodayStudyTimeUseCase
) : ViewModel() {

    private val _todayStudyTime = MutableLiveData<Long>()
    val todayStudyTime: LiveData<Long> = _todayStudyTime

    init {
        viewModelScope.launch {
            getTodayStudyTimeUseCase().collect { time ->
                _todayStudyTime.postValue(time)
            }
        }
    }
}
