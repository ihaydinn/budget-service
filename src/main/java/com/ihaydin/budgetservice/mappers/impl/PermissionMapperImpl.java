package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.PermissionDto;
import com.ihaydin.budgetservice.mappers.PermissionMapper;
import com.ihaydin.budgetservice.model.Permission;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

public final class PermissionMapperImpl implements PermissionMapper {

    private static PermissionMapperImpl instance = new PermissionMapperImpl();

    public static PermissionMapperImpl getInstance() {
        return instance;
    }

    private PermissionMapperImpl() {
    }

    @Override
    public Permission toEntity(PermissionDto permissionDto) {
        Permission permission = new Permission();
        permission.setId(permissionDto.getId());
        permission.setNotification(permissionDto.isNotification());
        permission.setMarketing(permissionDto.isMarketing());
        return permission;
    }

    @Override
    public PermissionDto toDto(Permission permission) {
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setId(permission.getId());
        permissionDto.setNotification(permission.isNotification());
        permissionDto.setMarketing(permission.isMarketing());
        return permissionDto;
    }

    @Override
    public Optional<PermissionDto> toOptionalDto(Optional<Permission> optionalPermission) {
        Permission permission = optionalPermission.get();
        return Optional.of(this.toDto(permission));
    }
}
