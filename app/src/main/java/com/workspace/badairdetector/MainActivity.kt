package com.workspace.badairdetector

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.workspace.badairdetector.adapters.CidadeListAdapter
import com.workspace.badairdetector.models.Aqi
import com.workspace.badairdetector.service.AquicnService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.waqi.info/feed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val aqicnService = retrofit.create(AquicnService::class.java)

        aqicnService.listarCidade().enqueue(object : Callback<Aqi> {
            override fun onFailure(call: Call<Aqi>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<Aqi>, response: Response<Aqi>) {
                showData(response.body()!!)
            }


        })
    }

    private fun showData(aqi: Aqi) {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = CidadeListAdapter(aqi)
        }
    }
}
