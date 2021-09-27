package com.dms.pms.domain.student.`interface`

import com.dms.pms.domain.student.domain.pms.Student

interface StudentFacade {
    fun findStudentIdByNumber(number: Long): String
    fun findAllStudentsByEmail(email: String): List<Student>
    fun checkIsUserHasStudent(email: String, number: Long)
}