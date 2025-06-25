package com.example.outgoalert

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    // a variable for view pager
    lateinit var viewPager: ViewPager

    // for slider adapter and slider list
    lateinit var sliderAdapter: SliderAdapter
    lateinit var sliderList: ArrayList<SliderData>

    // skip button, slider indicator text view for 3 dots
    lateinit var skipBtn: Button
    lateinit var indicatorSlideOne: TextView
    lateinit var indicatorSlideTwo: TextView
    lateinit var indicatorSlideThree: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        skipBtn = findViewById(R.id.btn_skip)
        indicatorSlideOne = findViewById(R.id.intro_slide_dot_1)
        indicatorSlideTwo = findViewById(R.id.intro_slide_dot_2)
        indicatorSlideThree = findViewById(R.id.intro_slide_dot_3)

        // add click listener for skip button
        skipBtn.setOnClickListener {
            // on below line we are opening a new activity
            val i = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(i)
        }

        // initialize slider list.
        sliderList = ArrayList()

        // add data to list
        sliderList.add(
            SliderData(
                getResources().getString(R.string.title_intro_slide_1),
                getResources().getString(R.string.desc_intro_slide_1),
                R.drawable.intro_slide_1
            )
        )

        sliderList.add(
            SliderData(
                getResources().getString(R.string.title_intro_slide_2),
                getResources().getString(R.string.desc_intro_slide_2),
                R.drawable.intro_slide_2
            )
        )

        sliderList.add(
            SliderData(
                getResources().getString(R.string.title_intro_slide_3),
                getResources().getString(R.string.desc_intro_slide_3),
                R.drawable.intro_slide_3
            )
        )

        // add slider list to adapter class.
        sliderAdapter = SliderAdapter(this, sliderList)

        // set adapter for view pager on below line.
        viewPager.adapter = sliderAdapter

        // add page change listener for view pager.
        viewPager.addOnPageChangeListener(viewListener)

    }

    // create a method for view pager for on page change listener.
    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            // calling the dots method to  change the position of selected dots.
            // on below line we are checking position and updating text view text color.
            if (position == 0) {
                indicatorSlideTwo.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
                indicatorSlideThree.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
                indicatorSlideOne.setTextColor(ContextCompat.getColor(requireContext(), R.color.teal_200))

            } else if (position == 1) {
                indicatorSlideTwo.setTextColor(ContextCompat.getColor(requireContext(), R.color.teal_200))
                indicatorSlideThree.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
                indicatorSlideOne.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            } else {
                indicatorSlideTwo.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
                indicatorSlideThree.setTextColor(ContextCompat.getColor(requireContext(), R.color.teal_200))
                indicatorSlideOne.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            }
        }

        // below method is use to check scroll state.
        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun requireContext(): Context {
        return this
    }
}