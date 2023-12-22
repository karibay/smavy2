package kz.smavy.models

class UserSection(
    val userCourse: UserCourse?,
    val section: Section,
    var hasPassed: Boolean = false
)