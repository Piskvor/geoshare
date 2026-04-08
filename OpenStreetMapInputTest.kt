import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpenStreetMapInputTest {
    // Existing tests...

    @Test
    void parseUri_changeset() {
        String changesetUrl = "https://www.openstreetmap.org/changeset/123456";
        String expectedApiUrl = "https://api.openstreetmap.org/api/0.6/changeset/123456";
        assertEquals(expectedApiUrl, OpenStreetMapInput.parseUri(changesetUrl));
    }

    @Test
    void parseHtml_changeset() {
        String changesetJson = "{\"min_lat\":45.0,\"max_lat\":46.0,\"min_lon\":9.0,\"max_lon\":10.0}";
        WGS84Point expectedCenter = new WGS84Point(45.5, 9.5);
        assertEquals(expectedCenter, OpenStreetMapInput.parseHtml(changesetJson));
    }
}