package by.tomal.cleancode.presentation.ui.vehicle.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vehicle_list_item.view.*

class VehicleListItemHolder(view: View): RecyclerView.ViewHolder(view) {
    val cardView = view.itemCardView
    val type = view.fleetTypeTextView
    val heading = view.headingTextView
    val coordinates = view.coordinatesTextView
}