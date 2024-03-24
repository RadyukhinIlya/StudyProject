package com.example.studyproject

import BreweriesDTO
import BreweriesDTOItem
import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.studyproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Array


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BreweryInterface::class.java)

            var city = binding.editCity.text
            var state = binding.editState.text



    binding.button.setOnClickListener{
                service.getBreweries(city = city.toString(), state = state.toString(), "United States").enqueue(object :
                    Callback<BreweriesDTO> {
                    override fun onResponse(call: Call<BreweriesDTO>, response: Response<BreweriesDTO>) {
                        val b = response.body()!!

                        if (b != null) {
                            val newList = mutableListOf<String>()
                            for (i in b){
                                newList += i.name
                                val ab = binding.lv
                            val adapter: ArrayAdapter<String> =
                                ArrayAdapter<String>(baseContext, R.layout.simple_list_item_1,
                                   newList)
                            ab.adapter = adapter
                            }
                        }

                    }
                    override fun onFailure(call: Call<BreweriesDTO>, t: Throwable) {
                        println("ошибка")
                        t.printStackTrace()
                    }
                })
            }


    }}



