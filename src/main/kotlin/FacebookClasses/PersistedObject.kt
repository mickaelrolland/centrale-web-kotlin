package FacebookClasses

import java.time.LocalDateTime
import java.util.*

interface PersistedObject {
    val id : String
    fun newId() : String { return UUID.randomUUID().toString() }

    val createdAt : LocalDateTime

    fun getInfo() : String {
        return "id: $id, createdAt: $createdAt"
    }

    fun printInfo() {
        println(getInfo())
    }
}