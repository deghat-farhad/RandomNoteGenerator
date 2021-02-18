package com.smart8bits.randomnotegenerator

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNote

class ViwMdlMain @ViewModelInject constructor(
    private val makeRandomNoteUseCase: MakeRandomNote
) : ViewModel() {
    val randomNote = MutableLiveData<String>()

    init {
        makeRandomNote()
    }

    fun makeRandomNote() {
        makeRandomNoteUseCase.execute(viewModelScope) {
            randomNote.postValue(it)
        }
    }
}