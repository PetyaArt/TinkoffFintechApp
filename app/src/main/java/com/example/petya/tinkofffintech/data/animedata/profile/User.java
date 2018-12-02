
package com.example.petya.tinkofffintech.data.animedata.profile;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.TypeConverters;

import com.example.petya.tinkofffintech.data.source.DataTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("birthday")
    @Expose
    @ColumnInfo(name = "birthday")
    private String birthday;

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "email")
    private String email;

    @SerializedName("first_name")
    @Expose
    @ColumnInfo(name = "first_name")
    private String firstName;

    @SerializedName("last_name")
    @Expose
    @ColumnInfo(name = "last_name")
    private String lastName;

    @SerializedName("middle_name")
    @Expose
    @ColumnInfo(name = "middle_name")
    private String middleName;

    @SerializedName("phone_mobile")
    @Expose
    @ColumnInfo(name = "phone_mobile")
    private String phoneMobile;

    @SerializedName("t_shirt_size")
    @Expose
    @ColumnInfo(name = "t_shirt_size")
    private String tShirtSize;

    @SerializedName("is_client")
    @Expose
    @ColumnInfo(name = "is_client")
    private Boolean isClient;

    @SerializedName("skype_login")
    @Expose
    @ColumnInfo(name = "skype_login")
    private String skypeLogin;

    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("region")
    @Expose
    @ColumnInfo(name = "firegionrst_name")
    private String region;

    @SerializedName("school")
    @Expose
    @ColumnInfo(name = "school")
    private String school;

    @SerializedName("school_graduation")
    @Expose
    @ColumnInfo(name = "school_graduation")
    private String schoolGraduation;

    @SerializedName("university")
    @Expose
    @ColumnInfo(name = "university")
    private String university;

    @SerializedName("faculty")
    @Expose
    @ColumnInfo(name = "faculty")
    private String faculty;

    @SerializedName("university_graduation")
    @Expose
    @ColumnInfo(name = "university_graduation")
    private Integer universityGraduation;

    @SerializedName("grade")
    @Expose
    @ColumnInfo(name = "grade")
    private String grade;

    @SerializedName("department")
    @Expose
    @ColumnInfo(name = "department")
    private String department;

    @SerializedName("current_work")
    @Expose
    @ColumnInfo(name = "current_work")
    private String currentWork;

    @SerializedName("resume")
    @Expose
    @ColumnInfo(name = "resume")
    private String resume;

    @TypeConverters(DataTypeConverter.class)
    @SerializedName("notifications")
    @Expose
    @ColumnInfo(name = "notifications")
    private List<String> notifications = null;

    @SerializedName("idUser")
    @Expose
    @ColumnInfo(name = "idUser")
    private int id;

    @SerializedName("admin")
    @Expose
    @ColumnInfo(name = "admin")
    private Boolean admin;

    @SerializedName("avatar")
    @Expose
    @ColumnInfo(name = "avatar")
    private String avatar;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getTShirtSize() {
        return tShirtSize;
    }

    public void setTShirtSize(String tShirtSize) {
        this.tShirtSize = tShirtSize;
    }

    public Boolean getIsClient() {
        return isClient;
    }

    public void setIsClient(Boolean isClient) {
        this.isClient = isClient;
    }

    public String getSkypeLogin() {
        return skypeLogin;
    }

    public void setSkypeLogin(String skypeLogin) {
        this.skypeLogin = skypeLogin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolGraduation() {
        return schoolGraduation;
    }

    public void setSchoolGraduation(String schoolGraduation) {
        this.schoolGraduation = schoolGraduation;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getUniversityGraduation() {
        return universityGraduation;
    }

    public void setUniversityGraduation(Integer universityGraduation) {
        this.universityGraduation = universityGraduation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCurrentWork() {
        return currentWork;
    }

    public void setCurrentWork(String currentWork) {
        this.currentWork = currentWork;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
