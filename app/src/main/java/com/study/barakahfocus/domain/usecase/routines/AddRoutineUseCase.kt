
package com.study.barakahfocus.domain.usecase.routines

import com.study.barakahfocus.domain.model.Routine
import com.study.barakahfocus.domain.repository.RoutineRepository
import javax.inject.Inject

class AddRoutineUseCase @Inject constructor(
    private val repository: RoutineRepository
) {
    suspend operator fun invoke(routine: Routine) {
        repository.insertRoutine(routine)
    }
}
