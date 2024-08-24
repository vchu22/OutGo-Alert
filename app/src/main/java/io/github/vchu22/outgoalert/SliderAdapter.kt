package io.github.vchu22.outgoalert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class SliderAdapter(
    val context: Context,
    val sliderList: ArrayList<SliderData>
) : PagerAdapter() {

    override fun getCount(): Int {
        // on below line we are returning
        // the size of slider list
        return sliderList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // inside isViewFromobject method we are
        // returning our Relative layout object.
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // in this method we will initialize all our layout
        // items and inflate our layout file as well.
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // below line is use to inflate the
        // layout file which we created.
        val view: View = layoutInflater.inflate(R.layout.item_intro_slider, container, false)

        // on below line we are initializing our image view,
        // heading text view and description text view with their ids.
        val sliderHeading: TextView = view.findViewById(R.id.intro_slide_text_title)
        val imageView: ImageView = view.findViewById(R.id.intro_slide_image)
        val sliderDesc: TextView = view.findViewById(R.id.intro_slide_text_description)

        // on below line we are setting data to our text view
        // and image view on below line.
        val sliderData: SliderData = sliderList.get(position)
        sliderHeading.text = sliderData.slideTitle
        sliderDesc.text = sliderData.slideDescription
        imageView.setImageResource(sliderData.slideImage)

        // on below line we are adding our view to container.
        container.addView(view)

        // on below line we are returning our view.
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // this is a destroy view method
        // which is use to remove a view.
        container.removeView(`object` as RelativeLayout)
    }

}
