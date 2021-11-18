package com.dms.pms.global.security.entrypoint

import com.dms.pms.global.security.exception.AuthEntryPointException
import com.dms.pms.global.security.exception.AccessDeniedException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/exception")
class AuthenticationController {
    @GetMapping("/entrypoint")
    fun entrypointException() {
        throw AuthEntryPointException.EXCEPTION
    }

    @GetMapping("/accessDenied")
    fun accessDeniedException() {
        throw AccessDeniedException.EXCEPTION
    }
}