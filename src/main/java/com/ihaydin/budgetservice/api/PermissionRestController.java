package com.ihaydin.budgetservice.api;

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
public class PermissionRestController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permission/{id}")
    public ResponseEntity<Permission> getPermission(@PathVariable Long id) {
        Optional<Permission> permissionId = permissionService.findById(id);
        Permission permissionModel = null;
        if (permissionId.isPresent()) {
            permissionModel = permissionId.get();
        }
        return ResponseEntity.ok(permissionModel);
    }

    @PutMapping("permission/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission permission) {
        Optional<Permission> permissionId = permissionService.findById(id);
        Permission permissionModel = null;
        if (permissionId.isPresent()) {
            permissionModel = permissionId.get();
        }
        assert permissionModel != null;
        permissionModel.setNotification(permission.isNotification());
        permissionModel.setMarketing(permission.isMarketing());
        Permission updatedPermission = permissionService.updatePermission(permissionModel);
        return ResponseEntity.ok(updatedPermission);
    }

}
