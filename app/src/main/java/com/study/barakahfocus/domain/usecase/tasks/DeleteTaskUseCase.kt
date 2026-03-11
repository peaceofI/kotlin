
package com.study.barakahfocus.domain.usecase.tasks

import com.study.barakahfocus.domain.repository.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteTask(id)
    }
}
