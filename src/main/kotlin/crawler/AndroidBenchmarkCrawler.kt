package crawler

import it.skrape.core.document
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import utils.writeToFile

/**
 * Created by tamdh2 on 10/30/2022.
 */
class AndroidBenchmarkCrawler {
    /**
     * Start crawl data from given [url], parse & write into CSV file
     */
    fun start(url: String) {
        val listDevices: MutableList<List<String>> = ArrayList()

        skrape(HttpFetcher) {
            request {
                this.url = url
            }
            response {
                val products = this.document.document.getElementsByClass("prdname")
                val ratings = this.document.document.getElementsByClass("count")
                for (i in 0 until products.size) {
                    val name = products[i].text()
                    val rating = ratings[i].text().replace(",", "")
                    listDevices.add(listOf(name, rating))
                }
            }
        }

        writeToFile("./crawled/result.csv", listDevices)
    }
}