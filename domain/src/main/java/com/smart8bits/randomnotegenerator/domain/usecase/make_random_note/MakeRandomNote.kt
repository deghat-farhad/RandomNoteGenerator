package com.smart8bits.randomnotegenerator.domain.usecase.make_random_note

import com.smart8bits.randomnotegenerator.domain.usecase.base.UseCaseNoParams
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MakeRandomNote(
    coroutineContext: CoroutineContext
): UseCaseNoParams<Char>(coroutineContext) {
    override suspend fun buildUseCase(): Char {
        val notesArray = arrayOf('a', 'b', 'c')
        return notesArray[Random.nextInt(notesArray.size)]
    }
}