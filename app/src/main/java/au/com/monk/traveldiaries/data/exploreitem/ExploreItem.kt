package au.com.monk.traveldiaries.data.exploreitem

data class ExploreItem(
    val id: String,
    val userImageThumbnail: String,
    val userName: String,
    val userHandle: String,
    val datePostedTS: Long,
    val content: List<ExploreItemType>,
    val location: String,
    val title: String?,
    val hasFistBump: Boolean
)
