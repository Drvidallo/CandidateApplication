package com.springboot.model.enums;

public enum RecommendationEnum {
	NA("Not Applicable"),
	PROCEED("Proceed with JO Simulation"),
    FAILED("Do not Proceed"),
    FURTHER_SCREENING("For Further Screening");

    private final String description;

    RecommendationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}


