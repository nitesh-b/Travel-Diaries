package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.experienceitem.ExperienceItem

interface ExperienceRepository {
    suspend fun getItems(nextPage: String?, numberOfItems: Int?): ResponseBody<ExperienceItem>
}

