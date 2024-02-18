package au.com.monk.traveldiaries.datasource

import au.com.monk.traveldiaries.data.TestData
import au.com.monk.traveldiaries.data.UserContent
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.enums.ItemTypeEnum
import io.github.serpro69.kfaker.faker
import java.util.UUID
import kotlin.random.Random
import kotlin.random.nextInt

class UserAccountDataSource {
    private val testData = TestData()
    private val faker = faker {  }


    suspend fun getUserContent(userID: String, nextPage:String) : ResponseBody<List<UserContent>>{
        val pageSize = 20
        val usrContent = mutableListOf<UserContent>()
        for (i in 1..pageSize){
            val item = UserContent(
                id = UUID.randomUUID().toString(),
                source = String.format("https://picsum.photos/%d/%d", 800 + Random.nextInt(100..800), 800 + Random.nextInt(100..800)),
                type = ItemTypeEnum.Image
                )
            usrContent += item
        }

        return ResponseBody(usrContent)
    }
}