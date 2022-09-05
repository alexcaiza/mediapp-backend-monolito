package com.mitocode.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.MenuDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Menu;
import com.mitocode.model.Role;
import com.mitocode.service.IMenuService;
import com.mitocode.service.IRoleService;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IMenuService service;
    
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getAllMenus() throws Exception{
        List<Menu> menus = service.findAll();
        List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
        return new ResponseEntity<>(menusDTO, HttpStatus.OK);
    }

    //@GetMapping("/user")
    @PostMapping("/user")
    public ResponseEntity<List<MenuDTO>> getMenusByUser(@RequestBody String username) throws Exception{
        List<Menu> menus = service.getMenusByUsername(username);
        List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
        return new ResponseEntity<>(menusDTO, HttpStatus.OK);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<Role> loadRoleByName(@PathVariable("name") String name) throws Exception {    	
    	Role role = roleService.loadRoleByName(name);
        if(role == null){
            throw new ModelNotFoundException("ROLE NOT FOUND: " + name);
        }        
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
