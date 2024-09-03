package io.github.vchu22.outgoalert.ui.alerts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.github.vchu22.outgoalert.databinding.FragmentAlertsBinding

class AlertsFragment : Fragment() {

    private var _binding: FragmentAlertsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val alertsViewModel =
            ViewModelProvider(this).get(AlertsViewModel::class.java)

        _binding = FragmentAlertsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}