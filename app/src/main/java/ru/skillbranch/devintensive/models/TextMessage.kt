package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomoming: Boolean = false,
    date: Date = Date(),
    var text: String?

) : BaseMessage(id, from, chat, isIncomoming, date) {
    override fun formatMessage(): String =
        "id:$id ${from?.lastName} ${if (isIncomoming) "receive" else "sent"} message \"$text\" ${date.humanizeDiff()}"
}