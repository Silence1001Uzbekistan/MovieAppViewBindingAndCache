package com.example.movieappviewbindingandcache

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieappviewbindingandcache.Adapters.MovieAdapter
import com.example.movieappviewbindingandcache.Cache.MySharedPreferenceMovie
import com.example.movieappviewbindingandcache.Class.MovieClass
import com.example.movieappviewbindingandcache.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var bindingE: ActivityEditBinding
    lateinit var movieAdapter: MovieAdapter
    lateinit var movieList: ArrayList<MovieClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingE = ActivityEditBinding.inflate(layoutInflater)
        setContentView(bindingE.root)

        movieList = MySharedPreferenceMovie.listSave

        val movieClass = intent.getSerializableExtra("b") as MovieClass
        val position = intent.getIntExtra("p", -1)


        bindingE.nameEditId.setText(movieClass.title)
        bindingE.authorsEditId.setText(movieClass.authors)
        bindingE.aboutEditId.setText(movieClass.subtitle)
        bindingE.dateEditId.setText(movieClass.date)

        bindingE.saveEdit.setOnClickListener {

            if (bindingE.nameEditId.text.toString().trim()
                    .isNotEmpty() && bindingE.authorsEditId.text.toString().trim()
                    .isNotEmpty() && bindingE.aboutEditId.text.toString().trim()
                    .isNotEmpty() && bindingE.dateEditId.text.toString().trim().isNotEmpty()
            ) {

                val movieClass = MovieClass(
                    bindingE.dateEditId.text.toString(),
                    bindingE.nameEditId.text.toString(),
                    bindingE.aboutEditId.text.toString(),
                    bindingE.authorsEditId.text.toString()
                )

                movieList.removeAt(position)
                movieList.add(position,movieClass)

                MySharedPreferenceMovie.listSave = movieList

                Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show()

                finish()

            } else {
                Toast.makeText(this, "Enter isn't wrong", Toast.LENGTH_SHORT).show()
            }

        }


    }
}

