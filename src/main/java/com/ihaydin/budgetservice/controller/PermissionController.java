package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.PermissionDto;
import com.ihaydin.budgetservice.model.Permission;
import com.ihaydin.budgetservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@RestController
@RequestMapping("/")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permissions/{id}")
    public ResponseEntity<PermissionDto> getPermission(@PathVariable Long id) {
        Optional<PermissionDto> permissionDtoId = permissionService.findById(id);
        PermissionDto permissionDtoModel = null;
        if (permissionDtoId.isPresent()) {
            permissionDtoModel = permissionDtoId.get();
        }
        return ResponseEntity.ok(permissionDtoModel);
    }

    @PutMapping("/permissions/{id}")
    public ResponseEntity<PermissionDto> updatePermission(@PathVariable Long id, @RequestBody Permission permission) {
        Optional<PermissionDto> permissionDtoId = permissionService.findById(id);
        PermissionDto permissionDtoModel = null;
        if (permissionDtoId.isPresent()) {
            permissionDtoModel = permissionDtoId.get();
        }
        assert permissionDtoModel != null;
        permissionDtoModel.setNotification(permission.isNotification());
        permissionDtoModel.setMarketing(permission.isMarketing());
        PermissionDto updatedPermission = permissionService.updatePermission(permissionDtoModel);
        return ResponseEntity.ok(updatedPermission);
    }

}
