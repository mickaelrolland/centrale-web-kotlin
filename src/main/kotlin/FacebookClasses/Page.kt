package FacebookClasses

class Page(var posts: MutableList<Post>) {
    override fun toString() : String {
        var result = ""
        for(post in posts) {
            result += "$post\n"
        }
        return result
    }

    fun addPost(post: Post) {
        posts.add(post)
    }
}