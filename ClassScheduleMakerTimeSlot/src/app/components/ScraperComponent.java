package app.components;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScraperComponent {
	private static final String URL = "https://aisis.ateneo.edu/j_aisis/classSkeds.do";
    private static final String COOKIE = "JSESSIONID=0a0f10d930d60251563f6df54a4d916ebb6b5cf6b787.e3yKch4Pb3mSe34KbxeTchaTby0; __utmz=48268342.1705928712.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); AWSALBTG=4GPhqteHztFPoVlSB3L8jQDIt9RwM6DM+pr6UnHYD7T0nf8vZw7ClMmkHD9RGwN+5bMpKXsRw3QHkd95Mg/Vpf3u06AnJcowRRcRs/tOuofk3Et+XorNIL44b7uybgCuK4OVUhz6NCLvSHMZt5gRikzvdVwDEBUH+EyAzktcJXW6; AWSALBCORS=Vc3fq51qIdAfjX8ZMpvOswlYS+Tq7hM0Pz5ZsGvMxduFJ4TJVGAaM0Uuoje1iLI9nuMnY0EOna3jRJsvTyy9e2wprudJjIcEe7XLzLNi25w2aVp7WcD0WOTOZyRF";

    public void scrapeAllDepartments() {
        String[] deptCodes = {
                "IE", "BIO", "CH", "CHN", "COM", "CEPP", "CPA", "ELM", "DS", "EC", "ECE",
                "EN", "ES", "EU", "FIL", "FAA", "FA", "HSP", "HI", "SOHUM", "DISCS", "SALT",
                "INTAC", "IS", "JSP", "KSP", "LAS", "MAL", "MA", "ML", "NSTP (ADAST)",
                "NSTP (OSCI)", "PH", "PE", "PS", "POS", "PSY", "QMIT", "SB", "SOCSCI",
                "SA", "TH", "TMP"
        };

        for (String deptCode : deptCodes) {
            scrapeDepartment(deptCode);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Error during delay: " + e.getMessage());
            }
        }
    }

    public void scrapeDepartment(String deptCode) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(URL);
            post.setHeader("Cookie", COOKIE);
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("command", "displayResults"));
            params.add(new BasicNameValuePair("subjCode", "ALL"));
            params.add(new BasicNameValuePair("applicablePeriod", "2024-2"));
            params.add(new BasicNameValuePair("deptCode", deptCode));
            post.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(post);

            Document doc = Jsoup.parse(response.getEntity().getContent(), null, "");
            Element table = doc.getElementById("example");
            if (table != null) {
                Elements rows = table.select("tr");
                System.out.println("Schedules for Department: " + deptCode);
                for (int i = 1; i < rows.size(); i++) {
                    Elements cols = rows.get(i).select("td");
                    if (cols.size() >= 7) {
                        System.out.printf(
                                "Subject Code: %s, Section: %s, Course Title: %s, Units: %s, Time: %s, Room: %s, Instructor: %s%n",
                                cols.get(0).text().trim(),
                                cols.get(1).text().trim(),
                                cols.get(2).text().trim(),
                                cols.get(3).text().trim(),
                                cols.get(4).text().trim(),
                                cols.get(5).text().trim(),
                                cols.get(6).text().trim()
                        );
                    }
                }
            } else {
                System.out.println("No schedules found for Department: " + deptCode);
            }
        } catch (Exception e) {
            System.err.println("Error fetching data for department " + deptCode + ": " + e.getMessage());
        }
    }
}
