package com.smart8bits.randomnotegenerator.di

import com.smart8bits.randomnotegenerator.domain.usecase.make_random_note.MakeRandomNote
import com.smart8bits.randomnotegenerator.domain.usecase.make_random_octave.MakeRandomOctave
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun makeRandomOctave(coroutineContext: CoroutineContext): MakeRandomOctave {
        return MakeRandomOctave(coroutineContext)
    }

    @Provides
    fun makeRandomNote(coroutineContext: CoroutineContext): MakeRandomNote {
        return MakeRandomNote(coroutineContext)
    }

    @Provides
    fun coroutineContext(): CoroutineContext = Dispatchers.IO
}