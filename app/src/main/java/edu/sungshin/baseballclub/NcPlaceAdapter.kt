package edu.sungshin.baseballclub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class NcPlaceAdapter(context: Context, private val resource: Int, private val items: List<Place>) :
    ArrayAdapter<Place>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
        val nameTextView: TextView = view.findViewById(R.id.facility_name_nc)
        val locationTextView: TextView = view.findViewById(R.id.facility_location_nc)

        val place = items[position]
        nameTextView.text = place.name
        locationTextView.text = place.location

        return view
    }
}