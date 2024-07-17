package io.github.vchu22.outgoalert

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    // a variable for view pager
    lateinit var viewPager: ViewPager

    // for slider adapter and slider list
    lateinit var sliderAdapter: SliderAdapter
    lateinit var sliderList: ArrayList<SliderData>

    // skip button, slider indicator text view for 3 dots
    lateinit var skipBtn: Button
    lateinit var indicatorSlideOneTV: TextView
    lateinit var indicatorSlideTwoTV: TextView
    lateinit var indicatorSlideThreeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.idViewPager)
        skipBtn = findViewById(R.id.idBtnSkip)
        indicatorSlideOneTV = findViewById(R.id.idTVSlideOne)
        indicatorSlideTwoTV = findViewById(R.id.idTVSlideTwo)
        indicatorSlideThreeTV = findViewById(R.id.idTVSlideThree)

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