package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Role;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IRoleRepo;
import com.mitocode.service.IRoleService;

@Service
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {

	@Autowired
	private IRoleRepo repo;

	@Override
	protected IGenericRepo<Role, Integer> getRepo() {
		return repo;
	}

	@Override
	public Role loadRoleByName(String name) {
		return repo.findOneByName(name);
	}
}
