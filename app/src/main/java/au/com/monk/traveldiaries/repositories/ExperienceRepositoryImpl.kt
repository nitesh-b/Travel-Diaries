package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.TestData
import au.com.monk.traveldiaries.data.experienceitem.ExperienceItem
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.datasource.ExperienceItemDataSource

class ExperienceRepositoryImpl : ExperienceRepository {
    private val datasource: ExperienceItemDataSource

    init {
        datasource = ExperienceItemDataSource()
    }
    override suspend fun getItems(
        nextPage: String?,
        numberOfItems: Int?,
    ): ResponseBody<ExperienceItem> {
        var itemSize = 10
        numberOfItems?.let {
            itemSize = it
        }
       return datasource.getVideos(numberOfItems = itemSize)
    }
}