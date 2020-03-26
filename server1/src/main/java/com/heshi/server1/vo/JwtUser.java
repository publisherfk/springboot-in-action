package com.heshi.server1.vo;

public class JwtUser {
    private Long companyId;
    private Long userId;
    private Long staffId;
    private String staffCode;
    private String staffName;
    private String language;

    public JwtUser(Long companyId, Long userId, Long staffId, String staffCode, String staffName, String language) {
        this.companyId = companyId;
        this.userId = userId;
        this.staffId = staffId;
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.language = language;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "companyId=" + companyId +
                ", userId=" + userId +
                ", staffId=" + staffId +
                ", staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
