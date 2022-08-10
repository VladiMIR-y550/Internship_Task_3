package com.mironenko.internship_task_3.base

interface Interactor<State, Action> {

    suspend fun invoke(state: State, action: Action): Action

    fun canHandle(action: Action): Boolean
}