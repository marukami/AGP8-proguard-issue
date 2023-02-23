package dev.tilbrook.feature

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.ViewModelKey
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap


@Module
@InstallIn(SingletonComponent::class) // Installs FooModule in the generate SingletonComponent.
internal object CounterModule {
    @Provides
    fun provideBar(): Counter = Counter()
}

@Module
@InstallIn(SingletonComponent::class) // Installs FooModule in the generate SingletonComponent.
interface CounterBindingModule {
    @[Binds IntoMap ViewModelKey(CounterViewModel::class)]
    fun bindsCounterViewModelFactory(
        factory: CounterViewModel.Factory
    ): AssistedViewModelFactory<*, *>
}

class Counter {
    fun plusOne(n: Int): Int = n + 1
}

class CounterViewModel @AssistedInject constructor(
    @Assisted initialState: State,
    private val counter: Counter,
) : MavericksViewModel<CounterViewModel.State>(initialState) {

    data class State(
        val count: Int = 0
    ) : MavericksState

    fun add() {
        setState {
            copy(count = counter.plusOne(count))
        }
    }


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CounterViewModel, State> {
        override fun create(state: State): CounterViewModel
    }

    companion object :
        MavericksViewModelFactory<CounterViewModel, State> by hiltMavericksViewModelFactory()
}