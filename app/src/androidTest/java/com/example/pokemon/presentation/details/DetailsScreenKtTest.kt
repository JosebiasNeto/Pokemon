package com.example.pokemon.presentation.details

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.presentation.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class DetailsScreenKtTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Inject
    @Named("test_details_screen")
    lateinit var viewModel: DetailsViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        rule.activity.setContent { DetailsScreen(
            viewModel = viewModel,
            navController = rememberNavController()
        ) }
    }

    @Test
    fun detailsScreen_success() {
        rule.waitUntil {
            rule
                .onAllNodesWithText("Bulbasaur")
            viewModel.pokemon.value.id == 1
        }
    }
}