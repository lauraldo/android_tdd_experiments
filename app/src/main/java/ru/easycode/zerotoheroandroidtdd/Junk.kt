package ru.easycode.zerotoheroandroidtdd

sealed class UiState(val value: String) {
    data class Base(val text: String) : UiState(text)
    data class Max(val text: String) : UiState(text)
}

interface Count {
    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val sum = number.toInt() + step
            return if (max - sum < step)
                UiState.Max(sum.toString())
            else
                UiState.Base(sum.toString())
        }
    }

    fun increment(number: String): UiState
}