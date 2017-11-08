import java.util.*

/**
 * @author saket.mehta
 */
val CORRECT = "✓"
val WRONG = "✕"
val MISPLACED = "≈"

data class Code(val code: String)

fun readCode(): String {
    val input = readLine()
    if (input == null || input.length != 4) {
        return "0000"
    }
    return input
}

fun printHint(attempt: String, code: String) {
    val hint = StringBuilder()
    for (i in 0..3) {
        if (attempt[i] == code[i]) {
            hint.append(CORRECT)
        } else if (attempt[i] in code) {
            hint.append(MISPLACED)
        } else {
            hint.append(WRONG)
        }
    }
    println(hint.toString())
}

fun generateCode(): Code {
    val random = Random()
    return Code(random.nextInt(10000).toString())
}

fun main(args: Array<String>) {
    val code = generateCode()
    var attempt: Code
    var chances = 10
    while (chances > 0) {
        println("$chances chance(s) remaining.")
        attempt = Code(readCode())
        if (attempt == code) {
            println("You got it!")
            break
        } else {
            printHint(attempt.code, code.code)
        }
        chances--
    }
    if (chances == 0) println("You ran out of chances!")
}
