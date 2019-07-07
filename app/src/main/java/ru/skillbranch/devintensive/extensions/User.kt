package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView {
    var nickName = Utils.transliteration("$firstName $lastName")
    var initials = Utils.toInitials(firstName, lastName)
    var status =
        if (lastVisit == null) "not visit yet" else if (isOnline) "online" else "last visit ${lastVisit!!.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}
