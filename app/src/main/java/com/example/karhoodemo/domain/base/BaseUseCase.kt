package com.example.karhoodemo.domain.base

interface BaseUseCase<T> {
    operator fun invoke(): T
}