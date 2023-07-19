package com.example.calculatorapp

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.content.ClipboardManager

class HistoryAdapter: ListAdapter<History, HistoryAdapter.ViewHolder>(HistoryComparator()) {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val input: TextView = itemView.findViewById(R.id.expression)
        val output: TextView = itemView.findViewById(R.id.result)
        init {
            input.setOnLongClickListener {
                // Handle the long-press action here
                val clipboardManager =
                    itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("Expression", input.text)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(itemView.context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
                true // Return true to indicate that the long-click event has been consumed
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.input.text = item.inputString
        holder.output.text = item.outputString
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.history_item, parent, false)
        return ViewHolder(view)
    }

    class HistoryComparator: DiffUtil.ItemCallback<History>() {
        override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem == newItem
        }
    }

}