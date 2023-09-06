package com.example.restwithroles.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "APIROLE")
public class ApiRole {
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_desc")
    private String roleDescription;

    public ApiRole() {}

    public ApiRole(int roleId, String roleDescription) {
        this.roleId = roleId;
        this.roleDescription = roleDescription;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "ApiRole{" +
                "roleId=" + roleId +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
