package kz.smavy

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kz.smavy.models.Course
import kz.smavy.models.CourseDetail

class CourseDetailActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val recyclerCourseContent: ExpandableListView = findViewById(R.id.listview_course_content)
        val course: CourseDetail = savedInstanceState?.getSerializable("course", CourseDetail::class.java) as CourseDetail
        recyclerCourseContent.setAdapter(SectionAdapter(course))
    }
}