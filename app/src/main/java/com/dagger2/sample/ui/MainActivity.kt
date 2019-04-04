package com.dagger2.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.dagger2.sample.App
import com.dagger2.sample.R
import com.dagger2.sample.di.component.DaggerMainActivityComponent
import com.dagger2.sample.di.modules.MainActivityModule
import com.dagger2.sample.models.GithubRepo
import com.dagger2.sample.network.GithubService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var reposCall: Call<List<GithubRepo>>? = null

    @Inject
    lateinit var githubService: GithubService

    @Inject
    lateinit var adapterRepos: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder()
                .appComponent(App.get(this).component)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRepos
        }

        initData()
    }

    private fun initData() {
        reposCall = githubService.getAllRepos()
        reposCall?.enqueue(object : Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>?, t: Throwable?) {
                Log.e("TAG", "加载失败")
                Toast.makeText(this@MainActivity, "加载失败", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<GithubRepo>>?, response: Response<List<GithubRepo>>?) {
                adapterRepos.setData(response?.body())
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        reposCall?.cancel()
    }
}
