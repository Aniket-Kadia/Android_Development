package com.example.myapplication.kotlinconcepts.Collection

fun main() {
    val language = listOf("Java", null, "python", null, "Java", "C++")
    println(language)  //output: [Java, null, python, null, Java, C++]
    println(language.contains("Java"))  //output: true

    val number = setOf(1, 2, 3, 4, 5, 12, 3, 4)
    println(number)  //output: [1, 2, 3, 4, 5, 12]

    val setOfAlphabet = setOf('A', 'B', 'C')
    val setOfAlphabetRev = setOf('C', 'B', 'A')
    println(setOfAlphabet.first() == setOfAlphabetRev.first())  //output: false
    println(setOfAlphabet.first() == setOfAlphabetRev.last())  //output: true

    val codeWithCityName = mapOf(1 to "Ahmedabad", 2 to "Mehsana")
    println(codeWithCityName.keys)  //output: [1, 2]
    println(codeWithCityName.values)  //output: [Ahmedabad, Mehsana]
    println(codeWithCityName.containsValue("Ahmedabad"))  //output: true

    //Two maps containing the equal pairs are equal regardless of the pair order.
    val codeWithCityNameRev = mapOf(2 to "Mehsana", 1 to "Ahmedabad")
    println(codeWithCityName == codeWithCityNameRev)  //output: true

    //Collection builder function
    val studentData = buildMap {
        put(1, "Stu1")
        put(2, "Stu2")
        put(3, "Stu3")
    }

    //Empty list
    var emptySet = emptySet<Int>()

    //Iterator
    val iteratorIndex = setOfAlphabet.iterator()
    while (iteratorIndex.hasNext()) {
        println(iteratorIndex.next())
    }
    /* output:
    A
    B
    C
    */

    //List iterator for add and remove
    val state = mutableListOf<String>("Gujarat")
    val indexOfState = state.listIterator()
    indexOfState.next()
    indexOfState.add("UP")
    println(state)  //output: [Gujarat, UP]

    //Collection transformation
    val index = setOf(1, 2, 3)
    println(index.map { it * 2 })  //output: [2, 4, 6]

    //filter null value
    println(index.mapNotNull { if (it == 2) null else it * 3 })  //output: [3, 9]

    //Map key
    println(studentData.mapValues { it.value.uppercase() })  //output: {1=STU1, 2=STU2, 3=STU3}

    //zip
    val name = listOf("Shiva", "Ak")
    val role = listOf("QA", "devops")
    println(name zip role)  //output: [(Shiva, QA), (Ak, devops)]

    //slice
    println(language.slice(2..4))  //output: [python, null, Java]

    //sorted
    println(language.sortedBy { it?.length })  //output: [null, null, C++, Java, Java, python]
    println(language)  //output: [Java, null, python, null, Java, C++]
    println(language.sortedByDescending { it?.last() })  //output: [python, Java, Java, C++, null, null]

    //reversed
    println(language.reversed())  //output: [C++, Java, null, python, null, Java]
    println(language)  //output: [Java, null, python, null, Java, C++]
    println(language.shuffled())  //output: [null, Java, Java, C++, python, null]

    //Aggregate operation
    val number2 = setOf(23, 40, 8, 45)
    println(number2.count())  //output: 4
    println(number2.max())  //output: 45
    println(number2.min())  //output: 8
    println(number2.average())  //output: 29.0
    println(number2.sum())  //output: 116

    //reduce and fold
    println(number2.reduce { acc, i -> acc + i })  //116
    println(number2.fold(0) { acc, i -> acc * i })  //output: 0

    //Common method
    var sampleSet = mutableSetOf(1, 3, 5, 7, 9)
    val sampleList = mutableListOf(10, 20, 30)
    sampleList.add(40)
    println(sampleList) //output: [10, 20, 30, 40]

    //clear or retainAll
    sampleList.retainAll { it >= 30 }
    println(sampleList)  //output: [30, 40]
    //sampleList.clear()  //output: Clear SampleList

    //list specific operation
    //println(sampleList.get(5))  //Error: Index out of bounds
    println(sampleList.getOrNull(5))  //output: null
    println(sampleList.getOrElse(5, { 0 }))  //output: 0

    //sublist
    println(sampleList)  //output: [30, 40]
    //println(sampleList.subList(2, 4))    //error: if index is not present in collection
    println(sampleList.add(34))  //output: true
    println(sampleList.sorted()) //output: [30, 34, 40]
    println(sampleList)  //output: [30, 40, 34]

    //get element
    val mapOfState = mutableMapOf(1 to "gujarat", 2 to "Goa", 3 to "Delhi")
    println(mapOfState.get(2))  //output: Goa
    println(mapOfState.filter { (k, v) -> k >= 1 && v.contains("a") })  //output: {1=gujarat, 2=Goa}
    println(mapOfState)  //output: {1=gujarat, 2=Goa, 3=Delhi}
    mapOfState.put(4, "Maharastra")
    println(mapOfState)  //output: {1=gujarat, 2=Goa, 3=Delhi, 4=Maharastra}
    println(mapOfState.remove(2, "Goa"))  //true
    println(mapOfState)  //output: {1=gujarat, 3=Delhi, 4=Maharastra}

    val numbers = listOf("One", "two", "three", "four", "five")
    val (firstPart, secondPart) = numbers.partition { it.length >= 4 }
    println(firstPart)  //output: [three, four, five]
    println(secondPart)  //output: [One, two]
}