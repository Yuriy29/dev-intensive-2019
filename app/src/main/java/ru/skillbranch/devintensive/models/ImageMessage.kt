package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomoming: Boolean = false,
    date: Date = Date(),
    var image: String?

) : BaseMessage(id, from, chat, isIncomoming, date) {
    override fun formatMessage(): String =
        "id:$id ${from?.lastName} ${if (isIncomoming) "receive" else "sent"} image \"$image\" ${date.humanizeDiff()}"
}