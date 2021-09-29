package com.dms.pms.domain.outing.domain.repository

import com.dms.pms.domain.outing.domain.Outing

interface OutingRepositoryCustom {
    fun getOutingsByStudentId(studentNumber: Long): List<Outing>
}