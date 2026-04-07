// Updated OpenStreetMapInput.kt to include support for OSM changeset URLs.

package com.example.geoshare

class OpenStreetMapInput {
    // ... other existing code ...

    fun getOSMChangesetUrl(changesetId: String): String {
        return "https://www.openstreetmap.org/changeset/$changesetId"
    }
}