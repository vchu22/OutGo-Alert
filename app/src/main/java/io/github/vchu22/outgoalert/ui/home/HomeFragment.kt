package io.github.vchu22.outgoalert.ui.home

import android.content.res.Resources
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.vchu22.outgoalert.databinding.FragmentHomeBinding

data class Alert(val imageUrl: String, val weather: String, val bringItems: String)
class HomeFragment : Fragment() {
    private lateinit var alertAdapter: AlertAdapter
    private var alertList = ArrayList<Alert>()
    private lateinit var activeAlertsRecyclerView: RecyclerView
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewHomeLocation: TextView = binding.editTextHomeLocation
        homeViewModel.text.observe(viewLifecycleOwner) {
            textViewHomeLocation.text = it
        }

        // active alerts section
        loadActiveAlerts()

        activeAlertsRecyclerView = binding.activeAlertsRecyclerView
        alertAdapter = AlertAdapter(alertList)
        activeAlertsRecyclerView.layoutManager = LinearLayoutManager(this.context)
        activeAlertsRecyclerView.adapter = alertAdapter

        return root
    }

    private fun loadActiveAlerts() {
        alertList.add(Alert("", "Rainy", "Umbrella, Rain Coat"))
        alertList.add(Alert("", "Snow", "Boots, Coat, Sweater"))
        alertList.add(Alert("", "Sunny", "Sunglasses"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}