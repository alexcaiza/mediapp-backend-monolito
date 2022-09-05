package com.mitocode.repo;

import com.mitocode.model.Role;

public interface IRoleRepo extends IGenericRepo<Role, Integer>  {

	//from role where name = ?
	//Derived Query
	Role findOneByName(String name);
}
