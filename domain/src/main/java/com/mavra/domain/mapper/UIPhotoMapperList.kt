package com.mavra.domain.mapper

import com.mavra.domain.model.DtoPhoto
import com.mavra.presentation.model.UIPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIPhotoMapperList @Inject constructor(
    private val uiPhotoMapper: UIPhotoMapper
) : Mapper<List<DtoPhoto>, List<UIPhoto>> {
    override fun mapTo(out: List<DtoPhoto>) = out.map { uiPhotoMapper.mapTo(it) }
}