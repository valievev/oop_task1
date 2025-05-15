interface Attachment {
    val type: String
}

interface Image {
    val height: Int
    val width: Int
    val url: String
}

interface AttachmentPhoto {
    val id: Int
    val album_id: Int
    val owner_id: Int
    val user_id: Int
    val text: String
    val date: Int
}

interface AttachmentAudio {
    val id: Int
    val owner_id: Int
    val artist: String
    val title: String
    val duration: Int
    val url: String
    val album_id: Int
}

interface AttachmentVideo {
    val id: Int
    val owner_id: Int
    val title: String
    val description: String
    val duration: Int
    val image: Image
    val date: Int
    val views: Int
}

interface AttachmentFile {
    val id: Int
    val owner_id: Int
    val title: String
    val size: Int
    val ext: String
    val url: String
    val date: Int
    val type: Int
}

interface AttachmentSticker {
    val inner_type: String
    val sticker_id: Int
    val product_id: Int
    val is_allowed: Boolean
    val image: Image
}


class Photo(override val type: String, val photo: AttachmentPhoto?) : Attachment
class Audio(override val type: String, val audio: AttachmentAudio?) : Attachment
class Video(override val type: String, val video: AttachmentVideo?) : Attachment
class File(override val type: String, val file: AttachmentFile?) : Attachment
class Sticker(override val type: String, val sticker: AttachmentSticker?) : Attachment
