package impl

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


object IncomingMessages: Table() {
    val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val username: Column<String> = varchar("username", 100)
    val ipAddress: Column<String> = varchar("ipaddress", 100)
    val message: Column<String> = varchar("message", 1000)
}