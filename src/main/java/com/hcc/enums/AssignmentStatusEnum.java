package com.hcc.enums;

public enum AssignmentStatusEnum {
    CURRENTLY_WORKING("Currently Working", 1),
    SUBMITTED("Submitted", 2),
    REVIEW_IN_PROGRESS("Review In Progress", 3),
    COMPLETED("Completed", 4),
    REJECTED("Rejected", 5),
    RESUBMITTED("Resubmitted", 6);

    private String status;
    private Integer option;
    AssignmentStatusEnum(String status, Integer option) {
        this.status = status;
        this.option = option;
    }

    public String getStatus() {
        return status;
    }

    public Integer getOption() {
        return option;
    }
}
