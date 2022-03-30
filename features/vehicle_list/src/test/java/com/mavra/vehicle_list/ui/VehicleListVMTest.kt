package com.mavra.vehicle_list.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.model.Resource
import com.mavra.domain.usecases.FetchPhotoUseCase
import com.mavra.vehicle_list.MainCoroutineRule
import com.mavra.vehicle_list.VehicleListVM
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class VehicleListVMTest{
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val testDispatcher
        get() = mainCoroutineRule.testDispatcher

    private val fetchPhotoUseCase: FetchPhotoUseCase = mockk()
    private lateinit var vm: VehicleListVM

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        vm = VehicleListVM(fetchPhotoUseCase)
    }

    @Test
    fun `Get Photos from UseCase return success`() =
        testDispatcher.runBlockingTest {
            val list:  Resource<List<DomainPhoto>> = Resource.Success(listOf())
            every { fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("curiosity")) } returns flow{
                emit(list)
            }
            vm.getRoverPhotos()
            Assert.assertEquals(vm.photos.value,(list as Resource.Success).data)
        }

}