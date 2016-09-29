package com.domain.service.reservation;

/**
 * Created by nishina on 2016/09/29.
 */
public class UnavailableReservationException extends RuntimeException {
    public UnavailableReservationException(String message) {
        super(message);
    }
}
