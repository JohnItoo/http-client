import libcurl.*
import kotlinx.cinterop.*

fun main(args: Array<String>) {
    if (args.size == 1) {
        val curl = curl_easy_init()
        if (curl != null) {
            curl_easy_setopt(curl, CURLOPT_URL, args[0])
            curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L)
            val res = curl_easy_perform(curl)
            if (res != CURLE_OK) {
                println("curl_easy_perform() failed " + curl_easy_strerror(res)?.toKString())
            }
            curl_easy_cleanup(curl)
        }
    } else {
        println("Please provide a URL")
    }
}