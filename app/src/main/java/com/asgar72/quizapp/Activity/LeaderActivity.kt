package com.asgar72.quizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.asgar72.quizapp.Adapter.LeaderAdapter
import com.asgar72.quizapp.Domain.UserModel
import com.asgar72.quizapp.R
import com.asgar72.quizapp.databinding.ActivityLeaderBinding
import com.asgar72.quizapp.databinding.ViewholderLeadersBinding
import com.bumptech.glide.Glide

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.grey)

        binding.apply {
            scoreTop1Txt.text = loadData().get(0).score.toString()
            scoreTop2Txt.text = loadData().get(1).score.toString()
            scoreTop3Txt.text = loadData().get(2).score.toString()
            titleTop1txt1.text = loadData().get(0).name
            titleTop1txt2.text = loadData().get(1).name
            titleTop1txt3.text = loadData().get(2).name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .load(pic1)

            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId2)
                .load(pic2)

            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId3)
                .load(pic3)

            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity1::class.java))
                    finish()
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    //you can get below list your API services, this is a only example list
    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "Aliya", "person1", 4850))
        users.add(UserModel(2, "Daniel", "person2", 4745))
        users.add(UserModel(3, "James", "person3", 4156))
        users.add(UserModel(4, "John Smith", "person4", 3850))
        users.add(UserModel(5, "Emily Johnson", "person5", 4020))
        users.add(UserModel(6, "David Brown", "person6", 3550))
        users.add(UserModel(7, "Sarah Wilson", "person7", 4690))
        users.add(UserModel(8, "Michel Davis", "person8", 2910))
        users.add(UserModel(9, "Sophia", "person9", 4970))
        return users
    }
}