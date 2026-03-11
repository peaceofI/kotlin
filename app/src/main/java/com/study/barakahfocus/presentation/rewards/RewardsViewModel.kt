
package com.study.barakahfocus.presentation.rewards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.barakahfocus.domain.usecase.rewards.GetRewardPointsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(
    private val getRewardPointsUseCase: GetRewardPointsUseCase
) : ViewModel() {

    private val _points = MutableLiveData<Int>()
    val points: LiveData<Int> = _points

    init {
        viewModelScope.launch {
            getRewardPointsUseCase().collect { rewardPoints ->
                _points.postValue(rewardPoints?.points ?: 0)
            }
        }
    }
}
