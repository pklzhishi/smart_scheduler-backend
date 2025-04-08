package org.example.smart_schedulerbackend.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class User {
    @NotNull(message = "ID 不能为空")
    private String id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 3, max = 50, message = "用户名长度必须在 3 到 50 个字符之间")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, message = "密码长度至少为 6 个字符")
    private String password;

    @Size(max = 50, message = "昵称长度最多为 50 个字符")
    private String nickName;

    @URL(message = "头像 URL 必须是一个有效的 URL")
    private String avatarUrl;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "电话号码必须是一个有效的电话号码")
    private String phone;

    @Email(message = "电子邮件地址必须是一个有效的电子邮件格式")
    private String email;

    @NotNull(message = "状态不能为空")
    @Size(max = 20, message = "状态长度最多为 20 个字符")
    private String status;

    @NotNull(message = "是否删除不能为空")
    @Min(value = 0, message = "是否删除必须是 0 或 1")
    @Max(value = 1, message = "是否删除必须是 0 或 1")
    private Integer isDeleted;

    @NotNull(message = "创建时间不能为空")
    private LocalDateTime createTime;

    @NotNull(message = "更新时间不能为空")
    private LocalDateTime updateTime;

    @Size(max = 50, message = "身份长度最多为 50 个字符")
    private String identity;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "电话号码必须是一个有效的电话号码")
    private String telephoneNumber;

    @Size(max = 50, message = "班级名称长度最多为 50 个字符")
    private String className;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
