package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.UserContent
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.datasource.UserAccountDataSource

class UserAccountRepositoryImpl : UserAccountRepository {
    private val datasource = UserAccountDataSource()
    override suspend fun getContent(userID: String, nextPage:String): ResponseBody<List<UserContent>> {
        return datasource.getUserContent(userID, nextPage)
    }
}