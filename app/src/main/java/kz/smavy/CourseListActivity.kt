package kz.smavy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kz.smavy.models.Course

class CourseListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_list)

        val courses: List<Course> = listOf(Course("Java"), Course("Kotlin"))
        val courseListRecycler: RecyclerView = findViewById(R.id.recycler_course_list)
        courseListRecycler.adapter = CourseListAdapter(courses)

//        validateToken()
    }

    private fun validateToken() {
        val token: String? = getToken()
        if (token == ""){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else{
            init()
        }

    }

    private fun getToken(): String? {
        val prefs = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        return prefs.getString("token", "")
    }


    private fun init(){
        Log.println(Log.INFO, "Login", "Initialized")

    }
}