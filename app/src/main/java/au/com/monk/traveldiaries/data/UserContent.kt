package au.com.monk.traveldiaries.data

import au.com.monk.traveldiaries.enums.ItemTypeEnum

data class UserContent(
    val id: String,
    val source: String,
    val type : ItemTypeEnum
)
