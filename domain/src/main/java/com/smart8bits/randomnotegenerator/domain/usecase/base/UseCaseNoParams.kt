package com.smart8bits.randomnotegenerator.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class UseCaseNoParams<T>(
    private val coroutineContext: CoroutineContext
) {
    abstract suspend fun buildUseCase(): T

    fun execute(uiScheduler: CoroutineScope, onResult: (T) -> Unit = {}) {
        uiScheduler.launch(coroutineContext) {
            onResult(buildUseCase())
        }
    }
}