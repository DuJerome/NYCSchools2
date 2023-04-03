package com.dushane.nycschools2

import com.dushane.nycschools2.model.School
import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import com.google.common.truth.Truth.assertThat
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class ViewModelUnitTest {

    var schoolViewModelMock = Mockito.mock(SchoolViewModel::class.java)

    @Before
    fun setup() {
        val school =  Mockito.mock(School::class.java)
        whenever(schoolViewModelMock.schools).thenReturn(
            Single.just(listOf(school))
        )
    }
    @Test
    fun testViewModelAndRxJava(){
        //Act
        val schoolList = schoolViewModelMock.schools.blockingGet()

        //Assert
        assertThat(schoolList).isNotNull()
        assertThat(schoolList.size).isGreaterThan(0)
        assertThat(schoolList[0]).isInstanceOf(School::class.java)
    }
}