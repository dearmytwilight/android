package edu.sungshin.baseballclub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class HanhwaFnbAdapter(context: Context, private val items: List<Fnb>) :
    ArrayAdapter<Fnb>(context, R.layout.activity_list_fnb_hanhwa, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_list_fnb_hanhwa, parent, false)

        val fnb = items[position]

        val storeName = view.findViewById<TextView>(R.id.store_name_hanhwa)
        val storeLocation = view.findViewById<TextView>(R.id.store_location_hanhwa)
        val menu = view.findViewById<TextView>(R.id.menu_hanhwa)

        storeName.text = fnb.name
        storeLocation.text = fnb.location
        menu.text = fnb.menu

        return view
    }
}