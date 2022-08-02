import crawler.AndroidBenchmarkCrawler

/**
 * Created by tamdh2 on 10/30/2022.
 */
fun main(args: Array<String>) {
    val service = AndroidBenchmarkCrawler()
    service.start("https://www.androidbenchmark.net/passmark_chart.html")
}