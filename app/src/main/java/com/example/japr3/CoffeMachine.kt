
import java.util.*

class CoffeeMachine{
    private var scanner = Scanner(System.`in`)
    var water:Int = 0
    var milk:Int = 0
    var beans: Int = 0;

    enum class typesOfCoffee(var nameCoffee: String, val water: Int, val milk: Int, val beans: Int ){
        ESPRESSO("Эспрессо",60,0,10),
        AMERICANO("Американо",120,0,10),
        CAPUCINO("Капучино", 120,60,20),
        LATTE("Латте",240,120,20);

        override fun toString(): String {
            return when (this) {
                ESPRESSO -> "эспрессо"
                AMERICANO -> "американо"
                CAPUCINO -> "капучино"
                LATTE -> "латте"
            }
        }
    }

    public fun start(){
        var command = ""
        println("Кофемашина готова к работе")
        while (true) {
            println("Введите команду")
            command = scanner.nextLine().lowercase();

            when (command) {
                "выключить" -> {println("До свидания!")
                    break}
                "наполнить" -> fill()
                "статус" -> status()
                "кофе" -> makeCofee()
                //else -> println("Неизвестная команда")
            }

        }
    }

    fun status(){
        println("Ингридиентов осталось: $water мл. воды, $milk мл. молока, $beans гр. кофе")
    }

    fun fill(){
        water = 2000
        milk = 1000
        beans = 500
        println("Ингридиенты пополнены")
    }

    fun makeCofee(){

        var commandMC = ""
        println("Введите название напитка или \"назад\" для возврата в главное меню")
        commandMC = scanner.nextLine().lowercase()

        if (commandMC.equals("назад")) return

        val recipe = findRecipe(commandMC)

        if (!(recipe == null)) {
            makeCofeeOnRecipe(recipe)
        }
    }

    fun findRecipe(command:String):typesOfCoffee?{

        for (element in typesOfCoffee.values()){
            if (element.nameCoffee.lowercase().equals(command.lowercase())) return element
        }
        println("Рецепт не найден!")
        return null
    }

    fun makeCofeeOnRecipe(recipe:typesOfCoffee){

        if (water-recipe.water < 0) {
            println("Недостаточно воды!")

        }else if (milk-recipe.milk < 0){
            println("Недостаточно молока!")

        }else if (beans-recipe.beans < 0) {
            println("Недостаточно кофе!")

        }else{
            water = water-recipe.water
            milk = milk-recipe.milk
            beans = beans-recipe.beans
            println("${recipe.nameCoffee} готов")
        }
    }
}




fun main(){
    val cm = CoffeeMachine();
    cm.start()
}
