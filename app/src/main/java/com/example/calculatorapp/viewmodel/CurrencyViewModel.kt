package com.example.calculatorapp.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.model.baseAnyCurrencyModel
import com.example.calculatorapp.servis.ApiServisAny
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CurrencyViewModel:ViewModel() {
    val bilgilerAnyCurrency=MutableLiveData<baseAnyCurrencyModel>()
    val hataMesaji=MutableLiveData<Boolean>()
    val yukleniyor=MutableLiveData<Boolean>()
    val disposable=CompositeDisposable()
    private val apiServis1= ApiServisAny()

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities)
                ?: return false

            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                // Diğer bağlantı türlerini buraya ekleyebilirsiniz (örn. TRANSPORT_ETHERNET)
                else -> false
            }
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
    fun refreshData1(baseName:String){
        yukleniyor.value=true
        hataMesaji.value=false
        disposable.add(
            apiServis1.getData(baseName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<baseAnyCurrencyModel>(){
                    override fun onSuccess(t: baseAnyCurrencyModel) {
                        bilgilerAnyCurrency.value=t
                        yukleniyor.value=false
                        hataMesaji.value=false
                    }

                    override fun onError(e: Throwable) {
                        yukleniyor.value=false
                        hataMesaji.value=true
                    }

                })
        )
    }
}