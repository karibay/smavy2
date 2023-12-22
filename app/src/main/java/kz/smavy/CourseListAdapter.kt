package kz.smavy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.smavy.models.Course

class CourseListAdapter(
    private val courses: List<Course>
):   RecyclerView.Adapter<CourseViewHolder>(), View.OnClickListener {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val courseView = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, true)
        return CourseViewHolder(courseView)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val courseToBind: Course = courses[position]

        holder.labelCourseTitle.text = courseToBind.title

        holder.layoutCourse.tag = courseToBind
        holder.layoutCourse.setOnClickListener(this)
    }

    override fun onClick(courseView: View?) {
        val intent: Intent = Intent(courseView?.context, CourseListActivity::class.java)
        intent.putExtra("course", courseView?.tag as Course)

        courseView.context.startActivity(intent)
    }

}

class CourseViewHolder(courseView: View):
    RecyclerView.ViewHolder(courseView) {
        val layoutCourse: LinearLayout = courseView.findViewById(R.id.layout_course_item)
        val labelCourseTitle: TextView = courseView.findViewById<TextView>(R.id.label_course_title)
}
