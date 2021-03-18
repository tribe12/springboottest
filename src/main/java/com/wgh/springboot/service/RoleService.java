package com.wgh.springboot.service;

import com.wgh.springboot.bean.Role;

/**
 * Created by wgh on 2021/3/17.
 */
public interface RoleService {
    public Role insert(Role role);

    public void delete(long stunum);

    public Role update(Role role);

    public Role findOne(long stunum);
}
