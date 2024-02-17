package au.com.monk.traveldiaries.data.experienceitem

import au.com.monk.traveldiaries.data.UserAccount

data class Video(
    val id: String,
    val source: String,
    val title: String,
    val subTitle: String?,
    val description: String?,
    val embeddedContent: String?,
    val thumbnail: String? = null,
    var duration: Int?,
    var userAccount: UserAccount?,
    var liked: Boolean,
    var totalLikes: String,
    var shares: String
)
