package com.dushane.nycschools2

import com.dushane.nycschools2.model.SATScores
import com.dushane.nycschools2.ui.viewmodel.SATScoresViewModel
import com.google.common.truth.Truth
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class SATScoresViewModelUnitTest {
    //Create a mock of the ViewModel
    private var satSchoolViewModelMock = Mockito.mock(SATScoresViewModel::class.java)

    //Executed before tests are run, and this
    @Before
    fun setup(){
        // Create of a mock of the object
        val scores = Mockito.mock(SATScores::class.java)
        //Stub the return
        whenever(satSchoolViewModelMock.satScores).thenReturn(
            Single.just(listOf(scores))
        )
    }

    @Test
    fun testGetList(){
        //Act
        val satScoresList = satSchoolViewModelMock.satScores.blockingGet()

        //Assert
        Truth.assertThat(satScoresList).isNotNull()
        Truth.assertThat(satScoresList.size).isGreaterThan(0)
        Truth.assertThat(satScoresList[0]).isInstanceOf(SATScores::class.java)
    }
}