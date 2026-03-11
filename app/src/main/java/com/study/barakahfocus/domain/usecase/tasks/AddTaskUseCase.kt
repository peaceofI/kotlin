
package com.study.barakahfocus.domain.usecase.tasks

import com.study.barakahfocus.domain.model.Task
import com.study.barakahfocus.domain.repository.TaskRepository
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.insertTask(task)
    }
}
