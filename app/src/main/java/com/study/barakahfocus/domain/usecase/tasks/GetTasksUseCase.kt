
package com.study.barakahfocus.domain.usecase.tasks

import com.study.barakahfocus.domain.model.Task
import com.study.barakahfocus.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> = repository.getAllTasks()
}
