package com.example.japr3

class JP6 {
}

enum class GroupRole(val title: String) {
    VOCAL("Вокалист"),
    BASS("Бассист"),
    SOLO("Соло-гитарист"),
    DRUMS("Барабанщик")
}

abstract class RockMusician {

    abstract val name: String
    abstract val role: GroupRole
}

interface CanSing {

    fun sing()
}

interface CanPlayGuitar {

    fun playGuitar()
}

interface CanPlayDrum {

    fun playDrum()
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// его роль должна быть задана внутри класса как GroupRole.VOCAL
// вокалист должен уметь петь - реализуйте интерфейс CanSing. Метод sing() должен выводить текст: "We will, we will rock you"
class Vocalist(
    override var name: String
): RockMusician(), CanSing{
    override fun sing() {
        println("We will, we will rock you")
    }

    override val role: GroupRole
        get() = GroupRole.VOCAL
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// поскольку и басс, и соло гитаристы являются гитаристами - их роль, как и имя, передаётся при создании в конструкторе.
// гитаристы должны уметь играть на гитаре. Реализуйте интерфейс CanPlayGuitar. Метод playGuitar() выводит текст "Играю на гитаре"
class Guitarist(
    override var role: GroupRole,
    override var name: String
):RockMusician(), CanPlayGuitar{
    override fun playGuitar() {
        println("Играю на гитаре")
    }
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// его роль должна быть задана внутри класса как GroupRole.DRUMS
// барабанщик играет на ударных. Интерфейс CanPlayDrum поможет в этом, реализуйте его. Метод playDrum() выводит текст "Пам парам пам пам, я играю на барабанах"
class Drummer(
    override var name: String
): RockMusician(),CanPlayDrum{
    override fun playDrum() {
        println("Пам парам пам пам, я играю на барабанах")
    }

    override val role: GroupRole
        get() = GroupRole.DRUMS
}

fun main(){
    val v = Vocalist("Василич");
    val bG = Guitarist(GroupRole.BASS,"Михалыч");
    val sG = Guitarist(GroupRole.SOLO,"Петрович");
    val D = Drummer("Агаповна");

    println("${v.name} ${v.role}")
    v.sing()
    println("${bG.name} ${bG.role}")
    bG.playGuitar()

    println("${sG.name} ${sG.role}")
    sG.playGuitar()

    println("${D.name} ${D.role}")
    D.playDrum()

}
