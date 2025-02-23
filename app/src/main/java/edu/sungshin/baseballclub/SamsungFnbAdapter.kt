package edu.sungshin.baseballclub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SamsungFnbAdapter(context: Context, private val items: List<Fnb>) :
    ArrayAdapter<Fnb>(context, R.layout.activity_list_fnb_samsung, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_list_fnb_samsung, parent, false)

        val fnb = items[position]

        val storeName = view.findViewById<TextView>(R.id.store_name_samsung)
        val storeLocation = view.findViewById<TextView>(R.id.store_location_samsung)
        val menu = view.findViewById<TextView>(R.id.menu_samsung)

        storeName.text = fnb.name
        storeLocation.text = fnb.location
        menu.text = fnb.menu

        return view
    }
}