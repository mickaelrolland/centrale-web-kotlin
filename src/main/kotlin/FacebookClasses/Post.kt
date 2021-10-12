package FacebookClasses

import java.time.LocalDateTime

class Post(private val owner: Person, var contents: String)
    : PersistedObject {

    override val id by lazy { newId() }
    override val createdAt: LocalDateTime = LocalDateTime.now()
    private var modifiedAt: LocalDateTime = createdAt

    fun modifyPost(newContent: String){
        contents = newContent
        modifiedAt = LocalDateTime.now().plusMinutes(10) // bcz for my example
    }

    override fun toString(): String {
        val modifiedAtToPrint = if (!modifiedAt.isEqual(createdAt)) "(modified at $modifiedAt)" else ""
        return "$owner said at $createdAt $modifiedAtToPrint : $contents"
    }
}