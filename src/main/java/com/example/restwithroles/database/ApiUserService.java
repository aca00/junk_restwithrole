package com.example.restwithroles.database;

import com.example.restwithroles.database.entity.ApiRole;
import com.example.restwithroles.database.entity.ApiUser;
import com.example.restwithroles.database.entity.ApiUserToRoles;
import com.example.restwithroles.database.repository.ApiRoleRepository;
import com.example.restwithroles.database.repository.ApiUserRepository;
import com.example.restwithroles.database.repository.ApiUserToRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ApiUserService implements UserDetailsService {
    private final ApiUserRepository apiUserRepository;
    private final ApiRoleRepository apiRoleRepository;
    private final ApiUserToRolesRepository apiUserToRolesRepository;

    @Autowired
    public ApiUserService(ApiUserRepository apiUserRepository, ApiRoleRepository apiRoleRepository, ApiUserToRolesRepository apiUserToRolesRepository) {
        this.apiUserRepository = apiUserRepository;
        this.apiRoleRepository = apiRoleRepository;
        this.apiUserToRolesRepository = apiUserToRolesRepository;
    }

    public ApiUser getApiUserFromName(String name) throws Exception {
        ApiUser apiUser = apiUserRepository.getByName(name);
        if (apiUser == null) {
            throw new Exception("Couldn't find user with name" + name);
        }
        return apiUser;
    }

    public Collection<GrantedAuthority> getRolesOfGivenUser(ApiUser user) {
        Collection<GrantedAuthority> roles = new ArrayList<>();
        List<Integer> roleIds = apiUserToRolesRepository.getRolesFromUserId(user.getUserId());
        for (int roleId : roleIds) {
            roles.add(new SimpleGrantedAuthority(apiRoleRepository.getRole(roleId).getRoleDescription()));
        }
        return roles;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUser user = null;
        try {
            user = getApiUserFromName(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new User(user.getUserName(), user.getPassword(), getRolesOfGivenUser(user));
    }
}
