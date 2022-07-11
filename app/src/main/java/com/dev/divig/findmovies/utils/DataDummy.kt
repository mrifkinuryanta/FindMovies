package com.dev.divig.findmovies.utils

import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.data.source.remote.response.movie.*
import com.dev.divig.findmovies.data.source.remote.response.movie.GenresItem
import com.dev.divig.findmovies.data.source.remote.response.movie.ProductionCompaniesItem
import com.dev.divig.findmovies.data.source.remote.response.movie.ProductionCountriesItem
import com.dev.divig.findmovies.data.source.remote.response.movie.SpokenLanguagesItem
import com.dev.divig.findmovies.data.source.remote.response.tv.*

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                567189,
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Action, Adventure, Thriller, War",
                "2021-04-29",
                109,
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                false
            ),
            MovieEntity(
                460465,
                "Mortal Kombat",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Action, Adventure, Thriller, War",
                "2021-04-29",
                109,
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                false
            ),
            MovieEntity(
                399566,
                "Godzilla vs. Kong",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Action, Adventure, Thriller, War",
                "2021-04-29",
                109,
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                false
            ),
            MovieEntity(
                615678,
                "Thunder Force",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Action, Adventure, Thriller, War",
                "2021-04-29",
                109,
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                false
            ),
            MovieEntity(
                615457,
                "Nobody",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Action, Adventure, Thriller, War",
                "2021-04-29",
                109,
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                false
            )
        )
    }

    fun getTvShows(): List<TvShowsEntity> {
        return listOf(
            TvShowsEntity(
                60735,
                "The Flash",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "2021-05-07",
                45,
                7.5,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            ),
            TvShowsEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "2021-05-07",
                45,
                7.5,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            ),
            TvShowsEntity(
                71712,
                "The Good Doctor",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "2021-05-07",
                45,
                7.5,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            ),
            TvShowsEntity(
                95557,
                "Invincible",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "2021-05-07",
                45,
                7.5,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            ),
            TvShowsEntity(
                93484,
                "Jupiter's Legacy",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "2021-05-07",
                45,
                7.5,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            )
        )
    }

    fun getMovieDetail(): MovieEntity {
        return MovieEntity(
            567189,
            "Tom Clancy's Without Remorse",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            "Action, Adventure, Thriller, War",
            "2021-04-29",
            109,
            7.3,
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
            false
        )
    }

    fun getTvShowsDetail(): TvShowsEntity {
        return TvShowsEntity(
            93484,
            "Jupiter's Legacy",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            "Sci-Fi & Fantasy, Action & Adventure, Drama",
            "2021-05-07",
            45,
            7.5,
            "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
            "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            false
        )
    }

    fun getRemoteMovies(): List<MovieItem> {
        return listOf(
            MovieItem(
                false,
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                listOf(28, 12, 53, 10752),
                567189,
                "en",
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                4547.446,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "2021-04-29",
                "Tom Clancy's Without Remorse",
                false,
                7.3,
                829
            ),
            MovieItem(
                false,
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                listOf(28, 14, 12),
                460465,
                "en",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                3345.294,
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "2021-04-07",
                "Mortal Kombat",
                false,
                7.7,
                2429
            ),
            MovieItem(
                false,
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                listOf(878, 28, 18),
                399566,
                "en",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                1833.731,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                false,
                8.1,
                5455
            ),
            MovieItem(
                false,
                "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                listOf(28, 12, 35, 14),
                615678,
                "en",
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                963.154,
                "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "2021-04-09",
                "Thunder Force",
                false,
                5.8,
                556
            ),
            MovieItem(
                false,
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                listOf(28, 53, 80, 35),
                615457,
                "en",
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                1803.573,
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "2021-03-26",
                "Nobody",
                false,
                8.4,
                1423
            )
        )
    }

    fun getRemoteTvShows(): List<TvShowsItem> {
        return listOf(
            TvShowsItem(
                "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                "2014-10-07",
                listOf(18, 10765),
                60735,
                "The Flash",
                listOf("US"),
                "en",
                "en",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                1026.489,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                7596
            ),
            TvShowsItem(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                listOf(10765, 10759, 18, 10768),
                88396,
                "The Falcon and the Winter Soldier",
                listOf("US"),
                "en",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                1306.109,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5484
            ),
            TvShowsItem(
                "/zlXPNnnUlyg6KyvvjGd2ZxG6Tnw.jpg",
                "2017-09-25",
                listOf(18),
                71712,
                "The Good Doctor",
                listOf("US"),
                "en",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                1045.03,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                8.6,
                8365
            ),
            TvShowsItem(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                listOf(16, 10759, 18, 10765),
                95557,
                "Invincible",
                listOf("US"),
                "en",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                1055.08,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9,
                1611
            ),
            TvShowsItem(
                "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
                "2021-05-07",
                listOf(10765, 10756, 18),
                93484,
                "Jupiter's Legacy",
                listOf("US"),
                "en",
                "Jupiter's Legacy",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                1182.741,
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                7.5,
                170
            )
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            false,
            "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
            null,
            0,
            listOf(
                GenresItem(
                    28,
                    "Action"
                ),
                GenresItem(
                    12,
                    "Adventure"
                ),
                GenresItem(
                    53,
                    "Thriller"
                ),
                GenresItem(
                    10752,
                    "War"
                )
            ),
            "https://www.amazon.com/dp/B08VFD1Y3B",
            567189,
            "tt0499097",
            "en",
            "Tom Clancy's Without Remorse",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            4547.446,
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            listOf(
                ProductionCompaniesItem(
                    4,
                    "/fycMZt242LVjagMByZOLUGbCvv3.png",
                    "Paramount",
                    "US"
                ),
                ProductionCompaniesItem(
                    433,
                    null,
                    "Weed Road Pictures",
                    "US"
                ),
                ProductionCompaniesItem(
                    82819,
                    "/5Z8WWr0Lf1tInVWwJsxPP0uMz9a.png",
                    "Skydance Media",
                    "US"
                ),
                ProductionCompaniesItem(
                    51593,
                    null,
                    "Midnight Radio",
                    "US"
                ),
                ProductionCompaniesItem(
                    102334,
                    "/espa8KYmHedu5p7GRrP9FFICLUp.png",
                    "Outlier Society Productions",
                    "US"
                ),
                ProductionCompaniesItem(
                    114732,
                    "/tNCbisMxO5mX2X2bOQxHHQZVYnT.png",
                    "New Republic Pictures",
                    "US"
                ),
                ProductionCompaniesItem(
                    20580,
                    "/tkFE81jJIqiFYPP8Tho57MXRQEx.png",
                    "Amazon Studios",
                    "US"
                )
            ),
            listOf(
                ProductionCountriesItem(
                    "US",
                    "United States of America"
                )
            ),
            "2021-04-29",
            0,
            109,
            listOf(
                SpokenLanguagesItem(
                    "English",
                    "en",
                    "English"
                )
            ),
            "Released",
            "",
            "Tom Clancy's Without Remorse",
            false,
            7.3,
            837
        )
    }

    fun getRemoteDetailTvShows(): TvShowsDetailResponse {
        return TvShowsDetailResponse(
            "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
            listOf(
                CreatedByItem(
                    1213074,
                    "5fe4946031644b0040f84e04",
                    "Steven S. DeKnight",
                    2,
                    "/5AsVXNHJTqhxfwxfhxKe7eeKMUu.jpg"
                )
            ),
            listOf(45),
            "2021-05-07",
            listOf(
                com.dev.divig.findmovies.data.source.remote.response.tv.GenresItem(
                    10765,
                    "Sci-Fi & Fantasy"
                ),
                com.dev.divig.findmovies.data.source.remote.response.tv.GenresItem(
                    10759,
                    "Action & Adventure"
                ),
                com.dev.divig.findmovies.data.source.remote.response.tv.GenresItem(
                    18,
                    "Drama"
                )
            ),
            "https://www.netflix.com/title/80244953",
            93484,
            true,
            listOf("en"),
            "2021-05-07",
            LastEpisodeToAir(
                "2021-05-07",
                8,
                2584271,
                "How It All Ends",
                "As Walter's situation grows dire, Sheldon and Brandon join forces in a do-or-die showdown with a supervillain. Hutch runs into trouble during a heist.",
                "",
                1,
                "/nsyd0XggnfX0STjJTTxth7zk6hk.jpg",
                0.0,
                0
            ),
            "Jupiter's Legacy",
            null,
            listOf(
                NetworksItem(
                    "Netflix",
                    213,
                    "/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                    ""
                )
            ),
            8,
            1,
            listOf("US"),
            "en",
            "Jupiter's Legacy",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            1182.741,
            "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
            listOf(
                com.dev.divig.findmovies.data.source.remote.response.tv.ProductionCompaniesItem(
                    435,
                    "/AjzK0s2w1GtLfR4hqCjVSYi0Sr8.png",
                    "Di Bonaventura Pictures",
                    "US"
                ),
                com.dev.divig.findmovies.data.source.remote.response.tv.ProductionCompaniesItem(
                    51963,
                    null,
                    "DeKnight Productions",
                    "US"
                ),
                com.dev.divig.findmovies.data.source.remote.response.tv.ProductionCompaniesItem(
                    146221,
                    null,
                    "Millarworld Production",
                    ""
                )
            ),
            listOf(
                com.dev.divig.findmovies.data.source.remote.response.tv.ProductionCountriesItem(
                    "US",
                    "United States of America"
                )
            ),
            listOf(
                SeasonsItem(
                    "2021-05-07",
                    8,
                    132121,
                    "Volume 1",
                    "They're the first generation of superheroes. But as they pass the torch to their children, tensions are rising — and the old rules no longer apply.",
                    "/gSFDXb6IMXDSdw4avtzCVWouIfk.jpg",
                    1
                )
            ),
            listOf(
                com.dev.divig.findmovies.data.source.remote.response.tv.SpokenLanguagesItem(
                    "English",
                    "en",
                    "English"
                )
            ),
            "Returning Series",
            "No legacy lives forever.",
            "Scripted",
            7.5,
            176
        )
    }
}