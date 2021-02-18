package com.smart8bits.randomnotegenerator.domain.usecase.make_random_note

data class MakeRandomNoteParams(
    val hasFlat: Boolean,
    val hasSharp: Boolean,
    val hasEven: Boolean
)