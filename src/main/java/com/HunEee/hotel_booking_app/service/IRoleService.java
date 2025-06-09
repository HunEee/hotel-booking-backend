package com.HunEee.hotel_booking_app.service;

import java.util.List;

import com.HunEee.hotel_booking_app.model.Role;
import com.HunEee.hotel_booking_app.model.User;

public interface IRoleService {
    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);
}
