package com.smart8bits.randomnotegenerator

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNote
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNoteParams
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_octave.MakeRandomOctave
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_octave.MakeRandomOctaveParams

class ViwMdlMain @ViewModelInject constructor(
    private val makeRandomNoteUseCase: MakeRandomNote,
    private val makeRandomOctaveUseCase: MakeRandomOctave
) : ViewModel() {
    val randomNote = MutableLiveData<String>()
    val hasEven = MutableLiveData<Boolean>(true)
    val hasFlat = MutableLiveData<Boolean>(true)
    val hasSharp = MutableLiveData<Boolean>(true)
    val randomOctave = MutableLiveData<String>()
    val isRandomOctaveIncluded = MutableLiveData<Boolean>(true)
    val error = MutableLiveData<String>()

    init {
        makeRandomNote()
    }

    fun makeRandomNote() {
        if (hasFlat.value == false &&
            hasSharp.value == false &&
            hasEven.value == false
        )
            error.postValue("At least one of flat, sharp or even options must be checked.")
        else {
            val params = MakeRandomNoteParams(
                hasFlat.value ?: false,
                hasSharp.value ?: false,
                hasEven.value ?: false
            )
            makeRandomNoteUseCase.execute(viewModelScope, params) {
                randomNote.postValue(it)
                if (isRandomOctaveIncluded.value == true)
                    makeRandomOctave(it)
            }
        }
    }

    private fun makeRandomOctave(note: String) {
        val params = MakeRandomOctaveParams(note)
        makeRandomOctaveUseCase.execute(viewModelScope, params) {
            randomOctave.postValue(it.toString())
        }
    }
}