package au.com.monk.traveldiaries.datasource

import au.com.monk.traveldiaries.data.TestData
import au.com.monk.traveldiaries.data.experienceitem.ExperienceItem
import au.com.monk.traveldiaries.data.experienceitem.Video
import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ResponseBody
import io.github.serpro69.kfaker.faker
import java.util.UUID

/*Error code init from : 1000*/
class ExperienceItemDataSource {

    suspend fun getVideos(
        nextPage: String? = "",
        numberOfItems: Int = 10,
    ): ResponseBody<ExperienceItem> {
        try {
            val testData = TestData()
            val item = testData.getFakeExperienceItem(numberOfItems)
            return ResponseBody(item)

        } catch (exception: Exception) {
            throw ErrorResponse(detail = "Something went wrong while getting data", 1001)
        }

    }
}