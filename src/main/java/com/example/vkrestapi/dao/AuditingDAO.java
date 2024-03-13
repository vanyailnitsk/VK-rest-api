package com.example.vkrestapi.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auditing")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditingDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String userRoles;
    private String uri;
    private String method;
    private Boolean hasAccess;
    private String param;

}
