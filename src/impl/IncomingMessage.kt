package impl

data class IncomingMessage(
    val id: Int,
    val username: String,
    val ipAddress: String,
    val message: String
)