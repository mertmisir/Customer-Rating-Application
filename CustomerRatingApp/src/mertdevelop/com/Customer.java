package mertdevelop.com;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

public class Customer {
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getOrigin() {
        if(origin == null) { // in case when the exception will be executed, the origin output should not display null
            origin = " ";
        }
        return origin;
    }
    public void setOrigin(String origin) {
        try {

            if(origin.equals("EU")) {
                origin.equals("EU");
                R = 1; // Rating offset R is 1 whenever the customer's origin is EU
            } else if(origin.equals("US/CA")) {
                origin.equals("US/CA");
                R = 2; // Rating offset R is 2 whenever the customer's origin is US/CA
            } else if(origin.equals("Europe (None-EU)")) {
                origin.equals("Europe (None-EU)");
                R = 3; // Rating offset R is 3 whenever the customer's origin is Europe (None-EU)
            } else if (origin.equals("Others")) {
                origin.equals("Others");
                R = 4; // Rating offset R is 4 whenever the customer's origin is Others
            } else {
                throw new Exception("You have entered the country of origin wrong!");
            }

            this.origin = origin;

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String getResidence() {
        if(residence == null) { // in case when the exception will be executed, the residence output should not display null
            residence = " ";
        }
        return residence;
    }
/*
    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", origin='" + origin + '\'' +
                ", residence='" + residence + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", rating=" + rating +
                ", R=" + R +
                ", creationDate=" + creationDate +
                '}';
    }
    */

    public void setResidence(String residence) {
        try {

            if(residence.equals("EU")) {
                residence.equals("EU");
            } else if(residence.equals("US/CA")) {
                residence.equals("US/CA");
            } else if(residence.equals("Europe (None-EU)")) {
                residence.equals("Europe (None-EU)");
            } else if (residence.equals("Others")) {
                residence.equals("Others");
            } else {
                throw new Exception("You have entered the residence wrong!");
            }

            this.residence = residence;

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(int year, int month, int day) {
        dateOfBirth = LocalDate.of(year, month, day);
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        try {
            if(!sex.contains("Male") && !sex.contains("Female")) {
                throw new Exception("You have entered sex wrong!"); //Exception in case user enters wrong sex rather than Male or Female or typo
            }
            this.sex = sex;

        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public double getRating() {
        LocalDate currentDate = LocalDate.now(); // get the current date in (y,m,d) format
        Integer AGE = currentDate.getYear() - dateOfBirth.getYear(); //in order to calculate the customer's AGE value
        rating = (Math.sqrt(0.33 * 3.14 * R) + Math.sqrt(0.1 * AGE) + Math.pow(1 - R, 2)) / (0.25 * (1 + R));

        //set the customer rating according to the conditions below:
        if(origin.equals("EU") && residence.equals("US/CA") && (AGE < 75)) {
            rating += rating * 0.05;
        } else if(origin.equals("EU") && !residence.equals("US/CA") && !residence.equals("EU") && (AGE < 75)) {
            rating += rating * 0.20;
        } else if(origin.equals("US/CA") && residence.equals("EU") && (AGE < 75)) {
            rating += rating * 0.10;
        } else if(origin.equals("US/CA") && !residence.equals("US/CA") && !residence.equals("EU") && (AGE < 75)) {
            rating += rating * 0.25;
        } else if((origin.equals("Europe (None-EU)")) && (residence.equals("US/CA") || residence.equals("EU")) && (AGE < 75)) {
            rating -= rating * 0.10;
        } else if(origin.equals("Europe (None-EU)") && residence.equals("Others") && (AGE < 75)) {
            rating += rating * 0.25;
        } else if((origin.equals("Others")) && (residence.equals("US/CA") || residence.equals("EU")) && (AGE < 75)) {
            rating -= rating * 0.25;
        } else if(origin.equals("Others") && residence.equals("Europe (None-EU)") && (AGE < 75)) {
            rating -= rating * 0.10;
        } else if((sex.equals("Male")) && (residence.equals("EU") || residence.equals("US/CA")) && (AGE > 75)) {
            rating = 5.0;
        } else if((sex.equals("Female")) && (residence.equals("EU") || residence.equals("US/CA")) && (AGE > 75)) {
            rating = 3.0;
        }

        // to check the final rating as it should not be less than 1 or greater than 10:
        Double finalRating = rating;
        if(finalRating > 1 && finalRating < 10) {
            return finalRating;
        } else {
            System.out.println("Final rating of this customer either exceed 10 or less than 1!");
            return rating;
        }
    }

    // to retrieve the current time in a way that SQL supports (Timestamp):
    public void setCreationDate() {
        this.creationDate = Timestamp.from(Instant.now());
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public Integer getOffsetR() {
        return R;
    }
    private Integer ID;
    private String userName;
    private String origin;
    private String residence;
    private LocalDate dateOfBirth;
    private String sex;
    private Double rating;
    private Integer R; // to hold the rating offset value
    private Timestamp creationDate; // to hold the date and time in a format (Timestamp) that SQL supports!
}
