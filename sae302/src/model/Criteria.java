package model;

public class Criteria {
    
    // class attributes
    private String criteriaX;
    private String criteriaY;

    // constructor(s)
    public Criteria(String criteriaX, String criteriaY) {
        this.criteriaX = criteriaX;
        this.criteriaY = criteriaY;
    }

    // methods
    public String getCriteriaX() {
        return criteriaX;
    }

    public void setCriteriaX(String criteriaX) {
        this.criteriaX = criteriaX;
    }

    public String getCriteriaY() {
        return criteriaY;
    }

    public void setCriteriaY(String criteriaY) {
        this.criteriaY = criteriaY;
    }

}
