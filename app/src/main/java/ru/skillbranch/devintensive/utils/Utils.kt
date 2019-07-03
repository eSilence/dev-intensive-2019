package ru.skillbranch.devintensive.utils


object Utils {
    /* 3 задание
Реализуй метод Utils.parseFullName(fullName) принимающий в качестве аргумента полное имя пользователя (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName) при невозможности распарсить полное имя или его часть вернуть null null/"firstName" null
Пример:
Utils.parseFullName(null) //null null
Utils.parseFullName("") //null null
Utils.parseFullName(" ") //null null
Utils.parseFullName("John") //John null
*/
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        val result: Pair<String?, String?> =
            Pair((if (firstName == "") null else firstName), (if (lastName == "") null else lastName))
        return result
    }

    /*
*toInitials
Необходимо реализовать утилитный метод toInitials(firstName lastName)
принимающий в качестве аргументов имя и фамилию пользователя и
возвращающий его инициалы
Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве
аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий
строку с первыми буквами имени и фамилии в верхнем регистре
(если один из аргументов null то вернуть один инициал, если оба аргумента null
вернуть null)
Пример:
Utils.toInitials("john" ,"doe") //JD
Utils.toInitials("John", null) //J
Utils.toInitials(null, null) //null
Utils.toInitials(" ", "") //null
     */
    fun toInitials(firstName: String?, lastName: String?): String? {
        var part1 = when (firstName) {
            null -> null
            "" -> null
            " " -> null
            else -> firstName[0].toString().toUpperCase()
        }
        var part2 = when (lastName) {
            null -> null
            "" -> null
            " " -> null
            else -> lastName[0].toString().toUpperCase()
        }

        val result: String? =
            if (part1 != null && part2 != null) part1 + part2 else if (part1 == null && part2 == null) null else if (part1 == null) part2 else part1
        return result
    }

    /*
    *transliteration
Необходимо реализовать утилитный метод transliteration(payload divider) принимающий в качестве аргумента строку
и возвращающий преобразованную строку из латинских символов
Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ")
и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
Пример:
Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
Utils.transliteration("Amazing Петр","_") //Amazing_Petr
     */

    fun transliteration(str:String, divider:String = " "):String{
    //   val readWriteMap = hashMapOf(" " to "$divider", "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d", "е" to "e", "ё" to "e", "ж" to "zh", "з" to "z", "и" to "i", "й" to "i", "к" to "k", "л" to "l", "м" to "m", "н" to "n", "о" to "o", "п" to "p", "р" to "r", "с" to "s", "т" to "t", "у" to "u", "ф" to "f", "х" to "h", "ц" to "c", "ч" to "ch", "ш" to "sh", "щ" to "sh'", "ъ" to "", "ы" to "i", "ь" to "", "э" to "e", "ю" to "yu", "я" to "ya")
       val replaceMap = hashMapOf(' ' to "$divider", 'а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e", 'ё' to "e", 'ж' to "zh", 'з' to "z", 'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m", 'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r", 'с' to "s", 'т' to "t", 'у' to "u", 'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh'", 'ъ' to "", 'ы' to "i", 'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya")
       val builder = StringBuilder()
       for (letter in str)
           when (letter) {
               in 'а' .. 'я' -> builder.append(replaceMap[letter])
               in 'А' .. 'Я' -> builder.append((replaceMap[letter.toLowerCase()])?.toUpperCase())
               ' ' -> builder.append(replaceMap[letter])
               else -> builder.append(letter)
           }
       return builder.toString()
    }

    }

