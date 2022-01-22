package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.PermissionDto;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface PermissionService {
    Optional<PermissionDto> findById(Long id);
    PermissionDto updatePermission(PermissionDto permissionDto);
}
