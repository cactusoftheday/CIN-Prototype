package com.example.cinprototype;

public class ImprovementModel {
    private boolean helpful;
    private boolean decisionChange;
    private String suggestions;

    public ImprovementModel(boolean helpful, boolean decisionChange, String suggestions) {
        this.helpful = helpful;
        this.decisionChange = decisionChange;
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "ImprovementModel{" +
                "helpful=" + helpful +
                ", decisionChange=" + decisionChange +
                ", suggestions='" + suggestions + '\'' +
                '}';
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
