package com.smart8bits.randomnotegenerator.domain.usecase.make_random_note

import com.smart8bits.randomnotegenerator.domain.usecase.base.UseCase
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MakeRandomNote(
    coroutineContext: CoroutineContext
) : UseCase<String, MakeRandomNoteParams>(coroutineContext) {
    override suspend fun buildUseCase(params: MakeRandomNoteParams): String {
        val evenArray = arrayOf("C", "D", "E", "F", "G", "A", "B")
        val flatsArray = arrayOf("Db", "Eb", "Gb", "Ab", "Bb")
        val sharpArray = arrayOf("C#", "D#", "F#", "G#", "A#")

        val noteList = arrayListOf<String>()
        if (params.hasEven) {
            noteList.addAll(evenArray)
        }
        if (params.hasFlat) {
            noteList.addAll(flatsArray)
        }
        if (params.hasSharp) {
            noteList.addAll(sharpArray)
        }

        return noteList[Random.nextInt(noteList.size)]
    }
}