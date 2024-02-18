package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.UserContent
import au.com.monk.traveldiaries.data.generic.ResponseBody

interface UserAccountRepository {
    suspend fun getContent(userID: String, nextPage:String): ResponseBody<List<UserContent>>
}