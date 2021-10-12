package FacebookClasses

import java.time.LocalDateTime

class Message(private val body: String, private val sender: Person, private val receiver: Person)
    : PersistedObject {

    override val id by lazy { newId() }
    override val createdAt: LocalDateTime = LocalDateTime.now()

    override fun toString(): String {
        return "$sender said to $receiver at $createdAt : $body"
    }

    override fun getInfo(): String {
        return super.getInfo() + ", message: $body, sender: $sender, receiver: $receiver"
    }
}