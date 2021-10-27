import FacebookClasses.*

fun main() {
    val person1 = Person("Jon", "Snow", mutableListOf())
    val person2 = Person("Sun", "Bacon", mutableListOf())
    val person3 = PersonPrivate("Ano","Nymous", mutableListOf(person1))
    person1.addFriend(person2)
    person1.setNickname("King in the North")
    println("Personne 1: $person1")
    println("Amis de $person1: ${person1.printFriends()}")
    person2.printInfo()
    println("Amis de $person2: ${person2.printFriends()}")
    println("Amis de $person3: ${person3.printFriends()}")

    val message = Message("J'aime le bacon et le soleil, aimes-tu la neige ?", person1, person2)
    println("message: $message")
    message.printInfo()

    val post1 = Post(person1, "Euh les gars on est attaqués par des créatures du froid")
    val post2 = Post(person2, "J'en ai marre qu'on me prenne pour de la viande")

    person1.page.addPost(post1)
    person2.page.addPost(post2)
    println("--------Page de Personne 2----------\n ${person2.page} \n--------Fin-----------")

    post1.modifyPost("C'est chaud là faut venir nous aider, heureusement ma soeur elle a des dragons")
    println("--------Page de Personne 1----------\n ${person1.page} \n--------Fin-----------")
}