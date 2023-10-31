package com.recepgemalmaz.pazarama_bootcamp_ders_5_2_coroutine_suspended_sample_2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main()
{
    runBlocking(Dispatchers.Default) {
        launch {
            println(coroutineContext.toString())
        }

        withContext(Dispatchers.IO)
        {
            println(coroutineContext.toString())
        }
    }
    //withContext nedir
    //withContext coroutine'lerin calistigi thread'i degistirmek icin kullanilir.
}