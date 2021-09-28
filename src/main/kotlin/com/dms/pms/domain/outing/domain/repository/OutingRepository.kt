package com.dms.pms.domain.outing.domain.repository

import com.dms.pms.domain.outing.domain.Outing
import org.springframework.data.jpa.repository.JpaRepository

interface OutingRepository : JpaRepository<Outing, String>, OutingRepositoryCustom