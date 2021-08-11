package com.isaac.cinprototype;

public class ImprovementModel {
    private boolean helpful;
    private boolean decisionChange;
    private String suggestions;
    private String profession;
    private int years;
    private String platform;
    private String training;

    public ImprovementModel(boolean helpful, boolean decisionChange, String profession, String training, int years, String suggestions, String platform) {
        this.helpful = helpful;
        this.decisionChange = decisionChange;
        this.suggestions = suggestions;
        this.profession = profession;
        this.training = training;
        this.years = years;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "ImprovementModel{" +
                "helpful=" + helpful +
                ", decisionChange=" + decisionChange +
                ", suggestions='" + suggestions + '\'' +
                ", profession='" + profession + '\'' +
                ", years=" + years +
                ", platform='" + platform + '\'' +
                ", training='" + training + '\'' +
                '}';
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public ImprovementModel() {
    }

    public boolean isHelpful() {
        return helpful;
    }

    public boolean isDecisionChange() {
        return decisionChange;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setHelpful(boolean helpful) {
        this.helpful = helpful;
    }

    public void setDecisionChange(boolean decisionChange) {
        this.decisionChange = decisionChange;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
}
