/*
 * kotlin script
 * 2024.12.09
 * kotlinc -script list-file.kts <path>
 */

import java.io.File

val folder = File(args[0]).listFiles { file -> file.isDirectory() }
folder?.forEach{ folder -> println(folder) }

