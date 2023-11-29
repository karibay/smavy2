package kz.smavy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseListAdapter(
    private val courses: List<Course>
):   RecyclerView.Adapter<CourseViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val courseView = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(courseView)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val courseToBind: Course = courses[position]
        holder.labelCourseTitle.text = courseToBind.title
    }

}

class CourseViewHolder(courseView: View):
    RecyclerView.ViewHolder(courseView) {
        val labelCourseTitle: TextView = courseView.findViewById<TextView>(R.id.label_course_title)
}
