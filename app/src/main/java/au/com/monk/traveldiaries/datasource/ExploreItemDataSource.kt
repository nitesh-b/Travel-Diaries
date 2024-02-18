package au.com.monk.traveldiaries.datasource

import au.com.monk.traveldiaries.data.TestData
import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem

import io.github.serpro69.kfaker.faker


/*Error code init from : 900*/
class ExploreItemDataSource {
    private val testData = TestData()

    suspend fun getExploreItems(pageNumber: Int, pageSize: Int): ResponseBody<List<ExploreItem>> {
        try{
            val faker = faker {}
            val datas = (1..pageSize).map { index ->
                  testData.getFakeExploreItem()
            }
            return ResponseBody(datas)
        }catch (exception: Exception){
            throw ErrorResponse(detail = "Something went wrong while getting data", errorCode = 901)
        }


    }

    suspend fun updateWow(itemID: String, value: Boolean): ResponseBody<Boolean> {
        try{

            return ResponseBody(!value)
        }catch (exception: Exception){
            throw ErrorResponse(detail = "Something went wrong while getting data", errorCode = 902)
        }
    }

    suspend fun updatePackSuitcase(itemID: String, value: Boolean): ResponseBody<Boolean> {
        try{
            return ResponseBody(!value)
        }catch (exception: Exception){
            throw ErrorResponse(detail = "Something went wrong while getting data", errorCode = 903)
        }


    }
}