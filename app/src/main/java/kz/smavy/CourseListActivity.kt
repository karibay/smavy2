package kz.smavy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class CourseListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        val courses: List<Course> = listOf(Course("Java"), Course("Kotlin"))
        val courseListRecycler: RecyclerView = findViewById(R.id.recycler_course_list)
        courseListRecycler.adapter = CourseListAdapter(courses)
    }
}