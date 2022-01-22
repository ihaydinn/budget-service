package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.PermissionDto;
import com.ihaydin.budgetservice.mappers.PermissionMapper;
import com.ihaydin.budgetservice.mappers.impl.PermissionMapperImpl;
import com.ihaydin.budgetservice.model.Permission;
import com.ihaydin.budgetservice.repository.PermissionRepository;
import com.ihaydin.budgetservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    private static PermissionMapper permissionMapper = PermissionMapperImpl.getInstance();

    @Override
    public Optional<PermissionDto> findById(Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        return permissionMapper.toOptionalDto(permission);
    }

    @Override
    public PermissionDto updatePermission(PermissionDto permissionDto) {
        Permission permission = permissionMapper.toEntity(permissionDto);
        Permission updated = permissionRepository.save(permission);
        return permissionMapper.toDto(updated);
    }
}
