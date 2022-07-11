package com.dev.divig.findmovies.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dev.divig.findmovies.R
import com.dev.divig.findmovies.utils.DataDummy
import com.dev.divig.findmovies.utils.EspressoIdlingResource
import org.hamcrest.Matchers.isEmptyOrNullString
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.getMovies()
    private val dummyTvShows = DataDummy.getTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.toolbar_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_layout)).check(
            matches(
                not(
                    withContentDescription(
                        isEmptyOrNullString()
                    )
                )
            )
        )
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(not(withText(isEmptyOrNullString()))))
    }

    @Test
    fun load_tv_shows_and_load_detail_tv_shows() {
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        onView(withId(R.id.toolbar_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_layout)).check(
            matches(
                not(
                    withContentDescription(
                        isEmptyOrNullString()
                    )
                )
            )
        )
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(not(withText(isEmptyOrNullString()))))
    }

    @Test
    fun load_favorite_movie_and_load_detail_favorite_movie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.toolbar_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_layout)).check(
            matches(
                not(
                    withContentDescription(
                        isEmptyOrNullString()
                    )
                )
            )
        )
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.fab_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun load_favorite_tv_shows_and_load_detail_favorite_tv_shows() {
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        onView(withId(R.id.fab_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_favorite_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.toolbar_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_layout)).check(
            matches(
                not(
                    withContentDescription(
                        isEmptyOrNullString()
                    )
                )
            )
        )
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(not(withText(isEmptyOrNullString()))))
        onView(withId(R.id.fab_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}