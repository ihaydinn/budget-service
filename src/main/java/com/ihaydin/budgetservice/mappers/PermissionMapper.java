package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.PermissionDto;
import com.ihaydin.budgetservice.model.Permission;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */
public interface PermissionMapper {
    Permission toEntity(PermissionDto permissionDto);
    PermissionDto toDto(Permission permission);
    Optional<PermissionDto> toOptionalDto(Optional<Permission> optionalPermission);
}
