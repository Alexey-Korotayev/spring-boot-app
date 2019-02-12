package com.epam.springbootapp.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_project")
public class ProjectJPA {
    @Id
    @Column(name = "project_id")
    private String projectId;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "customer")
    private String customer;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "status")
    private String status;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectJPA that = (ProjectJPA) o;

        if (!projectId.equals(that.projectId)) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = projectId.hashCode();
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProjectJPA{");
        sb.append("projectId='").append(projectId).append('\'');
        sb.append(", projectCode='").append(projectCode).append('\'');
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", customer='").append(customer).append('\'');
        sb.append(", customerId='").append(customerId).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
