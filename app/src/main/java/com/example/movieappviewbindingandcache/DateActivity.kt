package com.example.movieappviewbindingandcache

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieappviewbindingandcache.Class.MovieClass
import com.example.movieappviewbindingandcache.databinding.ActivityDateBinding

class DateActivity : AppCompatActivity() {

    private lateinit var bindingD: ActivityDateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingD = ActivityDateBinding.inflate(layoutInflater)
        setContentView(bindingD.root)

        val movieClass = intent.getSerializableExtra("a") as MovieClass

        bindingD.movieNameId.text = movieClass.title
        bindingD.movieAuthorsId.text = movieClass.authors
        bindingD.movieAboutId.text = movieClass.subtitle
        bindingD.movieDateId.text = movieClass.date


    }
}