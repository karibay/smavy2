package kz.smavy.models

class UserLesson(
    val userSection: UserSection,
    var hasPassed: Boolean = false
)