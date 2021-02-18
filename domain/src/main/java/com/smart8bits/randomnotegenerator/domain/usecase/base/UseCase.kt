package com.smart8bits.randomnotegenerator.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class UseCase<T, P>(
    private val coroutineContext: CoroutineContext
) {
    abstract suspend fun buildUseCase(params: P): T

    fun execute(uiScheduler: CoroutineScope, params: P, onResult: (T) -> Unit = {}) {
        uiScheduler.launch(coroutineContext) {
            onResult(buildUseCase(params))
        }
    }
}