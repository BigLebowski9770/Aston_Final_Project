package com.kipreev.aston_final_project.domain.extentions

import kotlin.reflect.KClass

fun <T : Any> KClass<T>.getTag(): String = this.java.simpleName