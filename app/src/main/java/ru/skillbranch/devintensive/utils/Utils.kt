package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        // TODO fix me
        var parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)?.let { if (it.isEmpty()) null else it }
        var lastName = parts?.getOrNull(1)?.let { if (it.isEmpty()) null else it }
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var firstNameInitials = firstName?.trim()?.let { if (it.isEmpty()) null else it[0].toUpperCase() }
        var lastNameInitials = lastName?.trim()?.let { if (it.isEmpty()) null else it[0].toUpperCase() }
        return "${if (lastNameInitials == null && firstNameInitials == null) null else "${firstNameInitials
            ?: ""}${lastNameInitials ?: ""}"}"
    }

    fun transliteration(text: String, divider: String= " "): String {
        var abcCyr = listOf(' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
        var abcLat = listOf(" ","a","b","v","g","d","e","e","zh","z","i","i","k","l","m","n","o","p","r","s","t","u","f","h","c","ch","sh","sh", "","i", "","e","yu","ya","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

         var builder = StringBuilder()

        for (i in text.indices) {
            for(x in abcCyr.indices)
            if (text[i] == abcCyr[x]) {
                builder.append(abcLat[x])
            }
        }
        return builder.toString().replace(" ", divider)
    }
}