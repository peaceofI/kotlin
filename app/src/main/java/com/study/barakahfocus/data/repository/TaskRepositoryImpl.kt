
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.TaskDao
import com.study.barakahfocus.data.local.entity.TaskEntity
import com.study.barakahfocus.domain.model.Task
import com.study.barakahfocus.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> =
        dao.getAllTasks().map { entities -> entities.map { it.toDomain() } }

    override fun getPendingTasks(): Flow<List<Task>> =
        dao.getPendingTasks().map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertTask(task: Task) {
        dao.insert(task.toEntity())
    }

    override suspend fun updateTask(task: Task) {
        dao.update(task.toEntity())
    }

    override suspend fun deleteTask(id: Long) {
        dao.deleteById(id)
    }

    private fun TaskEntity.toDomain(): Task = Task(
        id = id,
        title = title,
        description = description,
        subjectId = subjectId,
        deadline = deadline,
        priority = priority,
        estimatedTime = estimatedTime,
        isCompleted = isCompleted
    )

    private fun Task.toEntity(): TaskEntity = TaskEntity(
        id = id,
        title = title,
        description = description,
        subjectId = subjectId,
        deadline = deadline,
        priority = priority,
        estimatedTime = estimatedTime,
        isCompleted = isCompleted
    )
}
