package dto;


public class SitterProfileHome {
    private String title;
    private double payPerHour;
    private double expectedPay;
    private String status;
    private int applicationId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public double getExpectedPay() {
        return expectedPay;
    }

    public void setExpectedPay(double expectedPay) {
        this.expectedPay = expectedPay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}