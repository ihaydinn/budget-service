package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Permission;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface PermissionService {
    Optional<Permission> findById(Long id);
    Permission updatePermission(Permission permission);
}
