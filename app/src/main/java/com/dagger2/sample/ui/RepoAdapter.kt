package com.dagger2.sample.ui

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2.sample.R
import com.dagger2.sample.models.GithubRepo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import javax.inject.Inject

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
class RepoAdapter @Inject constructor(context: MainActivity, val picasso: Picasso) : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    private val layoutInflate = LayoutInflater.from(context)
    private var repoList: MutableList<GithubRepo> = ArrayList()

    fun setData(githubRepos: Collection<GithubRepo>?) {
        repoList.clear()
        if (githubRepos != null) {
            repoList.addAll(githubRepos)
        }
        Log.e("TAG", "数据：${repoList.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = layoutInflate.inflate(R.layout.item_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(repoList[position]) {
            holder.itemView.tv.text = name

            picasso.load(owner.avatarUrl)
                    .placeholder(R.drawable.ic_error_outline_black_24dp)
                    .into(holder.itemView.iv)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }
}