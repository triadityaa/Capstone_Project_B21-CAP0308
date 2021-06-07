package com.jetpackprosubs.capstone.home

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.highsoft.highcharts.Common.HIChartsClasses.*
import com.jetpackprosubs.capstone.R
import com.jetpackprosubs.capstone.databinding.ActivityMainBinding
import com.jetpackprosubs.capstone.databinding.ChartLayoutBinding
import com.jetpackprosubs.capstone.detail.DetailActivity
import com.jetpackprosubs.capstone.report.ReportActivity
import com.jetpackprosubs.capstone.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var chartBinding: ChartLayoutBinding
    private lateinit var mediaPlayer: MediaPlayer
    private var pause: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        chartBinding = binding.chart

        setContentView(binding.root)

        val options = HIOptions()

        val chart= HIChart()
        chart.type = "column"
        options.chart = chart

        val title = HITitle()
        title.text = "Demo chart"

        val subtitle = HISubtitle()
        subtitle.text = "Data Statistic"

        options.title = title
        options.subtitle = subtitle

        val yaxisTitle = HITitle()
        yaxisTitle.text = "Angka"

        val tooltip = HITooltip()
        tooltip.headerFormat = "<span style=\"font-size:15px\">{point.key}</span><table>"
        tooltip.pointFormat = "<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>" + "<td style=\"padding:0\"><b>{point.y}</b></td></tr>"
        tooltip.footerFormat = "</talble>"
        tooltip.shared = true
        tooltip.useHTML = true
        options.tooltip = tooltip

        val plotOption = HIPlotOptions()
        plotOption.column = HIColumn()
        plotOption.column.pointPadding = 0.2
        plotOption.column.borderWidth = 0
        options.plotOptions = plotOption

        val hiyAxis = HIYAxis()
        hiyAxis.min = 0
        hiyAxis.title = yaxisTitle
        options.yAxis = arrayListOf(hiyAxis)

        val hixAxis = HIXAxis()
        val categories = ArrayList<String>()
        categories.add("Semua")
        hixAxis.categories = categories
        options.xAxis = arrayListOf(hixAxis)

        val kaKer = HIColumn()
        kaKer.name = "Kasus Kekerasan"
        val dataKer = ArrayList<Int>()
        dataKer.add(5348)
        kaKer.data = dataKer

        val kerWanita = HIColumn()
        kerWanita.name= getString(R.string.korban_perempuan)
        val dataWanita = ArrayList<Int>()
        dataWanita.add(4622)
        kerWanita.data = dataWanita

        val kerAnak = HIColumn()
        kerAnak.name = getString(R.string.korban_anak_anak)
        val dataAnak = ArrayList<Int>()
        dataAnak.add(3426)
        kerAnak.data = dataAnak

        val series = ArrayList<HISeries>()
        series.add(kaKer)
        series.add(kerWanita)
        series.add(kerAnak)
        options.series = series

        chartBinding.highchart.options = options

        binding.chatActivity.setOnClickListener {
            val chatIntent = Intent(this, ReportActivity::class.java)
            startActivity(chatIntent)
        }
        binding.button.setOnClickListener {
            val detailIntent = Intent(this, DetailActivity::class.java)
            startActivity(detailIntent)
        }
        binding.imageButton.setOnClickListener {
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.darurat)
            mediaPlayer.start()
            pause = false
            Toast.makeText(this, "Memutar suara darurat", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.setting->{
                Intent(this, SettingActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}