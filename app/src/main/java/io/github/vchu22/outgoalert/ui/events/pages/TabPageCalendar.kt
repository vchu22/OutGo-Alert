package io.github.vchu22.outgoalert.ui.events.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.vchu22.outgoalert.R

/**
 * A simple [Fragment] subclass.
 */
class TabPageCalendar : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.page_events_calendar, container, false)
    }
}