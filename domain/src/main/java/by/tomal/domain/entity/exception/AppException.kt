package by.tomal.domain.entity.exception

class AppException(val type: AppExceptionType = AppExceptionType.UNKNOWN): Throwable()