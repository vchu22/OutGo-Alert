package io.github.vchu22.outgoalert

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    // on below line we are creating a
    // variable for our view pager
    lateinit var viewPager: ViewPager

    // on below line we are creating a variable
    // for our slider adapter and slider list
    lateinit var sliderAdapter: SliderAdapter
    lateinit var sliderList: ArrayList<SliderData>

    // on below line we are creating a variable for our
    // skip button, slider indicator text view for 3 dots
    lateinit var skipBtn: Button
    lateinit var indicatorSlideOneTV: TextView
    lateinit var indicatorSlideTwoTV: TextView
    lateinit var indicatorSlideThreeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on below line we are initializing all
        // our variables with their ids.
        viewPager = findViewById(R.id.idViewPager)
        skipBtn = findViewById(R.id.idBtnSkip)
        indicatorSlideOneTV = findViewById(R.id.idTVSlideOne)
        indicatorSlideTwoTV = findViewById(R.id.idTVSlideTwo)
        indicatorSlideThreeTV = findViewById(R.id.idTVSlideThree)

        // on below line we are adding click listener for our skip button
        skipBtn.setOnClickListener {
            // on below line we are opening a new activity
            val i = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(i)
        }

        // on below line we are initializing our slider list.
        sliderList = ArrayList()

        // on below line we are adding data to our list
        sliderList.add(
            SliderData(
                getResources().getString(R.string.intro_slide_1_title),
                getResources().getString(R.string.intro_slide_1_text),
                R.drawable.intro_slide_1
            )
        )

        sliderList.add(
            SliderData(
                getResources().getString(R.string.intro_slide_2_title),
                getResources().getString(R.string.intro_slide_2_text),
                R.drawable.intro_slide_2
            )
        )

        sliderList.add(
            SliderData(
                getResources().getString(R.string.intro_slide_3_title),
                getResources().getString(R.string.intro_slide_3_text),
                R.drawable.intro_slide_3
            )
        )

        // on below line we are adding slider list
        // to our adapter class.
        sliderAdapter = SliderAdapter(this, sliderList)

        // on below line we are setting adapter
        // for our view pager on below line.
        viewPager.adapter = sliderAdapter

        // on below line we are adding page change
        // listener for our view pager.
        viewPager.addOnPageChangeListener(viewListener)

    }

    // creating a method for view pager for on page change listener.
    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            // we are calling our dots method to
            // change the position of selected dots.
            // on below line we are checking position and updating text view text color.
            if (position == 0) {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.teal_200))

            } else if (position == 1) {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.teal_200))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.grey))
            } else {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.teal_200))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.grey))
            }
        }

        // below method is use to check scroll state.
        override fun onPageScrollStateChanged(state: Int) {}
    }
}

//import android.os.Bundle
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import io.github.vchu22.outgoalert.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
////        val homeScreenBinding = binding.homeScreenLayout
////        val navView: BottomNavigationView = homeScreenBinding.navView
//
////        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
////        val appBarConfiguration = AppBarConfiguration(
////            setOf(
////                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
////            )
////        )
////        setupActionBarWithNavController(navController, appBarConfiguration)
////        navView.setupWithNavController(navController)
//    }
//}