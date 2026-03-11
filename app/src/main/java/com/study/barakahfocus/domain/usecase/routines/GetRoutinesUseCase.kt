
package com.study.barakahfocus.domain.usecase.routines

import com.study.barakahfocus.domain.model.Routine
import com.study.barakahfocus.domain.repository.RoutineRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoutinesUseCase @Inject constructor(
    private val repository: RoutineRepository
) {
    operator fun invoke(): Flow<List<Routine>> = repository.getAllRoutines()
}
