package com.wahyuwiyoko.champion.activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wahyuwiyoko.champion.databinding.ActivityDetailBinding
import com.wahyuwiyoko.champion.models.Champion

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_CHAMPION = "extra_champion"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataChampion = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CHAMPION, Champion::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CHAMPION)
        }

        if (dataChampion != null) {
            binding.tvDetailName.text = dataChampion.name
            binding.tvDetailSubtitle.text = dataChampion.subtitle
            binding.imgDetailAvatar.setImageResource(dataChampion.avatar)
        }
    }
}