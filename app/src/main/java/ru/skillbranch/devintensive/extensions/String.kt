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
fun String.truncate(count:Int = 16 ):String{
    var str = this.trim()//this.take(count)
    if (str.length <= count){
        return str
    }
        str = str.take(count)
        return str.trim()+"..."
}