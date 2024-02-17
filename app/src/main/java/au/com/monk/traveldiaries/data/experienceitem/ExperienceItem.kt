package au.com.monk.traveldiaries.data.experienceitem

data class ExperienceItem(
    val video: List<Video>,
    val previousPage: String,
    val nextPage: String //Generated autheticated URL that creates the list of next videos
)
