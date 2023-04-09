package com.example.pokemon.presentation.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.presentation.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class HomeScreenKtTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Inject
    @Named("test_home_screen")
    lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        rule.activity.setContent { HomeScreen(
            viewModel = viewModel,
            navController = rememberNavController()
        ) }
    }

    @Test
    fun homeScreen_success() {
        rule.onNodeWithText("Bulbasaur").assertExists()
    }
}