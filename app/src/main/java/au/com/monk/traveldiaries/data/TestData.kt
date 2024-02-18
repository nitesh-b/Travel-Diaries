package au.com.monk.traveldiaries.data

import au.com.monk.traveldiaries.data.experienceitem.ExperienceItem
import au.com.monk.traveldiaries.data.experienceitem.Video
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.data.exploreitem.Image
import au.com.monk.traveldiaries.enums.ItemTypeEnum
import au.com.monk.traveldiaries.utils.date.DateFormatter
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.faker
import java.util.UUID
import kotlin.random.Random
import kotlin.random.nextInt

class TestData {

    val videoList = listOf(
        Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            title = "Big Buck Bunny",
            subTitle = "By Blender Foundation",
            description = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge.\n\nLicensed under the Creative Commons Attribution license\nhttp://www.bigbuckbunny.org",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            title = "Elephant Dream",
            subTitle = "By Blender Foundation",
            description = "The first Blender Open Movie from 2006",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            title = "For Bigger Blazes",
            subTitle = "By Google",
            description = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For $35.\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            title = "For Bigger Escape",
            subTitle = "By Google",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when Batman's escapes aren't quite big enough. For $35. Learn how to use Chromecast with Google Play Movies and more at google.com/chromecast.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            title = "For Bigger Fun",
            subTitle = "By Google",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For $35.  Find out more at google.com/chromecast.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
            title = "For Bigger Joyrides",
            subTitle = "By Google",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For $35. Learn how to use Chromecast with YouTube and more at google.com/chromecast.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            title = "For Bigger Meltdowns",
            subTitle = "By Google",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For $35. Learn how to use Chromecast with Netflix and more at google.com/chromecast.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            title = "Sintel",
            subTitle = "By Blender Foundation",
            description = "Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender. With initial funding provided by 1000s of donations via the internet community, it has again proven to be a viable development model for both open 3D technology as for independent animation film.\nThis 15 minute film has been realized in the studio of the Amsterdam Blender Institute, by an international team of artists and developers. In addition to that, several crucial technical and creative targets have been realized online, by developers and artists and teams all over the world.\nwww.sintel.org",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
            title = "Subaru Outback On Street And Dirt",
            subTitle = "By Garage419",
            description = "Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            title = "Tears of Steel",
            subTitle = "By Blender Foundation",
            description = "Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
            title = "Volkswagen GTI Review",
            subTitle = "By Garage419",
            description = "The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see...",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            title = "We Are Going On Bullrun",
            subTitle = "By Garage419",
            description = "The Smoking Tire is going on the 2010 Bullrun Live Rally in a 2011 Shelby GT500, and posting a video from the road every single day! The only place to watch them is by subscribing to The Smoking Tire or watching at BlackMagicShine.com",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        ), Video(
            id = UUID.randomUUID().toString(),
            source = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4",
            title = "What care can you get for a grand?",
            subTitle = "By Garage419",
            description = "The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car.The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car.",
            liked = false,
            totalLikes = "0",
            shares = "0",
            duration = 0,
            userAccount = null,
            embeddedContent = null
        )
    )

    private val faker : Faker

    init {
        faker = faker {  }
    }
    

    fun getFakeUserAccount(): UserAccount {
        val name = faker.name
        val userAccount = UserAccount(
            firstName = name.firstName(),
            lastName = name.lastName(),
            name = name.name(),
            id = UUID.randomUUID().toString(),
            dateOfBirthTS = DateFormatter.currentTS() - Random.nextLong(594217910,1124217912 ),
            userHandle = String.format("@%s_%s", name.firstName(),faker.random.nextChar().toString()),
            email = String.format("@%s_%s@%s.com", name.firstName(),faker.random.nextChar().toString(), faker.pokemon.names())

        )
        return userAccount
    }

    fun getFakeVideo(): Video {
        val videoItem = videoList[Random.nextInt(0, videoList.size)]
        videoItem.userAccount = getFakeUserAccount()
        videoItem.liked = Random.nextBoolean()
        val randomInt = Random.nextInt()

        var totalLikes = ""
        if(randomInt < 1000){
            totalLikes = String.format("%d", randomInt)
        }else if (randomInt < 1000000){
            totalLikes = String.format("%.2fK", randomInt/1000)
        }else if (randomInt < 100000000){
            totalLikes = String.format("%.2fM", randomInt/1000000)
        }
        videoItem.totalLikes = totalLikes

        var shares = ""
        if(randomInt < 1000){
            shares = String.format("%d", randomInt)
        }else if (randomInt < 1000000){
            shares = String.format("%.2fK", randomInt/1000)
        }else if (randomInt < 100000000){
            shares = String.format("%.2fM", randomInt/1000000)
        }
        videoItem.shares = shares
        
        return videoItem
    }

    fun getFakeExperienceItem(noOfItems: Int): ExperienceItem {
        val videos: MutableList<Video> = mutableListOf()
        val totalItems = Math.min(videoList.size - 1, noOfItems)
        for (index in 0..totalItems){
            videos += getFakeVideo()
        }
        return ExperienceItem(videos, "", "")
    }

    fun getFakeExploreItem(): ExploreItem {
        val item = ExploreItem(
            id = UUID.randomUUID().toString(),
            userImageThumbnail = String.format("https://picsum.photos/%d/%d", 100, 100),
            userName = faker.name.firstName() + " " + faker.name.lastName(),
            userHandle = faker.funnyName.name(),
            dateUploadedTS = DateFormatter.currentTS() - Random.nextInt(0..60*60*24),
            content = listOf<Image>(
                Image(thumbnail = String.format("https://picsum.photos/%d/%d", 800 + Random.nextInt(100..800), 800 + Random.nextInt(100..800)),
                    type = ItemTypeEnum.Image, id = UUID.randomUUID().toString(), false)
            ),
            location = faker.address.unique.city() + " " + faker.address.country(),
            title = faker.quote.famousLastWords(),
            hasFistBump = Random.nextBoolean(),
            packSuitcase = Random.nextBoolean()
        )
        return item
    }

}