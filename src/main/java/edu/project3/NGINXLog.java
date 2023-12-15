package edu.project3;

import java.time.OffsetDateTime;

public record NGINXLog(String address, String user, OffsetDateTime timeLocal, ServerRequest request, int response,
                       byte BodyBytesSent, String httpReferer, String httpUserAgent) {
    //'$remote_addr - $remote_user [$time_local] ' '"$request" $status $body_bytes_sent ' '"$http_referer" "$http_user_agent"
    //210.245.80.75 -      -  [17/May/2015:08:05:32 +0000] "GET /downloads/product_2 HTTP/1.1" 304 0 "-" "Debian APT-HTTP/1.3 (1.0.1ubuntu2)"
}
