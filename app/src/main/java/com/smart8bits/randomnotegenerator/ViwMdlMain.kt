package com.smart8bits.randomnotegenerator

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNote
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNoteParams

class ViwMdlMain @ViewModelInject constructor(
    private val makeRandomNoteUseCase: MakeRandomNote
) : ViewModel() {
    val randomNote = MutableLiveData<String>()
    val hasEven = MutableLiveData<Boolean>(true)
    val hasFlat = MutableLiveData<Boolean>(true)
    val hasSharp = MutableLiveData<Boolean>(true)

    init {
        makeRandomNote()
    }

    fun makeRandomNote() {
        val params = MakeRandomNoteParams(
            hasFlat.value ?: false,
            hasSharp.value ?: false,
            hasEven.value ?: false
        )
        makeRandomNoteUseCase.execute(viewModelScope, params) {
            randomNote.postValue(it)
        }
    }
}