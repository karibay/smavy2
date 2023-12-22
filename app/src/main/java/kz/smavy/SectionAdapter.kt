package kz.smavy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ListAdapter
import android.widget.TextView
import kz.smavy.models.Course
import kz.smavy.models.CourseDetail
import kz.smavy.models.Lesson
import kz.smavy.models.Section

class SectionAdapter(
    private val course: CourseDetail
): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return course.sections.size
    }

    override fun getChildrenCount(position: Int): Int {
        return course.sections[position].lessons.size
    }

    override fun getGroup(position: Int): Any {
        return course.sections[position]
    }

    override fun getChild(sectionPosition: Int, lessonPosition: Int): Any {
        return course.sections[sectionPosition].lessons[lessonPosition]
    }

    override fun getGroupId(position: Int): Long {
        return position.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(listPosition: Int, isLastChild: Boolean, view: View?, parent: ViewGroup?): View {
        var sectionView = view

        val section: Section = getGroup(listPosition) as Section
        if (sectionView == null){
            val inflater: LayoutInflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            sectionView = inflater.inflate(R.layout.section_layout, null)
        }
        val labelSectionTitle: TextView = sectionView!!.findViewById(R.id.label_section_title)
        labelSectionTitle.text = section.title
        return sectionView
    }

    override fun getChildView(listPosition: Int, expandableListPosition: Int, isLastChild: Boolean, view: View?, parent: ViewGroup?): View {
        val lesson: Lesson = getChild(listPosition, expandableListPosition) as Lesson
        var lessonView = view
        if (lessonView == null){
            val inflater: LayoutInflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            lessonView = inflater.inflate(R.layout.lesson_item, null)
        }
        val labelLessonTitle: TextView = lessonView!!.findViewById(R.id.label_lesson_title)
        labelLessonTitle.text = lesson.title
        return lessonView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}