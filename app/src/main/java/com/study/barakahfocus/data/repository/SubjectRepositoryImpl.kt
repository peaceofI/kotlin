
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.SubjectDao
import com.study.barakahfocus.data.local.entity.SubjectEntity
import com.study.barakahfocus.domain.model.Subject
import com.study.barakahfocus.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectRepositoryImpl @Inject constructor(
    private val dao: SubjectDao
) : SubjectRepository {
    override fun getAllSubjects(): Flow<List<Subject>> =
        dao.getAllSubjects().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertSubject(subject: Subject) {
        dao.insert(subject.toEntity())
    }

    override suspend fun updateSubject(subject: Subject) {
        dao.update(subject.toEntity())
    }

    override suspend fun deleteSubject(id: Long) {
        dao.deleteById(id)
    }

    private fun SubjectEntity.toDomain(): Subject = Subject(
        id = id,
        name = name,
        color = color,
        dailyGoalMinutes = dailyGoalMinutes,
        totalStudyTime = totalStudyTime
    )

    private fun Subject.toEntity(): SubjectEntity = SubjectEntity(
        id = id,
        name = name,
        color = color,
        dailyGoalMinutes = dailyGoalMinutes,
        totalStudyTime = totalStudyTime
    )
}
