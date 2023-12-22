package kz.smavy.models

import java.io.Serializable

data class CourseDetail(
    val title: String,
    val thumbnailURL: String,
    val sections: List<Section>
): Serializable
