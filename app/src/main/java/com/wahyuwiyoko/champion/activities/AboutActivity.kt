package com.wahyuwiyoko.champion.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wahyuwiyoko.champion.BuildConfig
import com.wahyuwiyoko.champion.R
import com.wahyuwiyoko.champion.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val byString = resources.getString(R.string.by)
        val devName = resources.getString(R.string.developer_name)

        binding.versionAndDeveloper.text = "v${BuildConfig.VERSION_NAME} $byString $devName"

        binding.repositoryView.setOnClickListener {
            openLinkInBrowser(resources.getString(R.string.source_code_link))
        }

        binding.licenseView.setOnClickListener {
            openLinkInBrowser(resources.getString(R.string.license_link))
        }
    }

    private fun openLinkInBrowser(url: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        } catch (exception: ActivityNotFoundException) {
            Toast.makeText(
                this,
                resources.getString(R.string.no_browser),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}