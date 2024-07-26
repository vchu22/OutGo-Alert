package io.github.vchu22.outgoalert.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.vchu22.outgoalert.R
import org.json.JSONObject

class AlertAdapter(alertList: MutableList<JSONObject>) : RecyclerView.Adapter<AlertAdapter.ViewHolder>() {
    private val alertList: List<JSONObject> = alertList

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weatherImage: ImageView
        var textWeather : TextView
        val textInstructions : TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            weatherImage = view.findViewById(R.id.weather_image)
            textWeather = view.findViewById(R.id.text_weather)
            textInstructions = view.findViewById(R.id.text_instructions)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home_alert_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = alertList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide.with(holder.itemView)
//            .load(alertList[position].getString("strMealThumb"))
//            .centerCrop()
//            .into(holder.weatherImage)
//        holder.textWeather.text = alertList[position].getString("strMeal")
//        holder.textInstructions.text = alertList[position].getString("strInstructions")
//        holder.weatherImage.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "alert at position $position clicked", Toast.LENGTH_SHORT).show()
//        }
    }

}