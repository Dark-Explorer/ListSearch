package com.example.listsearch

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val originalList: List<StudentInfo>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(), Filterable {

    private var filteredList: List<StudentInfo> = originalList

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.name)
        private val mssv: TextView = view.findViewById(R.id.mssv)

        fun bind(student: StudentInfo) {
            name.text = student.name
            mssv.text = student.studentId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchText = constraint?.toString()?.lowercase() ?: ""
                val filterResults = FilterResults()

                filteredList = if (searchText.length < 2) {
                    originalList
                } else {
                    originalList.filter { student ->
                        student.name.lowercase().contains(searchText)
                    }
                }

                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                @Suppress("UNCHECKED_CAST")
                filteredList = results?.values as List<StudentInfo>
                notifyDataSetChanged()
            }
        }
    }
}