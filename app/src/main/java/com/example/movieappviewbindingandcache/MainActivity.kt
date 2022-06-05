package com.example.movieappviewbindingandcache

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.movieappviewbindingandcache.Adapters.MovieAdapter
import com.example.movieappviewbindingandcache.Cache.MySharedPreferenceMovie
import com.example.movieappviewbindingandcache.Class.MovieClass
import com.example.movieappviewbindingandcache.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var movieList: ArrayList<MovieClass>
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Movies"


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {

        MySharedPreferenceMovie.init(this)

        movieList = MySharedPreferenceMovie.listSave

        movieAdapter = MovieAdapter(movieList, object : MovieAdapter.OnMyItemClickListener {
            override fun itemClick(movieClass: MovieClass) {
                val intent = Intent(this@MainActivity, DateActivity::class.java)
                intent.putExtra("a",movieClass)
                startActivity(intent)
            }

            override fun itemClickChange(movieClass: MovieClass, position: Int) {
                val intent = Intent(this@MainActivity, EditActivity::class.java)
                intent.putExtra("p",position)
                intent.putExtra("b",movieClass)
                startActivity(intent)
            }

            override fun itemClickDelete(movieClass: MovieClass, position: Int) {
                movieList.remove(movieClass)
                movieAdapter.notifyItemRemoved(position)
                movieAdapter.notifyItemRangeChanged(position, movieList.size)

                MySharedPreferenceMovie.listSave = movieList
            }

        })

        binding.rvId.adapter = movieAdapter

        super.onStart()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        /*val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.my_menu,menu)*/ //menu qalqib chiqadi

        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menuId -> {

                val intent = Intent(this, AddActivity::class.java)

                startActivity(intent)

            }

        }

        return super.onOptionsItemSelected(item)
    }

}