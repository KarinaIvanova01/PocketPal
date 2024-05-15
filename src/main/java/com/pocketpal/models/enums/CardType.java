package com.pocketpal.models.enums;

public enum CardType {
    Credit,
    Debit,
    None;

    @Override
    public String toString() {
        return switch (this) {
            case Credit -> "Credit";
            case Debit -> "Debit";
            case None -> "None";
        };
    }
}