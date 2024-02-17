package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem

interface ExploreRepository {
    suspend fun getExploreItems(pageNo: Int, pageSize: Int): ResponseBody<List<ExploreItem>>
    suspend fun updateFistBump(itemId: String, value: Boolean): ResponseBody<Boolean>
    suspend fun addComment(itemId: String, comment: String): ResponseBody<Boolean>
    suspend fun addToBucketList(itemId: String, value:Boolean): ResponseBody<Boolean>

}