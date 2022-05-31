package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {

//    UserDTO findOneByUserNameAndStatus(String name, int status);
//    List<UserDTO> getUsers(String searchValue, Pageable pageable);
//    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws Exception;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);

}
