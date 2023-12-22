package kz.smavy.models

class User(
    val login: String,
    private var enrolledTo: Set<UserCourse> = setOf(),
    private var userSections: Set<UserSection> = setOf(),
    private var userLessons: Set<UserLesson> = setOf()
){

    private fun getCorresponding(course: Course): UserCourse? {
        for (userCourse in enrolledTo){
            if (userCourse.course == course){
                return userCourse
            }
        }
        return null
    }
    fun enroll(course: Course){
        val userCourse: UserCourse = UserCourse(this, course)
        enrolledTo += userCourse
    }

    fun attend(lesson: Lesson){
        val userCourse: UserCourse? = getCorresponding(lesson.section.course)
        var userSection: UserSection = UserSection(userCourse, lesson.section)
        val userLesson: UserLesson = UserLesson(userSection, lesson)
    }
}