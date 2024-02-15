package au.com.monk.traveldiaries.datasource

import android.util.Log
import au.com.monk.traveldiaries.data.ErrorResponse
import au.com.monk.traveldiaries.data.ResponseBody
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.data.exploreitem.ExploreItemType
import au.com.monk.traveldiaries.enums.ItemTypeEnum

import io.github.serpro69.kfaker.faker
import java.util.UUID


/*Error code init from : 900*/
class ExploreItemDataSource {

    init {

    }

    suspend fun getExploreItems(pageNumber: Int, pageSize: Int): ResponseBody<List<ExploreItem>> {
        try{
            val faker = faker {}
            val datas = (1..pageSize).map { index ->
                Log.d("ExploreItemDataSource", "getExploreItems: ")
                ExploreItem(
                    id = UUID.randomUUID().toString(),
                    userImageThumbnail = String.format("https://picsum.photos/%d/%d", 100, 100),
                    userName = faker.name.firstName() + " " + faker.name.lastName(),
                    userHandle = faker.funnyName.name(),
                    datePostedTS = 1234234234,
                    content = listOf<ExploreItemType>(
                        ExploreItemType(thumbnail = String.format("https://picsum.photos/%d/%d", 800 + index, 800 - index),
                            type = ItemTypeEnum.Image, id = UUID.randomUUID().toString(), false)
                    ),
                    location = faker.address.unique.city() + " " + faker.address.country(),
                    title = faker.quote.famousLastWords(),
                    hasFistBump = false
                )
            }
            return ResponseBody(datas)
        }catch (exception: Exception){
            throw ErrorResponse(detail = "Something went wrong while getting data", errorCode = 901)
        }


    }
}