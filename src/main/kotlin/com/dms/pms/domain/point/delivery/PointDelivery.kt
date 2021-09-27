package com.dms.pms.domain.point.delivery

import com.dms.pms.domain.point.application.PointService
import com.dms.pms.domain.point.delivery.dto.StudentPointDto
import com.dms.pms.global.security.UserInfo
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/student/point")
class PointDelivery (
    private val pointService: PointService
) {

    @Cacheable(value = ["student-point-history"], key = "#number", unless = "#result.shares < 5", cacheManager = "cacheManager")
    @GetMapping("/{number}")
    fun getStudentPointHistory(@PathVariable("number") number: Long, @UserInfo email: String): StudentPointDto.Response {
        return pointService.getStudentPointHistory(number, email)
    }

}