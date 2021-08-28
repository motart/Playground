package keeper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateParser {
    public static void main(String [] args) throws IOException, InterruptedException {
/*        String test = "{\"results\":[{\"logId\":\"a12bfd67-20dd-4c88-b13c-b020c781b9c0\",\"source\":\"eventProcessQueue\",\"tenantId\":2378,\"createdDate\":\"2021-01-27T00:51:04.747817Z\",\"processedDate\":\"2021-01-27T00:51:07.1424186Z\",\"success\":false,\"errorMessage\":\"Skipping - Duplicate event detected at 2021-01-27T10:25:00.0000000+00:00 for contact id 173276\",\"requestUrl\":\"http://analytics.churnzero.net/i\",\"requestPostData\":\"{\\n  \\\"appKey\\\": \\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\n  \\\"contactExternalId\\\": \\\"missed\\\",\\n  \\\"accountExternalId\\\": \\\"15346280\\\",\\n  \\\"action\\\": \\\"trackEvent\\\",\\n  \\\"name\\\": \\\"Record Created\\\",\\n  \\\"eventDate\\\": \\\"2021-01-27T10:25Z\\\",\\n  \\\"recordId\\\": 123\\n}\",\"userNotified\":false,\"eventSource\":null,\"entityId\":null,\"sourceId\":null,\"logDate\":\"2021-01-27T00:51:07.1423774+00:00\",\"input\":\"{\\n  \\\"eventQueueItem\\\": {\\n    \\\"accountExternalId\\\": \\\"15346280\\\",\\n    \\\"contactExternalId\\\": \\\"missed\\\",\\n    \\\"eventDate\\\": \\\"2021-01-27T10:25:00+00:00\\\",\\n    \\\"name\\\": \\\"Record Created\\\",\\n    \\\"allowDupes\\\": false,\\n    \\\"eventSource\\\": 2,\\n    \\\"attributes\\\": []\\n  },\\n  \\\"appKey\\\": \\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\n  \\\"requestUrl\\\": \\\"http://analytics.churnzero.net/i\\\",\\n  \\\"requestPostData\\\": \\\"{\\\\n  \\\\\\\"appKey\\\\\\\": \\\\\\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\\\\\",\\\\n  \\\\\\\"contactExternalId\\\\\\\": \\\\\\\"missed\\\\\\\",\\\\n  \\\\\\\"accountExternalId\\\\\\\": \\\\\\\"15346280\\\\\\\",\\\\n  \\\\\\\"action\\\\\\\": \\\\\\\"trackEvent\\\\\\\",\\\\n  \\\\\\\"name\\\\\\\": \\\\\\\"Record Created\\\\\\\",\\\\n  \\\\\\\"eventDate\\\\\\\": \\\\\\\"2021-01-27T10:25Z\\\\\\\",\\\\n  \\\\\\\"recordId\\\\\\\": 123\\\\n}\\\",\\n  \\\"messageDate\\\": \\\"2021-01-27T00:51:04.747817+00:00\\\",\\n  \\\"attemptCount\\\": 0,\\n  \\\"requestId\\\": \\\"a219d03f-2ef4-48ca-af20-43cc33f87986\\\"\\n}\"},{\"logId\":\"9cc9a2b6-3f77-4691-86f7-30ea9b676600\",\"source\":\"eventProcessQueue\",\"tenantId\":2378,\"createdDate\":\"2021-01-27T00:13:10.8240941Z\",\"processedDate\":\"2021-01-27T00:13:15.4742067Z\",\"success\":true,\"errorMessage\":null,\"requestUrl\":\"http://analytics.churnzero.net/i\",\"requestPostData\":\"{\\n  \\\"appKey\\\": \\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\n  \\\"contactExternalId\\\": \\\"missed\\\",\\n  \\\"accountExternalId\\\": \\\"15346280\\\",\\n  \\\"action\\\": \\\"trackEvent\\\",\\n  \\\"name\\\": \\\"Record Created\\\",\\n  \\\"eventDate\\\": \\\"2021-01-27T10:25Z\\\",\\n  \\\"recordId\\\": 123\\n}\",\"userNotified\":false,\"eventSource\":null,\"entityId\":27,\"sourceId\":null,\"logDate\":\"2021-01-27T00:13:15.467505+00:00\",\"input\":\"{\\n  \\\"eventQueueItem\\\": {\\n    \\\"accountExternalId\\\": \\\"15346280\\\",\\n    \\\"contactExternalId\\\": \\\"missed\\\",\\n    \\\"eventDate\\\": \\\"2021-01-27T10:25:00+00:00\\\",\\n    \\\"name\\\": \\\"Record Created\\\",\\n    \\\"allowDupes\\\": false,\\n    \\\"eventSource\\\": 2,\\n    \\\"attributes\\\": []\\n  },\\n  \\\"appKey\\\": \\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\n  \\\"requestUrl\\\": \\\"http://analytics.churnzero.net/i\\\",\\n  \\\"requestPostData\\\": \\\"{\\\\n  \\\\\\\"appKey\\\\\\\": \\\\\\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\\\\\",\\\\n  \\\\\\\"contactExternalId\\\\\\\": \\\\\\\"missed\\\\\\\",\\\\n  \\\\\\\"accountExternalId\\\\\\\": \\\\\\\"15346280\\\\\\\",\\\\n  \\\\\\\"action\\\\\\\": \\\\\\\"trackEvent\\\\\\\",\\\\n  \\\\\\\"name\\\\\\\": \\\\\\\"Record Created\\\\\\\",\\\\n  \\\\\\\"eventDate\\\\\\\": \\\\\\\"2021-01-27T10:25Z\\\\\\\",\\\\n  \\\\\\\"recordId\\\\\\\": 123\\\\n}\\\",\\n  \\\"messageDate\\\": \\\"2021-01-27T00:13:10.8240941+00:00\\\",\\n  \\\"attemptCount\\\": 0,\\n  \\\"requestId\\\": \\\"47b0521e-4124-4d74-a05d-543964a7cef6\\\"\\n}\"},{\"logId\":\"85db215b-b9ab-4553-a503-95b26fa037e3\",\"source\":\"eventProcessQueue\",\"tenantId\":2378,\"createdDate\":\"2021-01-27T00:12:57.1337586Z\",\"processedDate\":\"2021-01-27T00:12:57.1337586Z\",\"success\":false,\"errorMessage\":\"ContactExternalId parameter must be defined.\",\"requestUrl\":\"http://analytics.churnzero.net/i\",\"requestPostData\":\"{\\n  \\\"appKey\\\": \\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\n  \\\"contactExternalId\\\": \\\"\\\",\\n  \\\"accountExternalId\\\": \\\"15346280\\\",\\n  \\\"action\\\": \\\"trackEvent\\\",\\n  \\\"name\\\": \\\"Record Created\\\",\\n  \\\"eventDate\\\": \\\"2021-01-27T10:25Z\\\",\\n  \\\"recordId\\\": 123\\n}\",\"userNotified\":true,\"eventSource\":\"BasicHttp\",\"entityId\":null,\"sourceId\":null,\"logDate\":\"2021-01-27T00:12:57.1337583+00:00\",\"input\":\"{\\\"customFields\\\":{},\\\"attributes\\\":{},\\\"appKey\\\":\\\"1!vmyVtrgzYXa4lSCiL8GgLwHi0Y1lxKk45IVhwf3kWnMt94A\\\",\\\"contactExternalId\\\":\\\"\\\",\\\"accountExternalId\\\":\\\"15346280\\\",\\\"action\\\":\\\"trackEvent\\\",\\\"name\\\":\\\"Record Created\\\",\\\"eventDate\\\":\\\"2021-01-27T10:25Z\\\",\\\"recordId\\\":123}\"}]}"
        HttpResponse<String> response;
        String path =  "https://keepersecurity-dev.us1app.churnzero.net/api/v1/devLogs?lastMinutes=1440&source=eventProcessQueue";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response != null) {
            System.out.println(response.body());
        }*/
/*        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(1580515199000L);*/

        String [] key = "1!yCKmh06p6V6thoDimy4mkxYt7NjURyXn2WLdpVDxb6L6GKFAEwLeGfPKyAt94A".split("!");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key[0]).append('\\').append('!').append(key[1]);

        System.out.println(stringBuilder.toString());
    }
}
