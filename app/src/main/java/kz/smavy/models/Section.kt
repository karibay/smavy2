package kz.smavy.models

data class Section(
    val title: String,
    val lessons: List<Lesson>,
    val course: Course
)
