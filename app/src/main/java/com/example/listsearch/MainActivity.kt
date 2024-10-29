package com.example.listsearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val students = createStudents()
        adapter = StudentAdapter(students)
        recyclerView.adapter = adapter

        editText = findViewById(R.id.editText)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun createStudents(): List<StudentInfo> {
        return listOf(
            StudentInfo("Vinicius", "20210000"),
            StudentInfo("Ana", "20210001"),
            StudentInfo("Lucas", "20210002"),
            StudentInfo("Sofia", "20210003"),
            StudentInfo("Miguel", "20210004"),
            StudentInfo("Beatriz", "20210005"),
            StudentInfo("Gustavo", "20210006"),
            StudentInfo("Lara", "20210007"),
            StudentInfo("Rafael", "20210008"),
            StudentInfo("Isabela", "20210009"),
            StudentInfo("Bruno", "20210010"),
            StudentInfo("Mariana", "20210011"),
            StudentInfo("Gabriel", "20210012"),
            StudentInfo("Julia", "20210013"),
            StudentInfo("Felipe", "20210014"),
            StudentInfo("Amanda", "20210015"),
            StudentInfo("João", "20210016"),
            StudentInfo("Victoria", "20210017"),
            StudentInfo("Pedro", "20210018"),
            StudentInfo("Camila", "20210019")
        )
    }
}