package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.datasource.ExploreItemDataSource

class ExploreRepositoryImpl : ExploreRepository {
    private val dataSource: ExploreItemDataSource

    init {
        dataSource = ExploreItemDataSource()
    }
    override suspend fun getExploreItems(pageNo: Int, pageSize: Int): ResponseBody<List<ExploreItem>> {
        return dataSource.getExploreItems(pageNo, pageSize)
    }

    override suspend fun updateWow(itemId: String, value: Boolean): ResponseBody<Boolean> {
        return dataSource.updateWow(itemId, value)
    }

    override suspend fun addComment(itemId: String, comment: String): ResponseBody<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun addToBucketList(itemId: String, value: Boolean): ResponseBody<Boolean> {
        return dataSource.updatePackSuitcase(itemId, value)
    }
}