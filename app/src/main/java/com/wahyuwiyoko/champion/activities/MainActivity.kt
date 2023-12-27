package com.wahyuwiyoko.champion.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wahyuwiyoko.champion.R
import com.wahyuwiyoko.champion.databinding.ActivityMainBinding
import com.wahyuwiyoko.champion.models.Champion
import com.wahyuwiyoko.champion.recyclerview.adapters.ListChampionAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvChampions: RecyclerView

    private var list = ArrayList<Champion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar.toolbar)

        rvChampions = binding.rvChampions
        rvChampions.setHasFixedSize(true)

        list.addAll(getListChampions())
        showRecyclerList()
    }

    private fun getListChampions(): ArrayList<Champion> {
        val championName = resources.getStringArray(R.array.champion_name)
        val championSubtitle = resources.getStringArray(R.array.champion_subtitle)
        val championAvatar = resources.obtainTypedArray(R.array.champion_avatar)
        val championBanner = resources.obtainTypedArray(R.array.champion_banner)
        val championDescription = resources.getStringArray(R.array.champion_description)
        val championAbilities = resources.obtainTypedArray(R.array.champion_abilities)
        val championUrl = resources.getStringArray(R.array.champion_url)
        val listChampion = ArrayList<Champion>()

        for (i in championName.indices) {
            val champion = Champion(
                championName[i], championSubtitle[i],
                championAvatar.getResourceId(i, -1), championBanner.getResourceId(i, -1),
                championDescription[i], championAbilities.getResourceId(i, -1),
                championUrl[i]
            )

            listChampion.add(champion)
        }

        return listChampion
    }

    private fun showRecyclerList() {
        rvChampions.layoutManager = LinearLayoutManager(this)
        val listChampionAdapter = ListChampionAdapter(list)
        rvChampions.adapter = listChampionAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}