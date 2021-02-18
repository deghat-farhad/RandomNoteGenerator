package com.smart8bits.randomnotegenerator.domain.usecase.make_random_octave

import com.smart8bits.randomnotegenerator.domain.usecase.base.UseCase
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MakeRandomOctave(
    coroutineContext: CoroutineContext
) : UseCase<Int, MakeRandomOctaveParams>(coroutineContext) {
    override suspend fun buildUseCase(params: MakeRandomOctaveParams): Int {
        if (params.note.isNotEmpty())
            return when (params.note.subSequence(0, 1)) {
                "C", "D" -> Random.nextInt(3, 5)
                "E" -> Random.nextInt(2, 6)
                "F", "G", "A", "B" -> Random.nextInt(2, 5)
                else -> throw IllegalArgumentException()
            }
        else
            throw IllegalArgumentException()
    }
}