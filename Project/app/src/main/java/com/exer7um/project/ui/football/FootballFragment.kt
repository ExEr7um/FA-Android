package com.exer7um.project.ui.football

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.exer7um.project.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://v3.football.api-sports.io/"

class FootballFragment : Fragment() {

    lateinit var footballAdapter: FootballAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.footballRecyclerview.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        binding.footballRecyclerview.layoutManager = linearLayoutManager
        getFootballData()

        return binding.root
    }

    private fun getFootballData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FootballApiInterface::class.java)

        val retrofitData = retrofitBuilder.getFootballData()

        retrofitData.enqueue(object : Callback<FootballData> {
            override fun onResponse(
                call: Call<FootballData>,
                response: Response<FootballData>
            ) {
                val responseBody = response.body()!!

                footballAdapter = FootballAdapter(context!!, responseBody.response)
                footballAdapter.notifyDataSetChanged()
                binding.footballRecyclerview.adapter = footballAdapter
            }

            override fun onFailure(call: Call<FootballData>?, t: Throwable) {
                d("FootballFragment", "onFailure: " + t.message)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}