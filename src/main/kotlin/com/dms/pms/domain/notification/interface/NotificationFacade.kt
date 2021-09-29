package com.dms.pms.domain.notification.`interface`

import com.dms.pms.domain.student.domain.pms.Student

interface NotificationFacade {
    fun sendOutingMessageByStudent(student: Student)
}