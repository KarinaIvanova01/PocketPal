package com.pocketpal.models.enums;

public enum StatusType {
    Active, Disabled, Blocked, Unverified, Pending, Waiting;

    @Override
    public String toString() {
        return switch (this) {
            case Active -> "Active";
            case Disabled -> "Disabled";
            case Blocked -> "Blocked";
            case Unverified -> "Unverified";
            case Pending -> "Pending";
            case Waiting -> "Waiting";
        };
    }
}