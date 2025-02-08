package com.cawadev.softwarecraft.katas.tripservice.exception

class CollaboratorCallException(message: String?, cause: Throwable?) :
    RuntimeException(message, cause) {

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable) : this(null, cause)

    companion object {
        private const val serialVersionUID: Long = -4584041339906109902L
    }
}
