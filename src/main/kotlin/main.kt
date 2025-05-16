class comment(
    count: Int = 0,
    can_post: Boolean = true,
    groups_can_post: Boolean = false,
    can_close: Boolean = false,
    can_open: Boolean = true
)

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: Long = 0,
    val text: String = "null",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val canPin: Boolean = false,
    val canEdit: Boolean = true,
    val comment: comment? = null,
    val originalPost: Post? = null,
    var attachment: Array<Attachment> = emptyArray<Attachment>()
) {
    override fun toString(): String {
        var str: String = "$id)\t$text"
        if (originalPost != null) {
            str += " (репост поста №$id)"
        }
        return str
    }
}

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 0

    fun addPost(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return posts.last()
    }

    fun updatePost(post: Post): Boolean {
        for ((index, postItem) in posts.withIndex()) {
            if (postItem.id == post.id) {
                posts[index] = posts[index].copy(text = post.text)
                return true
            }
        }
        return false
    }

    fun printPosts() {
        for (post in posts) {
            println(post)
        }
        println("-----------------------------")
    }

    fun getNextId(): Int {
        return nextId
    }

    fun clear() {
        posts = emptyArray()
        // nextId = 0
        // Нужно ли обновлять id?
        // если существуют ссылки на посты со внешних источников,
        // то лучше наверное чтобы они указывали на несуществующие посты,
        // а не на вновь созданные
    }
}

fun main() {
    val post1 = Post(text = "Это пост №1")
    val post2 = Post(text = "Это пост №2")
    val post3 = Post(text = "Это пост №3")
    val post4 = Post(text = "Это пост №4")

    val rePost3 = Post(text = "Это репост", originalPost = post3)

    WallService.addPost(post1)
    WallService.addPost(post2)
    WallService.addPost(post3)
    WallService.addPost(rePost3)
    WallService.addPost(post4)

    WallService.printPosts()
    val newPost2 = Post(id = 1, text = "Это измененный пост №2")
    WallService.updatePost(newPost2)

    WallService.printPosts()

//    var video1 = AttachmentVideo(
//        video = null
//    )
//    var photo1 = AttachmentPhoto(
//        photo = null
//    )
//    var file1 = AttachmentFile(
//        file = null
//    )
//    post4.attachment += video1
//    post4.attachment += photo1
//    post4.attachment += file1
//
//    for(item in post4.attachment){
//        if(item is AttachmentVideo){
//            println(item.type)
//        }
//    }
}