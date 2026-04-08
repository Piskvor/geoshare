// OpenStreetMapInput.kt

const val CHANGESET_PATH = "/changeset/(\\d+)(?:[/?#].*|$)"

/**
 * Parses the changeset URI to detect the changeset ID.
 * Constructed as: https://www.openstreetmap.org/api/0.6/changeset/{id}.json
 */
fun parseUri(uri: String): String? {
    val regex = Regex(CHANGESET_PATH)
    return regex.find(uri)?.groups?.get(1)?.value
}

/**
 * Parses HTML content to extract bounding box coordinates using changesetBoundsPattern regex.
 * Extends calculation for center coordinates from the bounding box.
 */
fun parseHtml(html: String): Pair<Double, Double> {
    val changesetBoundsPattern = Regex("(?<=min_lat=)(-?\\d+\\.\\d+)(?=&)")
    val minLat = changesetBoundsPattern.find(html)?.value?.toDouble() ?: 0.0
    val maxLat = changesetBoundsPattern.find(html)?.groups?.get(2)?.value?.toDouble() ?: 0.0
    val minLon = changesetBoundsPattern.find(html)?.groups?.get(3)?.value?.toDouble() ?: 0.0
    val maxLon = changesetBoundsPattern.find(html)?.groups?.get(4)?.value?.toDouble() ?: 0.0

    // Calculate center coordinates
    val centerLat = (minLat + maxLat) / 2
    val centerLon = (minLon + maxLon) / 2
    return Pair(centerLat, centerLon)
}