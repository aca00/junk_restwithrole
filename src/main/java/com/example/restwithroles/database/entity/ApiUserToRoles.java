package com.example.restwithroles.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "APIUSER_TO_ROLES")
public class ApiUserToRoles {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Id
    @Column(name = "role_id")
    private int roleId;

    public ApiUserToRoles() {}

    public ApiUserToRoles(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ApiUserToRoles{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
