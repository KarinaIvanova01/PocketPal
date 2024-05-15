package com.pocketpal.models.enums;

public enum CurrencyType {
    BGN, EUR, USD;

    @Override
    public String toString() {
        return switch (this) {
            case BGN -> "BGN";
            case EUR -> "EUR";
            case USD -> "USD";
        };
    }
}
