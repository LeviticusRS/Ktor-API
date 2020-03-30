package impl

import com.joshua.ransom.dbQuery
import org.jetbrains.exposed.sql.*

class IncomingMessageService {

    suspend fun getAllUsers(): List<IncomingMessage> = dbQuery {
        IncomingMessages.selectAll().map { toPlayer(it) }
    }

    suspend fun insertMessage(username: String, ipAddress: String, message: String): Unit = dbQuery {
        SchemaUtils.create (IncomingMessages)

        val messageId = IncomingMessages.insert {
            it[IncomingMessages.username] = username
            it[IncomingMessages.ipAddress] = ipAddress
            it[IncomingMessages.message] = message
        } get IncomingMessages.id

        println("Message Id: {$messageId}")
    }

    suspend fun getUserByUsername(username: String): IncomingMessage? = dbQuery {
        IncomingMessages.select {
            (IncomingMessages.username eq username)
        }.mapNotNull { toPlayer(it) }
            .singleOrNull()
    }

    private fun toPlayer(row: ResultRow): IncomingMessage =
        IncomingMessage(
            id = row[IncomingMessages.id],
            username = row[IncomingMessages.username],
            ipAddress = row[IncomingMessages.ipAddress],
            message = row[IncomingMessages.message]
        )
}