package com.example.karhoodemo.domain.base

interface BaseWithParamUseCase<P, T> {
    operator fun invoke(param: P): T
}