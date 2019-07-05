package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

/*
Date.format
Необходимо реализовать extension для форматирования вывода даты экземпляра класса Date по заданному паттерну
Реализуй extension Date.format(pattern) возвращающий отформатированную дату по паттерну передаваемому в качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
Пример:
Date().format() //14:00:00 27.06.19
Date().format("HH:mm") //14:00
 */
fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("rus"))
    return dateFormat.format(this)
}

/*
Date.add
Необходимо реализовать extension для изменения значения экземпляра Data
(добавление/вычитание) на указанную временную единицу
Реализуй extension Date.add(value, TimeUnits) добавляющий или вычитающий
значение переданное первым аргументом в единицах измерения второго аргумента
(enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) и возвращающий модифицированный
экземпляр Date
Пример:
Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019
 */

fun Date.add(value:Long, units:TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

        // time += when(units) {
    val delt:Long = when(units) {
        TimeUnits.SECOND -> value * TimeUnits.SECOND.value
        TimeUnits.MINUTE -> value * TimeUnits.MINUTE.value
        TimeUnits.HOUR -> value * TimeUnits.HOUR.value
        TimeUnits.DAY -> value * TimeUnits.DAY.value
    }
    this.time = time + delt
    return this
}

/*
*Date.humanizeDiff
Необходимо реализовать extension для форматирования вывода разницы между текущим экземпляром Date
и текущим моментом времени (или указанным в качестве аргумента) в человекообразном формате
Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени) для
форматирования вывода разницы между датами в человекообразном формате, с учетом склонения числительных.
Временные интервалы преобразований к человекообразному формату:
0с - 1с "только что"
1с - 45с "несколько секунд назад"
45с - 75с "минуту назад"
75с - 45мин "N минут назад"
45мин - 75мин "час назад"
75мин 22ч "N часов назад"
22ч - 26ч "день назад"
26ч - 360д "N дней назад"
>360д "более года назад"

Пример:
Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
 */

fun Date.humanizeDiff(nowDate:Date = Date()):String{
    var time = this.time
    var time2:Long = nowDate.time
    var dif = time2 - time
    var result:String
    if (dif>=0) {
        if (dif >= 0 && dif <= TimeUnits.SECOND.value) result = "только что"
        else if (dif > TimeUnits.SECOND.value && dif <= 45 * TimeUnits.SECOND.value)     result = "несколько секунд назад"
        else if (dif > 45 * TimeUnits.SECOND.value && dif <= 75 * TimeUnits.SECOND.value) result = "минуту назад"
        else if (dif > 75 * TimeUnits.SECOND.value && dif <= 45 * TimeUnits.MINUTE.value) result = "${TimeUnits.MINUTE.plural(dif / TimeUnits.MINUTE.value)} назад"
        else if (dif > 45 * TimeUnits.MINUTE.value && dif <= 75 * TimeUnits.MINUTE.value) result = "час назад"
        else if (dif > 75 * TimeUnits.MINUTE.value && dif <= 22 * TimeUnits.HOUR.value) result = "${TimeUnits.HOUR.plural(dif / TimeUnits.HOUR.value)} назад"
        else if (dif > 22 * TimeUnits.HOUR.value && dif <= 26 * TimeUnits.HOUR.value) result = "день назад"
        else if (dif > 26 * TimeUnits.HOUR.value && dif <= 360 * TimeUnits.DAY.value) result = "${TimeUnits.DAY.plural(dif / TimeUnits.DAY.value)} назад"
        else result = "более года назад"
    }else{
        dif = -dif
        if (dif > 0 && dif <= TimeUnits.SECOND.value) result = "только что"
        else if (dif > TimeUnits.SECOND.value && dif <= 45 * TimeUnits.SECOND.value) result = "через несколько секунд"
        else if (dif > 45 * TimeUnits.SECOND.value && dif <= 75 * TimeUnits.SECOND.value) result = "через минуту"
        else if (dif > 75 * TimeUnits.SECOND.value && dif <= 45 * TimeUnits.MINUTE.value) result = "через ${TimeUnits.MINUTE.plural(dif / TimeUnits.MINUTE.value)}"
        else if (dif > 45 * TimeUnits.MINUTE.value && dif <= 75 * TimeUnits.MINUTE.value) result = "через час"
        else if (dif > 75 * TimeUnits.MINUTE.value && dif <= 22 * TimeUnits.HOUR.value) result = "через ${TimeUnits.HOUR.plural(dif / TimeUnits.HOUR.value)}"
        else if (dif > 22 * TimeUnits.HOUR.value && dif <= 26 * TimeUnits.HOUR.value) result = "через день"
        else if (dif > 26 * TimeUnits.HOUR.value && dif <= 360 * TimeUnits.DAY.value) result = "через ${TimeUnits.DAY.plural(dif / TimeUnits.DAY.value)}"
        else result = "более чем через год"
    }
    return  result
    }
/*
**plural
Необходимо реализовать метод plural для enum TimeUnits
+2
Реализуй метод plural для всех перечислений TimeUnits следующего вида TimeUnits.SECOND.plural(value:Int) возвращающую значение в виде строки с праильно склоненной единицой измерения
Пример:
TimeUnits.SECOND.plural(1) //1 секунду
TimeUnits.MINUTE.plural(4) //4 минуты
TimeUnits.HOUR.plural(19) //19 часов
TimeUnits.DAY.plural(222) //222 дня
 */

enum class TimeUnits (
        val value:Long,
        val one:String="секунду",  val few: String="секунды",  val many:String= "секунд") {

    SECOND(1000L ),
    MINUTE(60L * SECOND.value,"минуту", "минуты", "минут" ),
    HOUR(60L * MINUTE.value,"час", "часа", "часов"),
    DAY(24L * HOUR.value, "день", "дня", "дней");

    fun plural(num:Long):String{
        if (num % 10 == 1L && num % 100 != 11L) return "$num $one"
        if (num%10 > 1L && num%10 < 5L && !(num%100>11L && num %100<15L)) return "$num $few"
        return "$num $many"
    }
}
