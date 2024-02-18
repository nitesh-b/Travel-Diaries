package au.com.monk.traveldiaries.data.exploreitem

data class ExploreItem(
    val id: String,
    val userImageThumbnail: String,
    val userName: String,
    val userHandle: String,
    val dateUploadedTS: Long,
    val content: List<Image>,
    val location: String,
    val title: String?,
    var hasFistBump: Boolean,
    var packSuitcase: Boolean
)
