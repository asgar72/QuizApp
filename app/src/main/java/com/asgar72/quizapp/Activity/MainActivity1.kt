package com.asgar72.quizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.asgar72.quizapp.Domain.QuestionModel
import com.asgar72.quizapp.R
import com.asgar72.quizapp.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityMain1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val window: Window = this@MainActivity1.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity1, R.color.grey)

        binding.apply {
            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.Board) {
                    startActivity(Intent(this@MainActivity1, LeaderActivity::class.java))
                    finish()
                }
            }

            singleBtn.setOnClickListener {
                val intent = Intent(this@MainActivity1, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }
    }

    //this is a list of question and this for example. you can get Question from your API service.
    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Which planet is the largest plant in the solar system",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                2,
                "Which country is the largest country in the world by land area?",
                "Russia",
                "Canada",
                "United States",
                "China",
                "a",
                5,
                "q_2",
                null
            )
        )
        question.add(
            QuestionModel(
                3,
                "Which of the following substances is used as an anti-cancer medication in the medical world?",
                "Cheese",
                "Lemon juice",
                "Cannabis",
                "Pasplum",
                "c",
                5,
                "q_3",
                null
            )
        )
        question.add(
            QuestionModel(
                4,
                "Which moon in the earth's solar system has an atmosphere?",
                "Luna (Moon)",
                "Phobos (Mars' moon)",
                "Venus' moon",
                "None of the above",
                "d",
                5,
                "q_4",
                null
            )
        )
        question.add(
            QuestionModel(
                5,
                "Which of the following symbol represents the chemical element with the atomic number 6?",
                "0",
                "H",
                "C",
                "N",
                "c",
                5,
                "q_5",
                null
            )
        )
        question.add(
            QuestionModel(
                6,
                "Who is credited with inventing theater as we know it today?",
                "Shakespeare",
                "Arthur Miller",
                "Ashkouri",
                "Ancient Greeks",
                "d",
                5,
                "q_6",
                null
            )
        )
        question.add(
            QuestionModel(
                7,
                "Which ocean is the largest ocean in the world?",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Arabic Ocean",
                "a",
                5,
                "q_7",
                null
            )
        )
        question.add(
            QuestionModel(
                8,
                "Which religions are among the most practiced religions in the world?",
                "Islam, Christianity, Judaism",
                "Buddhism, Hinduism, Sikhism",
                "Zoroastrianism, Brahmanism, Yazdanism",
                "Taoism, Shintoism, Confucianism",
                "a",
                5,
                "q_8",
                null
            )
        )
        question.add(
            QuestionModel(
                9,
                "In Which continent are most independent countries located?",
                "Asia",
                "Europe",
                "Africa",
                "Americas",
                "c",
                5,
                "q_9",
                null
            )
        )
        question.add(
            QuestionModel(
                10,
                "Which ocean has the greatest average depth?",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Southern Ocean",
                "d",
                5,
                "q_10",
                null
            )
        )
        return question
    }
}