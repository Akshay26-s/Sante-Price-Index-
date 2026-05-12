package com.example.santeprice.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.santeprice.R

class PriceBoardAdapter(
    context: Context,
    private val items: List<String>
) : ArrayAdapter<String>(context, 0, items) {
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = TextView(context)
        }
        
        val textView = view as TextView
        textView.text = getItem(position)
        textView.textSize = 24f
        textView.setTextColor(context.getColor(R.color.board_text))
        textView.setBackgroundColor(context.getColor(R.color.board_background))
        textView.setPadding(20, 20, 20, 20)
        
        return view
    }
}
