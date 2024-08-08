package io.github.vchu22.outgoalert.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.vchu22.outgoalert.R

class AlertAdapter(private val alertList: ArrayList<Alert>) : RecyclerView.Adapter<AlertAdapter.ViewHolder>() {
    private val weatherIcons = mapOf(
        "Rainy" to R.drawable.weather_cloud_heavy_rain_rain_icon,
        "Snow" to R.drawable.weather_cloud_snow_rain_icon,
        "Freezing Cold" to R.drawable.weather_snow_freeze_icon,
        "Sunny" to R.drawable.weather_sun_hot_icon,
        "High UV" to R.drawable.weather_sun_uv_light_icon,
        "Thunderstorm" to R.drawable.weather_thunderstorm_icon,
        "Pollen" to R.drawable.weather_pollen
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Find our RecyclerView item's ImageView for future use
        val weatherImage: ImageView = view.findViewById(R.id.weather_image)
        var textWeather : TextView = view.findViewById(R.id.text_weather)
        val textInstructions : TextView = view.findViewById(R.id.text_instructions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home_alert_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = alertList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(weatherIcons[alertList[position].weather])
            .centerCrop()
            .into(holder.weatherImage)
        holder.textWeather.text = alertList[position].weather
        holder.textInstructions.text = alertList[position].bringItems
//        holder.weatherImage.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "alert at position $position clicked", Toast.LENGTH_SHORT).show()
//        }
    }

}