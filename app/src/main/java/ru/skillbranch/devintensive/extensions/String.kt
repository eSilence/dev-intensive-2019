package ru.skillbranch.devintensive.extensions
/*
*String.truncate
Необходимо реализовать метод truncate усекающий исходную строку до указанного числа символов
и добавляющий заполнитель "..." в конец строки
Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16)
и возвращающий усеченную строку с заполнителем "..." (если строка была усечена) если последний
символ усеченной строки является пробелом - удалить его и добавить заполнитель
Пример:
"Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
"Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
"A     ".truncate(3) //A
 */
fun String.truncate(count:Int = 16 ) =
    if (count >= this.trim().length)
        this.trim()
    else
        "${this.trim().take(count).trim()}..."

/*
*String.stripHtml
Необходимо реализовать метод stripHtml для очистки строки от лишних пробелов, html тегов, escape последовательностей
Реализуй extension позволяющий очистить строку от html тегов
и html escape последовательностей ("& < > ' ""),
а так же удалить пустые символы (пробелы) между словами если их больше 1.
Необходимо вернуть модифицированную строку
Пример:
"<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
"<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
 */
fun String.stripHtml(): String {
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
 //  return this.replace(Regex("(<.*?>)|(&.*?;)|([ ]{2,})"), " ").trim()
}