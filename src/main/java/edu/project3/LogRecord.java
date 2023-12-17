package edu.project3;

import java.time.OffsetDateTime;

public record LogRecord(String address,
                        String user,
                        OffsetDateTime timeLocal,
                        ServerRequestRecord request,
                        int response,
                        int BodyBytesSent,
                        String httpReferer,
                        String httpUserAgent) {
}
