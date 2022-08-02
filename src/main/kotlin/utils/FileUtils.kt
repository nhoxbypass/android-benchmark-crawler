package utils

import java.io.File

/**
 * Created by tamdh2 on 10/30/2022.
 */

fun writeToFile(outputPath: String, listData: MutableList<List<String>>) {
    val outputFile = File(outputPath)
    outputFile.mkdirs()
    if (outputFile.exists()) {
        outputFile.delete()
    }

    val csv = listData.joinToString("\n") { line ->
        line.joinToString(", ")
    }
    outputFile.writeText(csv)
}