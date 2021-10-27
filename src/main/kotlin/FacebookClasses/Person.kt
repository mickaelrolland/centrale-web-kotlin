package FacebookClasses

import java.time.LocalDateTime

open class Person(private val firstName: String = "John", private val lastName: String = "Doe", private var friends: MutableList<Person>)
    : PersistedObject {

    override val id by lazy { newId() }
    override val createdAt : LocalDateTime = LocalDateTime.now()

    var page = Page(mutableListOf())

    private var nickName: String? = null
        set(value) {
            field = value
            println("Changed the nickname to $value")
        }
        get() { return if(field != null) field else "" }

    fun setNickname(nickname: String) {
        this.nickName = nickname
    }

    private fun hasNickname() : Boolean {
        return nickName != ""
    }

    private fun getFullName(): String {
        val nickNameToPrint = if (hasNickname()) "($nickName)" else ""
        return "$firstName $lastName $nickNameToPrint"
    }

    override fun toString(): String {
        return getFullName()
    }

    fun addFriend(friend: Person) {
        if (friend !in friends) {
            friends.add(friend)
            friend.addFriend(this)
        }
    }

    open fun printFriends() : String {
        var result = ""
        for(friend in friends) {
            result += friend.getFullName()+"\n"
        }
        return result
    }

    override fun getInfo(): String {
        return super.getInfo() + ", first name: $firstName, last name: $lastName, nickname: $nickName"
    }
}