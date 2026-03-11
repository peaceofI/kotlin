
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.RoutineDao
import com.study.barakahfocus.data.local.entity.RoutineEntity
import com.study.barakahfocus.domain.model.Routine
import com.study.barakahfocus.domain.repository.RoutineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoutineRepositoryImpl @Inject constructor(
    private val dao: RoutineDao
) : RoutineRepository {
    override fun getAllRoutines(): Flow<List<Routine>> =
        dao.getAllRoutines().map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertRoutine(routine: Routine) {
        dao.insert(routine.toEntity())
    }

    override suspend fun updateRoutine(routine: Routine) {
        dao.update(routine.toEntity())
    }

    override suspend fun deleteRoutine(id: Long) {
        dao.deleteById(id)
    }

    private fun RoutineEntity.toDomain(): Routine = Routine(
        id = id,
        name = name,
        startTime = startTime,
        daysOfWeek = daysOfWeek
    )

    private fun Routine.toEntity(): RoutineEntity = RoutineEntity(
        id = id,
        name = name,
        startTime = startTime,
        daysOfWeek = daysOfWeek
    )
}
