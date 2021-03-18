package com.wgh.springboot.service.impl;

import com.wgh.springboot.bean.Role;
import com.wgh.springboot.service.RoleService;

/**
 * Created by wgh on 2021/3/17.
 */
//@Service
public class RoleServiceImpl implements RoleService {
//    @Autowired
//    private RoleRepository roleRepository;

    @Override
    public Role insert(Role role) {
//        return this.roleRepository.save(role);
        return null;
    }

    @Override
    public void delete(long stunum) {
//        this.roleRepository.delete(1);
    }

    @Override
    public Role update(Role role) {
//        return this.roleRepository.save(role);
        return null;
    }

    @Override
    public Role findOne(long stunum) {
//        return this.roleRepository.findOne(1);
        return null;
    }
}
