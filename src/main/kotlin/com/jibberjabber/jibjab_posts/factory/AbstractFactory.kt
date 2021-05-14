package com.jibberjabber.jibjab_posts.factory

interface AbstractFactory<T, V> {

    fun convert(input : T): V
}
