package com.example.movieappviewbindingandcache

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieappviewbindingandcache.Cache.MySharedPreferenceMovie
import com.example.movieappviewbindingandcache.Class.MovieClass
import com.example.movieappviewbindingandcache.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var bindingA: ActivityAddBinding
    lateinit var movieList: ArrayList<MovieClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingA = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingA.root)

        supportActionBar?.title = "Add movie"

        MySharedPreferenceMovie.init(this)

        movieList = MySharedPreferenceMovie.listSave

        bindingA.saveAdd.setOnClickListener {


            if (bindingA.nameAddId.text.toString().trim()
                    .isNotEmpty() && bindingA.authorsAddId.text.toString().trim()
                    .isNotEmpty() && bindingA.aboutAddId.text.toString().trim()
                    .isNotEmpty() && bindingA.dateAddId.text.toString().trim().isNotEmpty()
            ) {

                val movieClass = MovieClass(
                    bindingA.dateAddId.text.toString(),
                    bindingA.nameAddId.text.toString(),
                    bindingA.aboutAddId.text.toString(),
                    bindingA.authorsAddId.text.toString()
                )

                movieList.add(movieClass)

                MySharedPreferenceMovie.listSave = movieList

                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()

                finish()

            } else {
                Toast.makeText(this, "Enter isn't wrong", Toast.LENGTH_SHORT).show()
            }


        }


    }
}