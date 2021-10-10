package com.utsav.stateflowdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.utsav.stateflowdemo.Adapter.PostAdapter
import com.utsav.stateflowdemo.ViewModel.MainViewModel
import com.utsav.stateflowdemo.databinding.ActivityMainBinding
import com.utsav.stateflowdemo.network.Resource
import com.utsav.stateflowdemo.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    @Inject
    lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()



        lifecycleScope.launchWhenCreated {
            mainViewModel._postStateFlow.collect {it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible=false
                        binding.progressBar.isVisible=true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerview.isVisible = true
                        binding.progressBar.isVisible = false
                        postAdapter.setData(it.data)
                        postAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty->{

                    }
                }
            }
            mainViewModel._loginStateFlow.collect{
                it.message?.let { it1 -> Log.e("message", it1) }
                Log.e("Status",it.status.toString())
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.isVisible=false
                    }
                    Resource.Status.ERROR -> {
                        binding.progressBar.isVisible=false
                    }
                    Resource.Status.LOADING -> {

                        binding.progressBar.isVisible=true
                    }
                    Resource.Status.NO_INTERNET_CONNECTION -> TODO()
                    Resource.Status.UNKNOWN -> TODO()
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

        },2000)
        mainViewModel.doLogin()
        mainViewModel.getPost()


    }

    private fun initRecyclerview() {
        postAdapter= PostAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}