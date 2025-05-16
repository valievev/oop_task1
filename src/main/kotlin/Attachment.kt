sealed class Attachment(val type: String)

interface Image {
    val height: Int
    val width: Int
    val url: String
}

interface Photo {
    val id: Int
    val album_id: Int
    val owner_id: Int
    val user_id: Int
    val text: String
    val date: Int
}

interface Audio {
    val id: Int
    val owner_id: Int
    val artist: String
    val title: String
    val duration: Int
    val url: String
    val album_id: Int
}

interface Video {
    val id: Int
    val owner_id: Int
    val title: String
    val description: String
    val duration: Int
    val image: Image
    val date: Int
    val views: Int
}

interface File {
    val id: Int
    val owner_id: Int
    val title: String
    val size: Int
    val ext: String
    val url: String
    val date: Int
    val type: Int
}

interface Sticker {
    val inner_type: String
    val sticker_id: Int
    val product_id: Int
    val is_allowed: Boolean
    val image: Image
}

data class AttachmentPhoto(val photo: Photo?) : Attachment("photo")
data class AttachmentAudio(val audio: Audio?) : Attachment("audio")
data class AttachmentVideo(val video: Video?) : Attachment("video")
data class AttachmentFile(val file: File?) : Attachment("file")
data class AttachmentSticker(val sticker: Sticker?) : Attachment("sticker")