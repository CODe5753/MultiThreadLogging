package com.example.multithreadlogging;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BookingDto {

    String bookId;
    String seatId;
}
