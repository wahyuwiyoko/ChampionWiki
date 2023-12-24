package com.wahyuwiyoko.champion.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.wahyuwiyoko.champion.R
import com.wahyuwiyoko.champion.databinding.ActivityDetailBinding
import com.wahyuwiyoko.champion.models.Champion

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var shareIntent: Intent
    private lateinit var championUrl: String

    companion object {
        const val EXTRA_CHAMPION = "extra_champion"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val toolbar = binding.toolbarDetail.toolbar

        setContentView(binding.root)

        val champion = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CHAMPION, Champion::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CHAMPION)
        }

        if (champion != null) {
            binding.tvDetailName.text = champion.name
            binding.tvDetailSubtitle.text = champion.subtitle
            binding.imgDetailBanner.setImageResource(champion.banner)
            binding.tvDetailDescription.text = champion.description
            binding.toolbarDetail.toolbar.title = champion.name
            championUrl = champion.url

            toolbar.title = champion.name
            setSupportActionBar(toolbar)

            val abilitiesId = resources.obtainTypedArray(champion.ability)
            val abilityNames = ArrayList<String>()
            val abilityDescriptions = ArrayList<String>()

            for (itemId in 0..<abilitiesId.length()) {
                val abilitiesItem = abilitiesId.getResourceId(itemId, -1)
                val ability = resources.getStringArray(abilitiesItem)

                abilityNames.add(ability[0])
                abilityDescriptions.add(ability[1])
            }

            val abilityBinding = binding.includeChampionAbilities

            abilityBinding.textPassive.text = abilityNames[0]
            abilityBinding.textFirstAbility.text = abilityNames[1]
            abilityBinding.textSecondAbility.text = abilityNames[2]
            abilityBinding.textThirdAbility.text = abilityNames[3]
            abilityBinding.textFourthAbility.text = abilityNames[4]

            abilityBinding.textPassiveDescription.text = abilityDescriptions[0]
            abilityBinding.textFirstAbilityDescription.text = abilityDescriptions[1]
            abilityBinding.textSecondAbilityDescription.text = abilityDescriptions[2]
            abilityBinding.textThirdAbilityDescription.text = abilityDescriptions[3]
            abilityBinding.textFourthAbilityDescription.text = abilityDescriptions[4]
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, championUrl)
        }

        shareIntent = Intent.createChooser(sendIntent, null)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_share -> startActivity(shareIntent)
        }

        return super.onOptionsItemSelected(menuItem)
    }
}