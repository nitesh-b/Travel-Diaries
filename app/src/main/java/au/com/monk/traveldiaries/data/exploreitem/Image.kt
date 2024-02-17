package au.com.monk.traveldiaries.data.exploreitem

import au.com.monk.traveldiaries.enums.ItemTypeEnum

data class Image(
    val thumbnail: String,
    val type: ItemTypeEnum,
    val id: String,
    val hasFistBump: Boolean
)
