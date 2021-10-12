package FacebookClasses

class PersonPrivate (firstName: String?, lastName: String?, friends: MutableList<Person>)
    : Person(firstName!!, lastName!!, friends) {

    override fun printFriends() : String {
        return "this account is private"
    }
}