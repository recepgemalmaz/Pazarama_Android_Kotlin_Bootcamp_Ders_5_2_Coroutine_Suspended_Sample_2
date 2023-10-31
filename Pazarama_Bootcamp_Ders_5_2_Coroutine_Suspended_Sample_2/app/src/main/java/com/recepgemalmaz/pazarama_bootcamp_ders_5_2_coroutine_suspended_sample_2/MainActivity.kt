package com.recepgemalmaz.pazarama_bootcamp_ders_5_2_coroutine_suspended_sample_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    //JOP KULLANIMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            var j1: Job = launch {
                delay(1000)
                Log.e("ql", "coroutine-1")
            }

            var j2 = launch {
                delay(2000)
                Log.e("ql", "coroutine-2")
            }

            j1.invokeOnCompletion {
                Log.e("ql", "işlem 1 tamamlandı")
                // j2.cancel()
            }
        }

    }
}



//Onemli Notlar

//1- Suspend fonksiyonlar, coroutine scope içerisinde çalıştırılabilen fonksiyonlardır.
//2- Runblocking fonksiyonu coroutine scope içerisinde çalıştırılabilen fonksiyonlardır.
// Ayrica Runblocking calsirken butun kodlari bloke eder ve onun disinda kalan diger kodlari calistirmaz.
//3- Global Scope ise butun uygulamayi kapsayan Scope'dur. Global Scope icindeki coroutine'lerin calismasi icin.
// Butun uygulamayi ve activityleri kapsar.
//4-CoroitineScope ise sadece coroutineScope icindeki coroutine'lerin calismasi icin kullanilir.
//Scope'u bir ustekinden miras alir ve dogrudan corutine baslatir
//5- Dispatchers.Main ise coroutine'lerin main thread'de calismasi icin kullanilir.
//6- Dispatchers.IO ise coroutine'lerin arka planda calismasi icin kullanilir.
//7- Dispatchers.Default ise coroutine'lerin default thread'de calismasi icin kullanilir.
//8- Dispatchers.Unconfined ise coroutine'lerin main thread'de calismasi icin kullanilir.


//9- Coroutine launch kullanirken launc bizr  Jop sinifi geri dondurur.
//Jop sinifi ise bize o coroutine'in durumunu takip etmemizi saglar.
//KisacA jop, launch'un geri dodus degeridir

//10- invokeOnCompletion ise o coroutine'in basariyla tamamlanmasi durumunda tetiklenir
// boylece o coroutine'in isiniyaptiktan sonra istedigimiz is tetiklenebilir.




//Suspend Nedir
//Suspend fonksiyonlar, coroutine scope içerisinde çalıştırılabilen fonksiyonlardır.
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //suspendTest()//Bu sekilde suspend fonksiyonu cagirilamaz. coroutineScope icinde cagirilir
        GlobalScope.launch(Dispatchers.Main) {
            Log.e("ql", " OnCreate Calsirti")
            delay(1000)
            suspendTest()

        }



    }

    suspend fun suspendTest()
    {
        coroutineScope {
            delay(1000)
            Log.e("ql", "suspendTest Calsirti")
        }
    }

}
 */



/*
    class MainActivity : AppCompatActivity() {

    suspend fun Foo(): String {
        delay(8000)
        Log.e("ql", "Foo Calisti")
        return "29 Ekim"
    }

    suspend fun Bar(): Long {
        delay(3000)
        Log.e("ql", "Bar Calisti")
        return 1923L

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var fooRet = ""
        var barRet = 0L

        runBlocking {
            var f = async {
                Foo()
            }
            var b = async {
                Bar()
            }
            fooRet = f.await()
            barRet = b.await()

            Log.e("ql", "fooRet: $fooRet barRet: $barRet")
        }

    }
}
 */
