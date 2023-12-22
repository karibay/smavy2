package kz.smavy.models

class UserCourse(
    val user: User,
    val course: Course,
    var progress: Int = 0
)