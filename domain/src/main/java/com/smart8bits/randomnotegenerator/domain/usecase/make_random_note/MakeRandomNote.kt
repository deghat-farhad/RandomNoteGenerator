package com.smart8bits.randomnotegenerator.domain.usecase.make_random_note

import com.smart8bits.randomnotegenerator.domain.usecase.base.UseCaseNoParams
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MakeRandomNote(
    coroutineContext: CoroutineContext
) : UseCaseNoParams<String>(coroutineContext) {
    override suspend fun buildUseCase(): String {
        val notesArray = arrayOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        return notesArray[Random.nextInt(notesArray.size)]
    }
}